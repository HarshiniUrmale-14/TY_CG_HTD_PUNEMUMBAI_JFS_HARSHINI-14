import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { Book } from '../book';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-userbooking',
  templateUrl: './userbooking.component.html',
  styleUrls: ['./userbooking.component.css']
})
export class UserbookingComponent implements OnInit {
  notValid: any;
 roomId:number;
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();

  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;

  constructor(public hotelService: HotelService, private router: Router) {
    console.log(this.todaysDate);
  }

  submitForm(addForm: NgForm) {
    console.log(addForm.value);
    this.hotelService.postBook(addForm.value).subscribe(response => {
      this.notValid = response;
      console.log('post method');
      console.log(response);
      console.log(addForm.value);
      console.log('post method');
      addForm.reset();
      this.router.navigateByUrl('/payment');
    },
      err => {
        console.log(err);
      }

    );
  }
 


  ngOnInit() {
  }

}
