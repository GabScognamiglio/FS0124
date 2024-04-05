import { Injectable } from '@angular/core';
import { User } from '../interfaces/user.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UtentiService {

  apiURL = 'http://localhost:4201/users';

  constructor(private http: HttpClient) { }

  getUsers(){
    return this.http.get<User[]>(this.apiURL)
  }
}
