import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addemployee',
  templateUrl: './addemployee.component.html',
  styleUrls: ['./addemployee.component.css']
})
export class AddemployeeComponent implements OnInit {
  notValid: any;
  valid: any;
  constructor(private hotelService: HotelService) { }

  submit(addForm: NgForm, passsword) {
    console.log(addForm.value);
    console.log(passsword);
    this.notValid = null;
    this.hotelService.postEmployee(addForm.value).subscribe(response => {
      if (response.statusCode === 222) {
        this.valid = response.description;
        addForm.reset();
      } else {
        this.notValid = response.description;
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
