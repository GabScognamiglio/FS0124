import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ActivePostsRoutingModule } from './active-posts-routing.module';
import { ActivePostsComponent } from './active-posts.component';
import { PostCardComponent } from '../post-card/post-card.component';


@NgModule({
  declarations: [ActivePostsComponent, PostCardComponent],
  imports: [
    CommonModule,
    ActivePostsRoutingModule,
  ]
})
export class ActivePostsModule { }
