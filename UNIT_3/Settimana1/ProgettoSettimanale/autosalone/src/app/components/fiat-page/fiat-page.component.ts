import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-fiat-page',
  templateUrl: './fiat-page.component.html',
  styleUrls: ['./fiat-page.component.scss']
})
export class FiatPageComponent {
  cars: Car[] = [];
  fiatCars:Car[]=[];
  
  constructor(){
    this.getCars().then(cars=>{
      console.log(cars);
      this.cars=cars;
      this.fiatCars=this.cars.filter(element=> element.brand==="Fiat")
      console.log(this.fiatCars)
    })
  }

  async getCars() {
    const response = await fetch ('../../../assets/db.json');
    const data = await response.json();
    return data;
  }
}
