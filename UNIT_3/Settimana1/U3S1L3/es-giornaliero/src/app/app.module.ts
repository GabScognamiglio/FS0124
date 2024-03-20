import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { InactivePostsComponent } from './components/inactive-posts/inactive-posts.component';
import { HomeComponent } from './components/home/home.component';
import { PostDetailsComponent } from './components/post-details/post-details.component';
import { EvidenzaComponent } from './components/evidenza/evidenza.component';
import { CorrelatoComponent } from './components/correlato/correlato.component';
import { LateraleComponent } from './components/laterale/laterale.component';
import { LateraleCardComponent } from './components/laterale-card/laterale-card.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ActivePostsComponent,
    InactivePostsComponent,
    HomeComponent,
    PostDetailsComponent,
    EvidenzaComponent,
    CorrelatoComponent,
    LateraleComponent,
    LateraleCardComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
