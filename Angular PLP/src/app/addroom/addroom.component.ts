import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-addroom',
  templateUrl: './addroom.component.html',
  styleUrls: ['./addroom.component.css']
})
export class AddroomComponent implements OnInit {


  invalid: any;
  valid: any;

  constructor(public hotelService: HotelService) { }

  submit(addForm: NgForm) {
    console.log(addForm.value);
    this.hotelService.postRoom(addForm.value).subscribe(response => {
      this.invalid = null;
      this.valid = null;
      if (response.statusCode === 222) {
        this.valid = response.description;
        addForm.reset();
      } else {
        this.invalid = response.description;
      }
      console.log(response);
    },
      err => {
        console.log(err);
      }

    );
  }

  ngOnInit() {
  }

}
