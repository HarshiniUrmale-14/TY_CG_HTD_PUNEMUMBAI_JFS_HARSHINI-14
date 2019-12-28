import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-userbookinghistory',
  templateUrl: './userbookinghistory.component.html',
  styleUrls: ['./userbookinghistory.component.css']
})
export class UserbookinghistoryComponent implements OnInit {
  roomArray: [];
  constructor(private hotelService: HotelService) {
    this.getUserHistory();
  }

  getUserHistory() {
    this.hotelService.getBookingHistory().subscribe((data) => {
      console.log(data.bookingList);
      this.roomArray = data.bookingList;
    });
  }

  ngOnInit() {
  }

}
