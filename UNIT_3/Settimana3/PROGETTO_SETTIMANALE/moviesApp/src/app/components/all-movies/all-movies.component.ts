import { Component, OnInit } from '@angular/core';
import { Fav } from 'src/app/interfaces/fav.interface';
import { Movie } from 'src/app/interfaces/movie.interface';
import { MoviesService } from 'src/app/service/movies.service';


@Component({
  selector: 'app-all-movies',
  templateUrl: './all-movies.component.html',
  styleUrls: ['./all-movies.component.scss']
})
export class AllMoviesComponent implements OnInit {
  movies!: Movie[];
  allFavs!: Fav[];
  userFav: Fav[] = [];

  caricamento = true;

  constructor(private moviesSrv: MoviesService) { }

  async ngOnInit(): Promise<void> {
    await this.moviesSrv.getMovies().subscribe((data) => {
      this.movies = data;
      console.log(this.movies)
    })
    this.getFavs();
    setTimeout(() => {
      this.caricamento = false;
    }, 1000);
  }

  addFav(movieId: number) {
    const activeUser: any = localStorage.getItem('user')
    const userId = JSON.parse(activeUser).user.id;
    this.moviesSrv.addFavourite(movieId, userId).subscribe();
    this.getFavs()
  }

  daRimuovere!:Fav|any
  removeFav(movieID: number) {
    this.daRimuovere = this.userFav.find(fav=>fav.movieId==movieID)
    this.moviesSrv.removeFav(this.daRimuovere.id).subscribe();
    this.getFavs()
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


  isFav(id: number) {
    if (this.userFav.find(fav => fav.movieId === id)) {
      return true
    }
    else { return false }
  }
}
