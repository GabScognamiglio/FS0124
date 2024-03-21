import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent {
  posts!:Post[]
  inactivePosts!: Post[]

  constructor(){
    this.evidencePost().then(data=>{
      this.posts=data;
      this.inactivePosts= this.posts.filter((element)=>element.active===false)    
      // console.log(this.posts)
      // console.log(this.inactivePosts) 
    })  
  }    
    
  

  async evidencePost() {
    const response = await fetch('../../assets/db.json');
    const data = await response.json();
    return data;
  }

}
