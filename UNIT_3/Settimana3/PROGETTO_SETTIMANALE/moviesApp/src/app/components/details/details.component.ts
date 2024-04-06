import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/user.interface';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit{
  user!:User

  ngOnInit(): void {
    this.getUser()
  }

  getUser(){
    const activeUser: any = localStorage.getItem('user')
    this.user = JSON.parse(activeUser).user;
    console.log(this.user)
  }
}
