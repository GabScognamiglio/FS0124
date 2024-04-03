import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ActivePostsRoutingModule } from './active-posts-routing.module';
import { ActivePostsComponent } from './active-posts.component';
import { PostCardComponent } from '../post-card/post-card.component';
import { EllipsisPipe } from 'src/app/pipes/ellipsis.pipe';


@NgModule({
  declarations: [ActivePostsComponent, PostCardComponent, EllipsisPipe],
  imports: [
    CommonModule,
    ActivePostsRoutingModule,
  ]
})
export class ActivePostsModule { }
