import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Signup } from 'src/app/interfaces/signup.interface';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  userReg!: Signup

  constructor(private authSrv: AuthService, private router: Router) { }

  onSubmit(form: NgForm) {
    console.log(form.value);
    try {
      this.authSrv.signup(form.value).subscribe();
      this.router.navigate(['/login'])
    } catch (error) {
      console.error(error);
    }
  }
}
