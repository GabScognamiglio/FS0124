import { Injectable } from '@angular/core';
import { Product } from 'src/app/models/product.interface';
import { HttpClient } from '@angular/common/http';
import { Subject, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  productURL = 'https://dummyjson.com/products';
  cartSub = new Subject<Product[]>();
  cartArray: Product[] = [];
  favSub =  new Subject<Product[]>();
  favArray: Product[] = [];


  constructor(private http: HttpClient) { }

  getProducts() {
    return this.http.get<{ products: Product[] }>(this.productURL)
      .pipe(
        catchError((err) => {
          return throwError(this.getErrorMessage(err.status));
        })
      )
      .pipe(map((products) => products.products));

  }

  addCart(product: any) {
    this.cartArray.push(product)
    this.cartSub.next(this.cartArray);
  }

  addFav(product:any) {
    if (!this.favArray.includes(product)){
    this.favArray.push(product);}
    this.favSub.next(this.favArray);
  }


  getErrorMessage(status: number) {
    let message = '';
    switch (status) {
      case 404:
        message = 'Elementi non trovati';
        break;

      default:
        message = 'Qualcosa non ha funzionato nella chiamata';
        break;
    }
    return message;
  }
}
