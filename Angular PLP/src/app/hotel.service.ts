import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelList } from './hotelList';
import { Router } from '@angular/router';
import { RoomList } from './room';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  hotels: HotelList[] = [];

  hotelRoomDetails: RoomList[] = [];

  api = 'http://localhost:8080/';

  selectedRoom;
  selectHotel;

  constructor(private http: HttpClient, private router: Router) { }

  postHotel(data) {
    return this.http.post<any>(`${this.api}addHotelDetails`, data);

  }
  postRoom(data) {
    return this.http.post<any>(`${this.api}addRoomDetails`, data);

  }
  putHotel(data) {
    return this.http.put<any>(`${this.api}updateHotelDetails`, data);

  }

  getHotel() {
    return this.http.get<any>(`${this.api}getHotelDetails`).subscribe(data => {
      console.log(data.hotelList);

      this.hotels = data.hotelList;

    });

  }
  getRoom() {
    return this.http.get<any>(`${this.api}getRoomDetails`);
  }
  getBillDetails() {
    return this.http.get<any>(`${this.api}getBill`);
  }

  deleteHotel(data) {
    return this.http.delete(`${this.api}deleteHotelDetails/${data.hotelId}`);
  }

  deleteRoom(data) {
    return this.http.delete(`${this.api}deleteRoomDetails/${data.roomId}`);
  }
  putRoom(data) {
    return this.http.put<any>(`${this.api}updateRoomDetails`, data);

  }
  putUpdateBooking(data) {
    return this.http.put<any>(`${this.api}updateBookingStatus`, data);

  }

  postAdmin(data) {
    return this.http.post<any>(`${this.api}addAdmin`, data);

  }
  getUserProfile() {
    return this.http.get<any>(`${this.api}getUserProfile`);
  }

  postEmployee(data) {
    return this.http.post<any>(`${this.api}addEmployee`, data);

  }

  putUpdate(data) {
    return this.http.put<any>(`${this.api}updateProfile`, data);

  }
  getUserList() {
    return this.http.get<any>(`${this.api}getCustomerDetails`);
  }
  getRoomListOfHotel(data) {
    return this.http.get<any>(`${this.api}getRoomDetails/${data.hotelId}`).subscribe(data => {
      console.log(data);
      this.hotelRoomDetails = data.roomList;

    });
  }
  getRoomListOfEmployee() {
    return this.http.get<any>(`${this.api}getRoomDetailsForEmployee`);

  }
  postBook(data) {
    return this.http.post<any>(`${this.api}booking`, data);

  }
  getBookingDetails() {
    return this.http.get<any>(`${this.api}getBillDetails`);
  }
  getBookingHistory() {
    return this.http.get<any>(`${this.api}getUserBookingList`);
  }
  postBookingEmployee(data) {
    return this.http.post<any>(`${this.api}bookingByEmployee`, data);

  }

}
