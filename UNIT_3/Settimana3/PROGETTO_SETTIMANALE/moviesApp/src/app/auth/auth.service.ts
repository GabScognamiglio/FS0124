import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Signup } from '../interfaces/signup.interface';
import { AuthData } from '../interfaces/auth-data.interface';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiURL = 'http://localhost:4201/';
  jwtHelper = new JwtHelperService;

  //elementi per gestire la porcedura di login
  private authSub = new BehaviorSubject<AuthData | null>(null)
  user$ = this.authSub.asObservable();
  timeout: any;

  constructor(private http: HttpClient, private router: Router) { }

  signup(data: Signup) {
    return this.http.post(`${this.apiURL}register`, data)
  }

  login(data: { email: string, password: string }) {
    return this.http.post<AuthData>(`${this.apiURL}login`, data).pipe(
      tap((data) => {
        console.log('auth data: ', data)
      }),
      tap((data) => {
        this.authSub.next(data);
        localStorage.setItem('user', JSON.stringify(data));
        this.autologout(data)
      }), catchError(this.errors)
    )
  }
  private errors(err: any) {
    console.log(err.error)
    switch (err.error) {
      case 'Email already exists':
        return throwError('utente già presente');
        break;
      case 'Incorrect password':
        return throwError('password errata');
        break;
      case 'Cannot find user':
        return throwError('utente inesistente')
      default:
        return throwError('errore generico')
    }
  }

  logout() {
    this.authSub.next(null);
    localStorage.removeItem('user');
    this.router.navigate(['/login'])
  }

  restore() {
    const userJson = localStorage.getItem('user');
    if (!userJson) {
      return
    } else {
      const user: AuthData = JSON.parse(userJson)
      this.authSub.next(user);
      this.autologout(user)
    }
  }

  autologout(user: AuthData) {
    const dateExpiration = this.jwtHelper.getTokenExpirationDate(user.accessToken) as Date;
    const millisecondsExp = dateExpiration.getTime() - new Date().getTime();
    this.timeout = setTimeout(() => {
      this.logout();
    }, millisecondsExp);
  }
}
