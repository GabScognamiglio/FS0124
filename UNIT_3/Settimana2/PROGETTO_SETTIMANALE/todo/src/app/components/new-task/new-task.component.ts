import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/user.interface';
import { UserService } from 'src/app/services/user.service';
import { Subscription } from 'rxjs';
import { TodosService } from 'src/app/services/todos.service';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.scss']
})
export class NewTaskComponent {
  userSub!: Subscription;
  users!: User[];

  nuovoTodo={
    todo:'',
    userId:'',
    completed:false
  }

  constructor(private userSrv: UserService, private todoSrv:TodosService) {  }

  ngOnInit(): void {
    this.retrieveUsers();
  }

  retrieveUsers(){
    this.userSub = this.userSrv.getUsers().subscribe((res) => {
      this.users = res;
    });
  }
  
  stampa(){
    console.log(this.nuovoTodo)
  }

  newTodo(nuovoTodo:any){
    this.todoSrv.newTask(nuovoTodo);
  }

}
