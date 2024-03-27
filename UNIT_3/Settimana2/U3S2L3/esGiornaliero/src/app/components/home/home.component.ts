import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { Product } from 'src/app/models/product.interface';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  sub!: Subscription;
  products: Product[] = []
  favorites: Product[] = []


  constructor(private productSrv: ProductsService) { }

  ngOnInit(): void {
    this.retrieveProducts()

  }

  retrieveProducts() {
    this.sub = this.productSrv.getProducts().subscribe((res) => {
      this.products = res
      console.log(this.products)
    })
  }

  addToCart(id: number) {
    let prod = this.products.find((element) => element.id === id)
    this.productSrv.addCart(prod);
  }

  toggleFav = false

  addToFavs(id: number) {
    let prod = this.products.find((element) => element.id === id)
    this.productSrv.addFav(prod);
    console.log(this.productSrv.favArray)
    this.toggleFav = true
  }
}
