import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((posts) => {
      this.posts = posts;
    })
  }
  async getPosts() {
    let response = await fetch('assets/db.json');
    let data = await response.json();
    return data;
  }

}
