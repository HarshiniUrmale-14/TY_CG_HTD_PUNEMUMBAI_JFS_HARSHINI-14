import { Component, OnInit } from '@angular/core';
import { HotelService } from '../hotel.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Book } from '../book';

@Component({
  selector: 'app-employeebooking',
  templateUrl: './employeebooking.component.html',
  styleUrls: ['./employeebooking.component.css']
})
export class EmployeebookingComponent implements OnInit {
  notValid: any;
  fullDate = new Date();
  year = this.fullDate.getFullYear();
  month = this.fullDate.getMonth();
  date = this.fullDate.getDate();


  todaysDate = `${this.year}-${this.month + 1}-${this.date}`;
  constructor(public hotelService: HotelService, private router: Router) {
    console.log(this.todaysDate);
  }

  updateForm(addForm: NgForm) {
    console.log(addForm.value);
    this.hotelService.postBookingEmployee(addForm.value).subscribe(response => {
      // this.notValid = response;
      console.log('post method');
      console.log(response);
      console.log('post method');
      // addForm.reset();
      if (response.statusCode === 222) {
        this.router.navigateByUrl('/payment');
      } else {
        this.notValid = response;
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
