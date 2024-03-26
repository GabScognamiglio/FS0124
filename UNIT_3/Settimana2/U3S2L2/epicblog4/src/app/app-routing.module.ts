import { NgModule } from '@angular/core';
import { Route, RouterModule, Routes } from '@angular/router';
import { ActivePostsComponent } from './active-posts/active-posts.component';
import { InactivePostsComponent } from './inactive-posts/inactive-posts.component';
import { HomepageComponent } from './homepage/homepage.component';
import { PostDetailComponent } from './post-detail/post-detail.component';

const routes: Route[] = [
  {
    path: 'active',
    component: ActivePostsComponent,
  },
  {
    path: 'inactive',
    component: InactivePostsComponent,
  },
  {
    path: "post/:id",
    component: PostDetailComponent
  },
  {
    path: '',
    component: HomepageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
