import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';
import { HotelList } from '../hotelList';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hotellist',
  templateUrl: './hotellist.component.html',
  styleUrls: ['./hotellist.component.css']
})
export class HotellistComponent implements OnInit {

  delete: any;
  update: any;
  add: any;
  inValid: any;
  hotelArray: [];

  selectedHotel: HotelList = {
    hotelId: null,
    hotelName: null,
    location: null,
    imageUrl: null,
    phoneNo: null
  };

  constructor(private hotelService: HotelService, private router: Router) {
    this.hotelService.getHotel();
  }

  selectHotel(hotelList: HotelList) {
    this.selectedHotel = hotelList;
    this.update = null;
  }

  deleteHotel(hotelList: HotelList) {
    this.hotelService.deleteHotel(hotelList).subscribe(response => {
      console.log(response);
      this.hotelService.getHotel();
      this.delete = response;
      console.log('delete hotel name');

    },
      err => {
        console.log(err);
      });
  }

  submitForm(addHotel: NgForm) {
    console.log(addHotel.value);
    this.hotelService.postHotel(addHotel.value).subscribe(response => {
      this.inValid = null;
      this.hotelService.getHotel();
      console.log(response);
      if (response.statusCode === 222) {
        this.add = response.description;
        addHotel.reset();
      } else {
        this.inValid = response.description;
      }
    },
      err => {
        console.log(err);
      }

    );
  }


  updateForm(form: NgForm) {
    this.hotelService.putHotel(form.value).subscribe(response => {
      console.log(response);
      this.update = response.description;
      form.reset();
    }, err => {
      console.log(err);
    });

  }
  selectRoom(hotel) {
    this.hotelService.selectHotel = hotel;
    this.router.navigateByUrl('/addroom');
  }

  ngOnInit() {
  }

}
