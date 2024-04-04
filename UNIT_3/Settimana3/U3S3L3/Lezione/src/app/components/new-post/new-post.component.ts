import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';
import { PostService } from 'src/app/service/post.service';
import { NgForm } from '@angular/forms';
import { UserService } from 'src/app/service/user.service';


@Component({
  selector: 'app-new-post',
  templateUrl: './new-post.component.html',
  styleUrls: ['./new-post.component.scss']
})
export class NewPostComponent implements OnInit{
  arrayUser:any[]=[]

 constructor(private postSrv:PostService, private userSrv:UserService){}

 ngOnInit(): void {
   this.userSrv.getUsers().subscribe(data=>
    this.arrayUser=data)
 }

 nuovoPost(form:NgForm){
  console.log(form.value)
  form.value.userId=Number(form.value.userId)
  if(form.value.completed == 'true'){
    form.value.completed = true
  }
  else if (form.value.completed == 'false'){
    form.value.completed = false
  }
  this.postSrv.newPost(form.value).subscribe()
 }
}
