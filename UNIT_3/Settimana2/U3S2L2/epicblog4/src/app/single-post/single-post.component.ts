import { Component, Input } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';

@Component({
  selector: 'app-single-post',
  templateUrl: './single-post.component.html',
  styleUrls: ['./single-post.component.scss']
})
export class SinglePostComponent {
  @Input() post!: PostInterface
  edit: Boolean = false
  toggleEdit() {
    this.edit = !this.edit
  }
}
