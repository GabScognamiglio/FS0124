import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.interface';
import { UserService } from 'src/app/service/user.service';

@Component({
    selector: 'app-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.scss'],
})
export class UsersComponent implements OnInit {
    users: User[] = [];

    constructor(private userSrv: UserService) {}

    async ngOnInit() {
        await this.userSrv.getUsers().subscribe((data)=>{
            this.users = data;
       });
    }
}
