import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../interfaces/user.interface';


@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl:string='http://localhost:3000/users';

  users:User[]=[]

  
  constructor(private http:HttpClient) { }

  getUsers(){
    return this.http.get<User[]>(this.apiUrl)
  }


}
