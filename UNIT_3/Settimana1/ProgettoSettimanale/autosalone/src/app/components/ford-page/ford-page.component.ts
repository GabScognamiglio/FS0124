import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-ford-page',
  templateUrl: './ford-page.component.html',
  styleUrls: ['./ford-page.component.scss']
})
export class FordPageComponent {
  cars: Car[] = [];
  fordCars:Car[]=[];
  
  constructor(){
    this.getCars().then(cars=>{
      console.log(cars);
      this.cars=cars;
      this.fordCars=this.cars.filter(element=> element.brand==="Ford")
      console.log(this.fordCars)
    })
  }

  async getCars() {
    const response = await fetch ('../../../assets/db.json');
    const data = await response.json();
    return data;
  }

}
