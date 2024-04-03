import { Component, Input } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
    selector: 'app-post-card',
    templateUrl: './post-card.component.html',
    styleUrls: ['./post-card.component.scss'],
})
export class PostCardComponent {
    @Input('post') post!: Post; // Il componente, figlio sia di active post che di inactive post, aspetta di ricevere in input dai padri un elemento di tipo Post
}
