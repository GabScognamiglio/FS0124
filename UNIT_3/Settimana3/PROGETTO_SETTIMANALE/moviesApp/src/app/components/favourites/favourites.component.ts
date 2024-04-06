import { Component, OnInit } from '@angular/core';
import { Fav } from 'src/app/interfaces/fav.interface';
import { Movie } from 'src/app/interfaces/movie.interface';
import { MoviesService } from 'src/app/service/movies.service';
@Component({
  selector: 'app-favourites',
  templateUrl: './favourites.component.html',
  styleUrls: ['./favourites.component.scss']
})
export class FavouritesComponent {
  movies: Movie[] =[];
  favMovies:Movie[] =[]
  allFavs!: Fav[];
  userFav: Fav[] = [];
  caricamento = true;

  constructor(private moviesSrv: MoviesService) { }

  async ngOnInit(): Promise<void> {
    await this.moviesSrv.getMovies().subscribe((data) => {
      this.movies = data;
    })
    this.getFavs();
    setTimeout(() => {
      this.caricamento = false; 
      this.filtraFav()
    }, 1000);
   
  }

  getFavs() {
    const activeUser: any = localStorage.getItem('user')
    const activeUserId = JSON.parse(activeUser).user.id;
    this.moviesSrv.getFavs().subscribe((data) => {
      this.allFavs = data;
      this.userFav = this.allFavs.filter((fav) => fav.userId === activeUserId)
      console.log(this.userFav); //ok!
    })
  }

  filtraFav(){
    for (let i=0; i<this.movies.length; i++) {
      for (let j=0; j<this.userFav.length; j++){
        if (this.movies[i].id===this.userFav[j].movieId) {
          this.favMovies.push(this.movies[i])
        }
      }
    }
    console.log(this.favMovies)
  }

}
