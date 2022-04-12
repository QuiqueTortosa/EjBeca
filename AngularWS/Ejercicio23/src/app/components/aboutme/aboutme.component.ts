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
  gmail: string = "";

  constructor(aRoute: ActivatedRoute) { 
    this.gmail = aRoute.snapshot.params['idU']
  }

  ngOnInit() {
    this.user = this.usuarioG.getByGmail(this.gmail)
  }
}
