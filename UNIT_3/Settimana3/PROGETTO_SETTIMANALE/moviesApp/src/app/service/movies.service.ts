import { Injectable } from '@angular/core';
import { Movie } from '../interfaces/movie.interface';
import { HttpClient } from '@angular/common/http';
import { Fav } from '../interfaces/fav.interface';
import { filter, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  apiURL = 'http://localhost:4201/movies-popular'

  favUrl = 'http://localhost:4201/favorites'

  constructor(private http: HttpClient) { }

  getMovies(){
    return this.http.get<Movie[]>(this.apiURL)
  }

  getMovie(id:number){
    return this.http.get<Movie>(`${this.apiURL}/${id}`)
  }

  addFavourite(movieID:number, userID:number){
    const data ={
      userId:userID,
      movieId:movieID
    }
    return this.http.post<Fav>(this.favUrl, data)
  }

  removeFav(id:number){
    return this.http.delete(`http://localhost:4201/favorites/${id}`)
  }

  getFavs(){
    return this.http.get<Fav[]>(this.favUrl);
  }
}
