import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/interfaces/user.interface';
import { UtentiService } from 'src/app/service/utenti.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  users!: User[]
  constructor(private userSrv: UtentiService) { }

  async ngOnInit(): Promise<void> {
    await this.userSrv.getUsers().subscribe((data) => {
      this.users = data;
    })
  }

}
