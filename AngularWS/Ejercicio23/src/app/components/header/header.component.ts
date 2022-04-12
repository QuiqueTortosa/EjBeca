import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GestorUsuario } from 'src/app/model/negocio/GestorUsuario';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  usuarioG: GestorUsuario = new GestorUsuario()
  userId: number = 0;
  
  constructor(aRoute: ActivatedRoute) { 
    this.userId = aRoute.snapshot.params['idU']
  }

  ngOnInit() {
  }

}
