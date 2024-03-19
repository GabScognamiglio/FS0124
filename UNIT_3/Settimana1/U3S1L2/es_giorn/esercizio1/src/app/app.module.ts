import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { Parte1Component } from './components/parte1/parte1.component';
import { Parte2Component } from './components/parte2/parte2.component';
import { Parte3Component } from './components/parte3/parte3.component';

@NgModule({
  declarations: [
    AppComponent,
    Parte1Component,
    Parte2Component,
    Parte3Component
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
