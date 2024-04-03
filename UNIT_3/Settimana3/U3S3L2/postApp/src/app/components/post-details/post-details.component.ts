import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-post-details',
    templateUrl: './post-details.component.html',
    styleUrls: ['./post-details.component.scss'],
})
export class PostDetailsComponent implements OnInit {
    post: Post | undefined;

    constructor(private postSrv: PostService, private router: ActivatedRoute) {}

    ngOnInit(): void {
        this.router.params.subscribe((params) => {
            const id = +params['id'];
            this.post = this.postSrv.getPost(id);
        });
    }
}
