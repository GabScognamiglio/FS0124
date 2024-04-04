import { Injectable } from '@angular/core';
import { Post } from '../models/post.interface';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  apiURL = environment.apiURL;

  constructor(private http: HttpClient) { }

  getPosts() {
    return this.http.get<Post[]>(`${this.apiURL}posts`);
  }

  getPost(id: number) {
    return this.http.get<Post>(`${this.apiURL}posts/${id}`);
  }

  updatePost(id: number, data: Partial<Post>) {
    return this.http.patch<Post>(`${this.apiURL}posts/${id}`, data);
  }
}
