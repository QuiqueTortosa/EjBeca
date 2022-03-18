import { Component, OnInit } from '@angular/core';
import { Videojuego } from 'src/app/entidades/videojuego';

@Component({
  selector: 'app-videojuegos',
  templateUrl: './videojuegos.component.html',
  styleUrls: ['./videojuegos.component.css']
})
export class VideojuegosComponent implements OnInit {

  editarFlag: boolean = false;
  errorFlag: boolean = false;

  id: number = 0;
  titulo: string = "";
  compania: string = "";
  valoracion: number = 0;

  videojuegoL: Videojuego [] = [];
  videojuego: Videojuego | null = null;

  constructor() { 
    let v : Videojuego = new Videojuego("Mario", "Aaaaa", 2);
    this.videojuegoL.push(v)
    v = new Videojuego("Superman", "DC", 3)
    this.videojuegoL.push(v)
  }

  ngOnInit() {

  }

  public insertar(){
    if(!(this.titulo == "" || this.compania == "")){
      this.videojuegoL.push(new Videojuego(this.titulo, this.compania, this.valoracion))
      this.vaciar()
      this.errorFlag = false;
    }
    else{
      this.errorFlag = true;
    }
  }

  public guardar() {
    for(let v of this.videojuegoL){
      if(v.id == this.id){
        v.titulo = this.titulo
        v.valoracion = this.valoracion
        v.compania = this.compania
        break
      }
    }
    this.editarFlag = false;
    this.vaciar()
  }

  public editar(juego: Videojuego) {
    console.log(juego)
    this.id = juego.id;
    this.compania = juego.compania
    this.valoracion = juego.valoracion
    this.titulo = juego.titulo
    this.editarFlag = true;
  }

  public eliminar(id: number){
    for(let i = 0; i < this.videojuegoL.length; i++){
      if(id == this.videojuegoL[i].id){
        this.videojuegoL.splice(i,1)
        break
      }
    }
  }

  public vaciar(){
    this.id = 0;
    this.compania = ""
    this.valoracion = 0
    this.titulo = ""
  }
}
