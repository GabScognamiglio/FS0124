import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActivePostsComponent } from './active-posts.component';
import { PostDetailsComponent } from '../post-details/post-details.component';


const routes: Routes = [
  {
    path:'',
    component:ActivePostsComponent
  },
  {
    path: ':id',
    component: PostDetailsComponent,
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ActivePostsRoutingModule { }
