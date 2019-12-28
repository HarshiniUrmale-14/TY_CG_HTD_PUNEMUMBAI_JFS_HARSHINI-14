import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { ServiceComponent } from './service/service.component';
import { HotellistComponent } from './hotellist/hotellist.component';
import { RoomlistComponent } from './roomlist/roomlist.component';
import { GuestlistComponent } from './guestlist/guestlist.component';
import { AuthGuard } from './auth.guard';
import { RegisterComponent } from './register/register.component';

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
import { UserbookinghistoryComponent } from './userbookinghistory/userbookinghistory.component';
import { VisitorroomComponent } from './visitorroom/visitorroom.component';


const routes: Routes = [
  { path: '', component: HomeComponent, },
  { path: 'aboutus', component: AboutusComponent },
  { path: 'login', component: LoginadminComponent },
  { path: 'service', component: ServiceComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'bookhotel', component: BookhotelComponent },
  { path: 'bookroom', component: BookroomComponent },
  { path: 'visitorroom', component: VisitorroomComponent },
  {
    path: 'hotellist', component: HotellistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }

  },
  {
    path: 'updateuser', component: UpdateuserComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }

  },
  {
    path: 'payment', component:PaymentComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }

  },
  {
    path: 'userbooking', component:UserbookingComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }

  },
  {
    path: 'userbookinghistory', component:UserbookinghistoryComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }

  },
  {
    path: 'employeebooking', component:EmployeebookingComponent, data: {
      canActivate: [AuthGuard],
      role: ['employee']
    }

  },
  {
    path: 'employeeroom', component: EmployeeroomComponent, data: {
      canActivate: [AuthGuard],
      role: ['employee']
    }

  },

  {
    path: 'addemployee', component: AddemployeeComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'userdetails', component: UserdetailsComponent, data: {
      canActivate: [AuthGuard],
      role: ['management']
    }
  },
  {
    path: 'addadmin', component: AddadminComponent, data: {
      canActivate: [AuthGuard],
      role: ['management']
    }
  },
  {
    path: 'viewbill', component: ViewbillComponent, data: {
      canActivate: [AuthGuard],
      role: ['management']
    }
  },
  {
    path: 'addroom', component: AddroomComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'roomlist', component: RoomlistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'guestlist', component: GuestlistComponent, data: {
      canActivate: [AuthGuard],
      role: ['admin']
    }
  },
  {
    path: 'bookuser', component: BookuserComponent, data: {
      canActivate: [AuthGuard],
      role: ['user']
    }

  },


  { path: '**', component: PagenotfoundComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
