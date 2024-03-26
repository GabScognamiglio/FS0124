import { Component, ViewChild, ElementRef, Renderer2 } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { SinglePostComponent } from '../single-post/single-post.component';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent {
  post!: PostInterface
  related: PostInterface[] = [];
  posts: PostInterface[] = this.postSrv.getPosts();
  allTags = ['american', 'english', 'french', 'classic', 'fiction', 'crime', 'magical', 'love', 'mystery', 'history'];
  tagSelected = ''
  filteredTags: PostInterface[] = this.posts

  @ViewChild("singlePost") singlePost!: SinglePostComponent

  constructor(private postSrv: PostService) {
    this.post = this.topPost
    this.related = this.getRandomPosts(4)

  }
  get topPost(): PostInterface {
    return this.posts.sort((a, b) => b.reactions - a.reactions)[0];
  }
  getRandomPosts(num: number): PostInterface[] {
    const randomPosts: PostInterface[] = [];
    const numHistory: number[] = [];
    for (let i = 0; i < num; i++) {
      const random = Math.floor(Math.random() * this.posts.length);
      if (numHistory.includes(random)) continue;
      numHistory.push(random);
      randomPosts.push(this.posts[random]);
    }
    return randomPosts;
  }
  editPost() {
    alert("Edit successful!")
  }

  colore=false

  filtraTag(selezione: any) {
    this.tagSelected = selezione;
    console.log(this.tagSelected);
    let array = this.posts.filter(element => element.tags.includes(this.tagSelected));
    this.filteredTags = array;
    console.log(this.filteredTags);
    this.colore=!this.colore
  }

}
