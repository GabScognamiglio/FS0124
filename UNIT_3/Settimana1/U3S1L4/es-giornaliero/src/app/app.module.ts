import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';

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

const routes:Route[] = [
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'activePosts',
    component:ActivePostsComponent
  },
  {
    path:'inactivePosts',
    component:InactivePostsComponent
  },
  {
    path:'post/:id',
    component:PostDetailsComponent
  }
]

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
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
