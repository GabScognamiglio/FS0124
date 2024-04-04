import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Register } from 'src/app/models/register.interface';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  userReg!: Register

  constructor(private authSrv: AuthService, private router:Router) { }

  onSubmit(form: NgForm) {
    console.log(form.value);
    try {
      this.authSrv.signup(form.value).subscribe();
    } catch (error) {
      console.error(error);
    }
    this.router.navigate(['/login'])
  }
}
