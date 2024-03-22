import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { AudiPageComponent } from './components/audi-page/audi-page.component';
import { FordPageComponent } from './components/ford-page/ford-page.component';
import { FiatPageComponent } from './components/fiat-page/fiat-page.component';
import { CarDetailsComponent } from './components/car-details/car-details.component';


const routes = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'audi',
    component:AudiPageComponent
  },
  {
    path:'ford',
    component:FordPageComponent
  },
  {
    path:'fiat',
    component:FiatPageComponent
  },
  {
    path:'dettaglio/:id',
    component:CarDetailsComponent
  },
  {
    path:'**',
    component:HomeComponent
  }


]
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    AudiPageComponent,
    FordPageComponent,
    FiatPageComponent,
    CarDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }