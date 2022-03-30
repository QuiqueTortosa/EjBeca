import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GestorUsuario } from 'src/app/model/negocio/GestorUsuario'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  gmail: string = "";
  password: string = "";

  warnL: number = 100;

  usuarioG: GestorUsuario = new GestorUsuario()


  constructor(private router: Router) {
    
  }

  ngOnInit(): void {

  }


  login() {
    switch (this.usuarioG.login(this.gmail, this.password)) {
      case 0:
        this.warnL = 0
        break;
      case 1:
        this.warnL = 1
        break;
      default:
        this.router.navigate(["/videojuegos",this.usuarioG.getByGmail(this.gmail)?.id])
        break;
    }
  }



}
