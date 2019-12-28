import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-guestlist',
  templateUrl: './guestlist.component.html',
  styleUrls: ['./guestlist.component.css']
})
export class GuestlistComponent implements OnInit {


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
