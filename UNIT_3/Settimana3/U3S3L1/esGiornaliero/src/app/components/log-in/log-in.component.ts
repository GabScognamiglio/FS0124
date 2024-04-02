import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.scss']
})
export class LogInComponent implements OnInit {
  username: string = '';
  password: string = '';
  @ViewChild('form', {static: true}) form!: NgForm;

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.form.value)
  }
}
