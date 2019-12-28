import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Book } from '../book';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-employeeroom',
  templateUrl: './employeeroom.component.html',
  styleUrls: ['./employeeroom.component.css']
})
export class EmployeeroomComponent implements OnInit {
  details: any;
  rooms: [];
  notValid: any;
  selectedHotel: Book = {
    hotelId: null,
    hotelName: null,
    roomId: null,
    userId: null,
    bookingId: null,
    userName: null,
    checkinDate: null,
    checkoutDate: null,
    amount: null,
    modeOfPayment: null,
    paymentStatus: null,
    days: null
  };
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelService.getRoomListOfEmployee().subscribe((data) => {
      console.log(data.roomList);
      this.rooms = data.roomList;
    });
  }
  selectHotel(bookingList: Book) {
    this.selectedHotel = bookingList;
  }

  updateForm(addForm: NgForm) {
    console.log(addForm.value);
    this.hotelService.postBookingEmployee(addForm.value).subscribe(response => {
      this.notValid = response;
      console.log('post method');
      console.log(response);
      console.log('post method');
      addForm.reset();
    },
      err => {
        console.log(err);
      }

    );
  }

  selectRoom(room) {
    this.hotelService.selectedRoom = room;
    this.router.navigateByUrl('/employeebooking');
  }


  ngOnInit() {
  }

}
