import { Component, OnInit } from '@angular/core';
import { AuthdData } from 'src/app/models/authd-data.interface';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user!: AuthdData | null;

  constructor(private authSrv: AuthService) { }

  ngOnInit(): void {
    this.authSrv.user$.subscribe((user) =>
      this.user = user)
  }

  logout(){
    this.authSrv.logout();
  }
}
