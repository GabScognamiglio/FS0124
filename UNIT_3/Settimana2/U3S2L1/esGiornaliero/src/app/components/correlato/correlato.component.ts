import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-correlato',
  templateUrl: './correlato.component.html',
  styleUrls: ['./correlato.component.scss']
})
export class CorrelatoComponent {
  posts!:Post[]
  post!:Post
  constructor(){
    this.getPost().then((data) => {
      this.posts = data;
      // console.log(data);
      let index = Math.floor(Math.random() * this.posts.length);
      this.post = data[index];
    })
  }

  async getPost() {
    let response = await fetch('assets/db.json');
    let data = await response.json();
    return data
  }
}
