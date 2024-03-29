import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodosService } from 'src/app/services/todos.service';

@Component({
  selector: 'app-incompleted-todos',
  templateUrl: './incompleted-todos.component.html',
  styleUrls: ['./incompleted-todos.component.scss']
})
export class IncompletedTodosComponent {
  sub!: Subscription
  incompleted: Todo[] = []
  todos: Todo[] = []

  constructor(private todoSrv: TodosService) { }

  ngOnInit(): void {
    this.getIncompleted()
  }

  getIncompleted(){
    this.sub = this.todoSrv.getTodos().subscribe((res) => {
      this.todos = res
      this.incompleted=this.todos.filter((todo)=> !todo.completed)
      // console.log(this.incompleted)
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
