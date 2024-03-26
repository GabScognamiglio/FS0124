import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent implements OnInit {
  posts: PostInterface[] = []

  inactive!: PostInterface[]

  constructor(private postSrv: PostService) {
    
  }

  ngOnInit(): void {
    this.posts = this.postSrv.getPosts();
    this.inactive=this.posts.filter((post) => !post.active)
    console.log(this.inactive)
  }


 }
