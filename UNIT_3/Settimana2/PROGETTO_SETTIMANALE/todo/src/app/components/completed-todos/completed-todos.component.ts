import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodosService } from 'src/app/services/todos.service';

@Component({
  selector: 'app-completed-todos',
  templateUrl: './completed-todos.component.html',
  styleUrls: ['./completed-todos.component.scss']
})
export class CompletedTodosComponent {
  sub!: Subscription
  completed: Todo[] = []
  todos: Todo[] = []

  constructor(private todoSrv: TodosService) { }

  ngOnInit(): void {
    this.getCompleted()
  }

  getCompleted(){
    this.sub = this.todoSrv.getTodos().subscribe((res) => {
      this.todos = res
      this.completed=this.todos.filter((todo)=> todo.completed)
      // console.log(this.completed)
    })
  }

  toggleStatus(id:number){
    const found = this.todos.find(todo=> todo.id===id)
    if(found) {
      found.completed=!found.completed;
      this.todoSrv.statusPatch(id, found.completed);
    }
  }
}
