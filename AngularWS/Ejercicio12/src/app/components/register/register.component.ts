import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GestorUsuario } from 'src/app/model/negocio/GestorUsuario';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {


  window: string = "login"

  gmail: string = "";
  nombre: string = ""
  telefono: string = ""
  password: string = "";
  passwordCheck: string = ""

  warnR: number = 100;

  usuarioG: GestorUsuario = new GestorUsuario()



  constructor(private router: Router) { }

  ngOnInit() {
  }

  registrar() {
    if(this.usuarioG.registrar(this.gmail, this.password, this.passwordCheck, this.telefono, this.nombre) == 0){
      this.warnR = 0 //Faltan parametros
    }else if(this.usuarioG.registrar(this.gmail, this.password, this.passwordCheck, this.telefono, this.nombre) == 1){
      this.warnR = 1 //Contraseña no coinciden
    }else{
      this.router.navigateByUrl('/login')
      this.warnR = 2 //Exito
    }
  }



}
