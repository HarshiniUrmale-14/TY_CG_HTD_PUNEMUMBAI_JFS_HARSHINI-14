import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

userArray: [];
  constructor(private hotelService: HotelService) {
    this.getUserList();
  }

  getUserList() {
    this.hotelService.getUserList().subscribe((data) => {
      console.log(data.userList);
      this.userArray = data.userList;
    });
  }

  ngOnInit() {
  }

}
