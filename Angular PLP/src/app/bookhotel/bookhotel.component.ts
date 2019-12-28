import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-bookhotel',
  templateUrl: './bookhotel.component.html',
  styleUrls: ['./bookhotel.component.css']
})
export class BookhotelComponent implements OnInit {

  hotelArray: [];
  constructor(public hotelService: HotelService, public auth: AuthService) {
    this.hotelService.getHotel();
    }
  // getHotelList() {
  //   this.hotelService.getHotel().subscribe((data) => {
  //     console.log(data.hotelList);
  //     this.hotelArray = data.hotelList;
  //   });
  // }


  ngOnInit() {
  }

}
