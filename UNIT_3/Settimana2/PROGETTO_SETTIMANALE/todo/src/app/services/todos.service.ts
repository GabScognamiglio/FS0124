import { Injectable } from '@angular/core';
import { Todo } from '../interfaces/todo.interface';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodosService {
  private apiUrl:string='http://localhost:3000/todo/'

  constructor(private http:HttpClient) { }

  getTodos(){
    return this.http.get<Todo[]>(this.apiUrl)
  }

  statusPatch(id:number, completed:boolean){
    this.http.patch(`http://localhost:3000/todo/${id}`, {"completed": completed} ).subscribe(response => {
      // Code to handle successful update
      console.log('Data updated successfully!', response);
    }, error => {
      // Code to handle errors
      console.error('Error updating data!', error);
    });
  
  }

  newTask(todo:Partial<Todo>){
    this.http.post(this.apiUrl, todo).subscribe(response => {
      console.log('Data updated successfully!', response);
    }, error => {
      console.error('Error updating data!', error);
    });
  }
}
