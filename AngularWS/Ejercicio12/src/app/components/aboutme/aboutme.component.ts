import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GestorUsuario } from 'src/app/model/negocio/GestorUsuario';
import { Usuario } from 'src/app/model/entidades/Usuario';

@Component({
  selector: 'app-aboutme',
  templateUrl: './aboutme.component.html',
  styleUrls: ['./aboutme.component.css']
})
export class AboutmeComponent implements OnInit {

  aRoute: ActivatedRoute | undefined;

  usuarioG: GestorUsuario = new GestorUsuario()

  user: Usuario | undefined
  userId: number = 0;

  constructor(aRoute: ActivatedRoute) { 
    this.userId = aRoute.snapshot.params['idU']
  }

  ngOnInit() {
    this.user = this.usuarioG.getById(Number(this.userId))
  }
}
