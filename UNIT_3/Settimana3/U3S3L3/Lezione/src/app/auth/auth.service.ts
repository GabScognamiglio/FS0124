import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../models/register.interface';
import { environment } from 'src/environments/environment.development';
import { AuthdData } from '../models/authd-data.interface';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiURL = environment.apiURL;

  //elementi per gestire la porcedura di login
  private authSub = new BehaviorSubject<AuthdData | null>(null)
  user$ = this.authSub.asObservable();

  constructor(private http: HttpClient, private router: Router) { }

  signup(data: Register) {
    return this.http.post(`${this.apiURL}register`, data)
  }

  login(data: { email: string, password: string }) {
    return this.http.post<AuthdData>(`${this.apiURL}login`, data).pipe(
      tap((data) => {
        console.log('auth data: ', data)
      }),
      tap((data) => {
        this.authSub.next(data);
        localStorage.setItem('user', JSON.stringify(data));
      }), catchError(this.errors)
    )
  }
  private errors(err:any){
    switch (err.error) {
      case 'Email already exists':
        return throwError('utente già presente');
        break;
      case 'Bad credentials':
        return throwError('username e/o password errate');
        break;
      default:
        return throwError ('errore generico')
    }
  }
}
