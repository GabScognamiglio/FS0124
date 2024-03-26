import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent implements OnInit {
  posts: PostInterface[] = []
  active!: PostInterface[]

  constructor(private postSrv: PostService) {}

  ngOnInit(): void {
    this.posts = this.postSrv.getPosts();
    this.active=this.posts.filter((post) => post.active)
    console.log(this.active)
  }

  // get activePosts(): PostInterface[] {
  //   return this.posts.filter((post) => post.active);
  // }
}
