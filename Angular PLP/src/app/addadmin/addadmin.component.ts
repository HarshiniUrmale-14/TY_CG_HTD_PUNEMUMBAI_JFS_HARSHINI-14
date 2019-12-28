import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HotelService } from '../hotel.service';

@Component({
  selector: 'app-addadmin',
  templateUrl: './addadmin.component.html',
  styleUrls: ['./addadmin.component.css']
})
export class AddadminComponent implements OnInit {
  valid: any;
  inValid: any;
  constructor(private hotelService: HotelService) { }

  submit(addForm: NgForm,password) {
    console.log(addForm.value);
    console.log(password);
    this.hotelService.postAdmin(addForm.value).subscribe(response => {
      console.log(response);
      addForm.reset();
      if (response.statusCode === 222) {
        this.valid = response.description;
      } else {
        this.inValid = response.description;
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
