import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-laterale-card',
  templateUrl: './laterale-card.component.html',
  styleUrls: ['./laterale-card.component.scss']
})
export class LateraleCardComponent {
  
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
