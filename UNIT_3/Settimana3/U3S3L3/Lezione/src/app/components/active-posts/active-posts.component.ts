import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';

@Component({
    selector: 'app-active-posts',
    templateUrl: './active-posts.component.html',
    styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent implements OnInit {
    posts!: Post[];

    constructor(private postSrv: PostService) {
    }

    async ngOnInit(){
        console.log('ngOnInit attivato');
        await this.postSrv.getPosts().subscribe((data)=>{
             this.posts = data
        });
       ;
    }

    disablePost(id: number, index: number) {
        this.postSrv.updatePost(id, {completed: false}).subscribe();
        this.posts.splice(index, 1);
    }

}
