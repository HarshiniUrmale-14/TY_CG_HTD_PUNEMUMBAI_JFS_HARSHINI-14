import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';
import { User } from '../user';

@Component({
  selector: 'app-updateuser',
  templateUrl: './updateuser.component.html',
  styleUrls: ['./updateuser.component.css']
})
export class UpdateuserComponent implements OnInit {
  user: User;
  isUpdate: any;

  constructor(private hotelService: HotelService) {
    this.getUserList();
  }

  getUserList() {
    this.hotelService.getUserProfile().subscribe((data) => {
      console.log(data.userBean);
      this.user = data.userBean;
    });
  }

  updateProfile(updateForm: NgForm) {
    this.hotelService.putUpdate(updateForm.value).subscribe(response => {
      console.log(response);
      updateForm.reset();
      this.getUserList();
      this.isUpdate = response;

    }, err => {
      console.log(err);
    });

  }

  ngOnInit() {
  }

}
