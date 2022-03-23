import { Component, Input, OnInit } from '@angular/core';
import { Videojuego } from 'src/app/model/entidades/Videojuego';

@Component({
  selector: 'app-videojuego',
  templateUrl: './videojuego.component.html',
  styleUrls: ['./videojuego.component.css']
})
export class VideojuegoComponent implements OnInit {

  @Input() videojuego: Videojuego | undefined

  constructor() { }

  ngOnInit(): void {
  }

}
