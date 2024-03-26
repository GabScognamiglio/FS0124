import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostInterface } from 'src/interfaces/post.interface';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent implements OnInit {
  post!: PostInterface | any;
  posts!:PostInterface[]

  constructor(private postSrv: PostService, private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.router.params.subscribe((params) => {
      const id = +params['id'];
      console.log(id);
      this.posts= this.postSrv.getPosts();
      this.post =this.posts.find(post=> post.id === id);
      console.log(this.post)      
    })
  }
}
