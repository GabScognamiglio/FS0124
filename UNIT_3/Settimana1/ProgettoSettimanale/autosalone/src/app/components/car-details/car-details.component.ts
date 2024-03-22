import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.scss']
})
export class CarDetailsComponent {
  idCercato!: string | any;
 numIdCercato!:number|any;
  car!: Car | any
  cars!: Car[]

  constructor(private route: ActivatedRoute) {
    this.idCercato = this.route.snapshot.paramMap.get('id');
    console.log(this.idCercato);
    this.getDetails().then((data) => {
      console.log(data);
      this.cars = data;
      this.numIdCercato = parseInt(this.idCercato)
      this.car = this.cars.find(oggetto => oggetto.id === this.numIdCercato)
      console.log(this.car)
    })
  }

  async getDetails() {
    const response = await fetch('../../assets/db.json/');
    const data = await response.json();
    return data;
  }

}
