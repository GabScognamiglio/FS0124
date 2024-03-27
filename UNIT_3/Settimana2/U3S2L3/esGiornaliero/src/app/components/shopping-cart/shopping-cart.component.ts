import { Component, OnInit } from '@angular/core';
import { Subscription, count } from 'rxjs';
import { Product } from 'src/app/models/product.interface';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {
  cartArray=this.productSrv.cartArray;
  totale=0

  constructor(private productSrv: ProductsService) { }

  ngOnInit(): void {
    this.productSrv.cartSub.subscribe((count) => {
      this.cartArray = count;
      console.log(this.cartArray);
  });
  }

  remove(i:number){
    this.productSrv.cartArray.splice(i,1)
    console.log(this.cartArray)
    
  }
}
