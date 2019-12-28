import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-visitorroom',
  templateUrl: './visitorroom.component.html',
  styleUrls: ['./visitorroom.component.css']
})
export class VisitorroomComponent implements OnInit {

  constructor(public hotelService: HotelService, private router: Router) {
  }

  ngOnInit() {
  }

  selectRoom(room) {
    this.hotelService.selectedRoom = room;
    this.router.navigateByUrl('/login');
  }


}
