import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AllMoviesComponent } from './components/all-movies/all-movies.component';
import { DetailsComponent } from './components/details/details.component';
import { FavouritesComponent } from './components/favourites/favourites.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { TokenInterceptor } from './auth/token.interceptor';
import { AuthGuard } from './auth/auth.guard';
import { MovieDetailsComponent } from './components/movie-details/movie-details.component';


const routes: Route[] = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'movies',
    component: AllMoviesComponent,
    canActivate:[AuthGuard]
  },
  {
    path: 'profile',
    component: ProfileComponent,
    children: [
      {
        path: 'details',
        component: DetailsComponent
      },
      {
        path: 'favourites',
        component: FavouritesComponent
      }
    ],
    canActivate:[AuthGuard]
  },
  {
    path: 'users',
    component: UsersListComponent,
    canActivate:[AuthGuard]
  },
  {
    path: 'movies/:id',
    component: MovieDetailsComponent,
    canActivate:[AuthGuard]
  },

]

@NgModule({
  declarations: [
    AppComponent,
    AllMoviesComponent,
    DetailsComponent,
    FavouritesComponent,
    HomeComponent,
    NavbarComponent,
    ProfileComponent,
    UsersListComponent,
    LoginComponent,
    SignupComponent,
    MovieDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule {}
