import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  totalBill: number;
  notValid: any;
  roomDetails: number;
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();

  todaysDate = `${this.year}-${this.month + 1}-${this.date + 1}`;

  constructor(public hotelService: HotelService) {
    this.getBill();
    this.roomDetails = this.hotelService.selectHotel;
  }
  getBill() {
    this.hotelService.getBillDetails().subscribe(response => {
      this.totalBill = response;
      console.log(response);
    });
  }
  payment(paymentForm: NgForm) {
    console.log(paymentForm.value);
    this.hotelService.putUpdateBooking(paymentForm.value).subscribe(response => {
      console.log(response);
      paymentForm.reset();
      if (response === 222) {
        this.notValid = response;
      } else {
        this.notValid = response;
      }
    },
      err => {
        console.log(err);
      }

    );
  }

  ngOnInit() {
  }

}
