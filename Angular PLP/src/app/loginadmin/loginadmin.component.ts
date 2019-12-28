import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-loginadmin',
  templateUrl: './loginadmin.component.html',
  styleUrls: ['./loginadmin.component.css']
})
export class LoginadminComponent implements OnInit {

  error: string = null;
  inValid: any;
  constructor(private auth: AuthService, private router: Router) {
  }

  login(loginForm: NgForm) {
    this.error = null;
    console.log(loginForm.value);
    this.auth.login(loginForm.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 222) {
        const user = JSON.stringify(response);
        localStorage.setItem('value', user);
        if (response.userType === 'user') {
          this.router.navigateByUrl('/');
        } else {
          this.router.navigateByUrl('/');
        }
      } else {
        this.inValid = response.description;
      }
    }, err => {
      console.log(err);
    });
  }

  ngOnInit() {
  }

}
