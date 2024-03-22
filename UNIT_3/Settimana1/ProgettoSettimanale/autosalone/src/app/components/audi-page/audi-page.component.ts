import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-audi-page',
  templateUrl: './audi-page.component.html',
  styleUrls: ['./audi-page.component.scss']
})
export class AudiPageComponent {
  cars: Car[] = [];
  audiCars:Car[]=[];
  
  constructor(){
    this.getCars().then(cars=>{
      console.log(cars);
      this.cars=cars;
      this.audiCars=this.cars.filter(element=> element.brand==="Audi")
      console.log(this.audiCars)
    })
  }

  async getCars() {
    const response = await fetch ('../../../assets/db.json');
    const data = await response.json();
    return data;
  }


}
