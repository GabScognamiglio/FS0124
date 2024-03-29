import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodosService } from 'src/app/services/todos.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  sub!: Subscription
  todos: Todo[] = [];
  filteredItems!: Todo[];
  searchText!: string;

  constructor(private todoSrv: TodosService) { }

  ngOnInit(): void {
    this.sub = this.todoSrv.getTodos().subscribe((res) => {
      this.todos = res;
      this.filteredItems=this.todos
    })

  }

  filterItems(searchText: string) {
    this.filteredItems = this.todos.filter(todo => todo.todo.toLowerCase().includes(searchText.toLowerCase()));
    console.log(this.searchText)
    console.log(this.filteredItems)
  }

  toggleStatus(id:number){
    const found = this.todos.find(todo=> todo.id===id)
    if(found) {
      found.completed=!found.completed;
      this.todoSrv.statusPatch(id, found.completed);
    }
  }
}
