import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss']
})
export class ActivePostsComponent {
  posts!:Post[]
  activePosts!: Post[]

  constructor(){
    this.evidencePost().then(data=>{
      this.posts=data;
      this.activePosts= this.posts.filter((element)=>element.active===true)    
      
    })  
  }    
    

  

  async evidencePost() {
    const response = await fetch('../../assets/db.json');
    const data = await response.json();
    return data;
  }
}
