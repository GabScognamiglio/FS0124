import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.interface';
import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-user-details',
    templateUrl: './user-details.component.html',
    styleUrls: ['./user-details.component.scss'],
})
export class UserDetailsComponent implements OnInit {
    user: User | undefined;

    constructor(private userSrv: UserService, private router: ActivatedRoute) {}

    ngOnInit(): void {
        this.router.params.subscribe((params) => {
            const id = +params['id'];
            this.user = this.userSrv.getUser(id);
        });
    }
}
