import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CompletedTodosComponent } from './components/completed-todos/completed-todos.component';
import { IncompletedTodosComponent } from './components/incompleted-todos/incompleted-todos.component';
import { UsersComponent } from './components/users/users.component';
import { FormsModule } from '@angular/forms';
import { UserTasksComponent } from './components/user-tasks/user-tasks.component';
import { NewTaskComponent } from './components/new-task/new-task.component';

const routes: Route[] = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "completed",
    component: CompletedTodosComponent
  },
  {
    path: "incompleted",
    component: IncompletedTodosComponent
  },
  {
    path: "users",
    component: UsersComponent
  },
  {
    path: "newTask",
    component: NewTaskComponent
  },
  {
    path: "**",
    component: HomeComponent
  }

]
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CompletedTodosComponent,
    IncompletedTodosComponent,
    UsersComponent,
    HomeComponent,
    UserTasksComponent,
    NewTaskComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
