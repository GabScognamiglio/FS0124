import { Component, Input, OnInit } from '@angular/core';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodosService } from 'src/app/services/todos.service';
import { Subscription, filter } from 'rxjs';


@Component({
  selector: 'app-user-tasks',
  templateUrl: './user-tasks.component.html',
  styleUrls: ['./user-tasks.component.scss']
})
export class UserTasksComponent implements OnInit {
  @Input() id!: number;
  todoSub!: Subscription
  todos!: Todo[]
  filteredTodos: Todo[] =[]

  constructor(private todoSrv: TodosService) { }

  ngOnInit(): void {
    this.todoSub = this.todoSrv.getTodos().subscribe((res) => {
      this.todos = res;
      this.retrieveTodos();
    })
    
  }

  retrieveTodos() {
    this.id = Number(this.id)
    this.filteredTodos=this.todos.filter(item=>item.userId===this.id);
    // console.log(this.filteredTodos)
  };

  toggleStatus(id:number){
    const found = this.todos.find(todo=> todo.id===id)
    if(found) {
      found.completed=!found.completed;
      this.todoSrv.statusPatch(id, found.completed);
    }
  }  
}
