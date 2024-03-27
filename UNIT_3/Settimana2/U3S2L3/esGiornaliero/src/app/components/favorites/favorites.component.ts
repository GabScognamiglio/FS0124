import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/product.interface';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.scss']
})
export class FavoritesComponent implements OnInit{
  sub!: Subscription;
  favArray:Product[]=this.productSrv.favArray
  constructor(private productSrv: ProductsService) { }

  ngOnInit(): void { console.log(this.favArray) }


  remove(i:number){
    this.productSrv.favArray.splice(i,1)
    console.log(this.productSrv.favArray)
  }
}

