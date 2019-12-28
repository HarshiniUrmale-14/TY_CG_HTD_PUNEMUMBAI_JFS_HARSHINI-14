import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ServiceComponent } from './service/service.component';
import { HotellistComponent } from './hotellist/hotellist.component';
import { RoomlistComponent } from './roomlist/roomlist.component';
import { GuestlistComponent } from './guestlist/guestlist.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { AddroomComponent } from './addroom/addroom.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { AddadminComponent } from './addadmin/addadmin.component';
import { ViewbillComponent } from './viewbill/viewbill.component';
import { BookhotelComponent } from './bookhotel/bookhotel.component';
import { BookuserComponent } from './bookuser/bookuser.component';
import { BookroomComponent } from './bookroom/bookroom.component';
import { AddemployeeComponent } from './addemployee/addemployee.component';
import { UpdateuserComponent } from './updateuser/updateuser.component';
import { PaymentComponent } from './payment/payment.component';
import { EmployeeroomComponent } from './employeeroom/employeeroom.component';
import { UserbookingComponent } from './userbooking/userbooking.component';
import { EmployeebookingComponent } from './employeebooking/employeebooking.component';
import { SearchByLocationPipe } from './search-by-location.pipe';
import { UserbookinghistoryComponent } from './userbookinghistory/userbookinghistory.component';
import { VisitorroomComponent } from './visitorroom/visitorroom.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AboutusComponent,
    LoginadminComponent,
    PagenotfoundComponent,
    ServiceComponent,
    HotellistComponent,
    RoomlistComponent,
    GuestlistComponent,
    RegisterComponent,
    AddroomComponent,
    UserdetailsComponent,
    AddadminComponent,
    ViewbillComponent,
    BookhotelComponent,
    BookuserComponent,
    BookroomComponent,
    AddemployeeComponent,
    UpdateuserComponent,
    PaymentComponent,
    EmployeeroomComponent,
    UserbookingComponent,
    EmployeebookingComponent,
    SearchByLocationPipe,
    UserbookinghistoryComponent,
    VisitorroomComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
