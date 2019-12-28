import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-bookuser',
  templateUrl: './bookuser.component.html',
  styleUrls: ['./bookuser.component.css']
})
export class BookuserComponent implements OnInit {


  hotelArray: [];
  hotelId: any;
  roomArray: [];
  constructor(public hotelService: HotelService, private router: Router) {
    this.hotelService.getHotel();
    


  }



  ngOnInit() {
  }

}
