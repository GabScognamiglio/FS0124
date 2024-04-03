import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, AbstractControl } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent {
  signUpForm!: FormGroup;
  nuovoUtente!: any

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.signUpForm = this.fb.group({
      nome: this.fb.control('', [Validators.required]),
      cognome: this.fb.control('', [Validators.required]),
      password: this.fb.control('', [Validators.required, Validators.minLength(8), Validators.pattern(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*#?&^_-]).{8,}/)]),
      confermaPassword: ['', Validators.required],
      genere: 'M',
      immagineProfilo: [''],
      biografia: [''],
      username: this.fb.control('', [Validators.required, Validators.minLength(4)]),
    });
  }


  confermaPassword = (control: AbstractControl) => {
    const passwordControl = this.signUpForm.get('password')?.value;
    if (control.value !== passwordControl.value) {
      return {'passwordNonCorrispondente': true};
    }
    return null;  //dà errore perchè vuole validatore asincrono (?)
  }


  onSubmit(): void {
    this.nuovoUtente = this.signUpForm.value
    console.log(this.nuovoUtente)
    this.signUpForm.reset()
  }

}
