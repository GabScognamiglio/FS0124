import { Component} from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { ActivatedRoute,} from '@angular/router';

@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.scss']
})
export class PostDetailsComponent {
  idCercato!: string|any;
  // numIdCercato!:number|any;
  post!:Post|any
  posts!:Post[]

    // constructor(private route: ActivatedRoute) {
  //   this.idCercato = this.route.snapshot.paramMap.get('id');
  //   console.log(this.idCercato);
  //   this.getDetails().then((data)=>{
  //     console.log(data);
  //     this.posts = data;
  //     this.numIdCercato=parseInt(this.idCercato)
  //     this.post = this.posts.find(oggetto => oggetto.id === this.numIdCercato)
  //     console.log(this.post)
  //   })
  // }

  // async getDetails() {
  //   const response = await fetch('../../assets/db.json/');
  //   const data = await response.json();
  //   return data;
  // }
  
  constructor(private route: ActivatedRoute) {
    this.idCercato = this.route.snapshot.paramMap.get('id');
    console.log(this.idCercato);
    this.getDetails().then((data)=>{
      console.log(data);
      this.post = data
    })
  }

  async getDetails() {
    const response = await fetch('http://localhost:3000/' + (parseInt(this.idCercato)-1));
    const data = await response.json();
    return data;
  }
}




