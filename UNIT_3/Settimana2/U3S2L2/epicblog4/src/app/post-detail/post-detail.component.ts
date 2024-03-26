import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss'],
})
export class PostDetailComponent implements OnInit {
  post!: PostInterface
  constructor() {

  }
  ngOnInit(): void {

  }
}
