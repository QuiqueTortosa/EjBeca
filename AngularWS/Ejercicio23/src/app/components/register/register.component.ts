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

  async registrar() {
    if(this.gmail == "" || this.password == "" || this.passwordCheck == "" || this.nombre=="" || this.telefono == ""){
      this.warnR = 0 //Faltan parametros
    }else if(this.password != this.passwordCheck){
      this.warnR = 1 //Las contraseñas no coinciden
    }else {
      await fetch(`http://localhost:4000/Ejercicio21/Register?name=${this.nombre}&email=${this.gmail}&pass=${this.password}`,{mode: 'cors'})
      .then(v => v.json())
      .then(v => {  
        if(JSON.stringify(v).includes("user")){
          this.usuarioG.registrar(this.gmail, this.password, this.passwordCheck, this.telefono, this.nombre)
          this.router.navigateByUrl('/login')
        }
      });
  }
}
}
