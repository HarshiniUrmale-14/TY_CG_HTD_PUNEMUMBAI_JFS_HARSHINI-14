import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  valid: any;
  invalid: any;

  constructor(private auth: AuthService, private router: Router) { }

  register(registerForm: NgForm, passsword) {
    console.log(registerForm.value);
    this.auth.register(registerForm.value).subscribe(response => {
      console.log(response);
      console.log(passsword);
      if (response.statusCode === 222) {
        this.valid = response.description;
        registerForm.reset();
      } else {
        this.invalid = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
