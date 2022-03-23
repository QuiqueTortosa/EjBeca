import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GestorVideojuego } from 'src/app/model/negocio/GestorVideojuego';
import { GestorUsuario } from 'src/app/model/negocio/GestorUsuario';
import { Videojuego } from 'src/app/model/entidades/Videojuego';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/entidades/Usuario';

@Component({
  selector: 'app-videojuegos',
  templateUrl: './videojuegos.component.html',
  styleUrls: ['./videojuegos.component.css']
})
export class VideojuegosComponent implements OnInit {

  videojuegoG: GestorVideojuego = new GestorVideojuego()
  usuarioG: GestorUsuario = new GestorUsuario()

  aRoute: ActivatedRoute | undefined;

  videojuegoList: Videojuego[] | undefined;
  videojuego: Videojuego | undefined

  user: Usuario | undefined
  userId: number = 0;

  constructor(aRoute: ActivatedRoute, private router: Router) {
    this.userId = aRoute.snapshot.params['idU']
   }

  ngOnInit(): void {
    this.videojuegoList = this.videojuegoG.getAllVideojuegos()
    this.user = this.usuarioG.getById(Number(this.userId))
  }

  getVideojuego(id: number){  
    this.videojuego = this.videojuegoG.getById(id)
    this.router.navigate(["/videojuegos/",this.userId,"juego",id])
  }

}
