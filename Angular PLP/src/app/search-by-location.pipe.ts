import { Pipe, PipeTransform } from '@angular/core';
import { HotelList } from './hotelList';

@Pipe({
  name: 'searchByLocation'
})
export class SearchByLocationPipe implements PipeTransform {

  transform(hotels: HotelList[], search: string): HotelList[] {
    if (search === undefined) {
      return hotels;
    } else {
      return hotels.filter(hotel => {
        return hotel.location.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}
