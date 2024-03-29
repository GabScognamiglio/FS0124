import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/user.interface';
import { UserService } from 'src/app/services/user.service';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodosService } from 'src/app/services/todos.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  userSub!: Subscription;
  users!: User[]

  todoSub!: Subscription
  todos!: Todo[]

  userTodos!: Todo[]

  constructor(private userSrv: UserService, private todoSrv: TodosService) {

  }

  ngOnInit(): void {
    this.retrieveUsers();
    this.retrieveTodos();
  }

  retrieveUsers(){
    this.userSub = this.userSrv.getUsers().subscribe((res) => {
      this.users = res;      
    });
  }

  retrieveTodos(){
    this.todoSub = this.todoSrv.getTodos().subscribe((res) => {
      this.todos = res;
      
    });
  }
}
