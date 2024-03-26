import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ActivePostsComponent } from './active-posts/active-posts.component';
import { InactivePostsComponent } from './inactive-posts/inactive-posts.component';
import { Route, RouterModule } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { SinglePostComponent } from './single-post/single-post.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ActivePostsComponent,
    InactivePostsComponent,
    HomepageComponent,
    PostDetailComponent,
    SinglePostComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
