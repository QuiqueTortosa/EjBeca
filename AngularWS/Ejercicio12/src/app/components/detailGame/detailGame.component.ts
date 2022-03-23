import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Videojuego } from 'src/app/model/entidades/Videojuego';
import { GestorVideojuego } from 'src/app/model/negocio/GestorVideojuego';

@Component({
  selector: 'app-detailGame',
  templateUrl: './detailGame.component.html',
  styleUrls: ['./detailGame.component.css']
})
export class DetailGameComponent implements OnInit {

  videojuegoId: number = 0;

  videojuegoG: GestorVideojuego = new GestorVideojuego()
  videojuego: Videojuego |undefined;

  userId: number = 0;
  
  constructor(private aRoute: ActivatedRoute) { 
    this.videojuegoId = aRoute.snapshot.params['idV']
    this.userId = aRoute.snapshot.params['idU']
  }

  ngOnInit() {
    this.videojuego = this.videojuegoG.getById(Number(this.videojuegoId))
  }

  getVideojuego(){
    console.log(this.videojuego)
  }

}
