import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  cars: Car[] = [];
  car!: Car;
  included: number[] = [];
  featuredCars:Car[]=[];

  constructor(){
    this.getCars().then(cars=>{
      console.log(cars);
      this.cars=cars;
      this.buildIndex()
      this.advisePosts()
    })
  }

  async getCars() {
    const response = await fetch ('../../../assets/db.json');
    const data = await response.json();
    return data;
  }

  buildIndex() {
    for (let i = 0; i < 2; i++) {
        let index = Math.floor(Math.random() * this.cars.length);
        if (this.included.includes(index)) {
            index = Math.floor(Math.random() * this.cars.length);
        }
        this.included.push(index);
    }
  
}

advisePosts() {
  for (let i = 0; i < this.included.length; i++) {
      let carIndex = this.included[i];
      this.featuredCars.push(this.cars[carIndex]);
  }
  console.log(this.featuredCars)
}

}
