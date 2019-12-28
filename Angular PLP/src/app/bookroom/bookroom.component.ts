import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-bookroom',
  templateUrl: './bookroom.component.html',
  styleUrls: ['./bookroom.component.css']
})
export class BookroomComponent implements OnInit {
  constructor(public hotelService: HotelService, private router: Router) {
  }

  selectRoom(room) {
    this.hotelService.selectedRoom = room;
    this.router.navigateByUrl('/userbooking');
  }
  ngOnInit() {
  }
}
