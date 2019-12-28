import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-viewbill',
  templateUrl: './viewbill.component.html',
  styleUrls: ['./viewbill.component.css']
})
export class ViewbillComponent implements OnInit {


  billArray: [];
  constructor(private hotelService: HotelService) {
    this.getBillList();
  }

  getBillList() {
    this.hotelService.getBookingDetails().subscribe((data) => {
      console.log(data.bookingList);
      this.billArray = data.bookingList;
    });
  }

  ngOnInit() {
  }

}
