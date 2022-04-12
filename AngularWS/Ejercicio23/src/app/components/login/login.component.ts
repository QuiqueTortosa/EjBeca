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


  async login() {
    if(this.gmail == "" || this.password == ""){
      this.warnL = 0
    }
    else {
      await fetch(`http://localhost:4000/Ejercicio21/UserServlet?email=${this.gmail}&pass=${this.password}`,{mode: 'cors'})
      .then(v => v.json())
      .then(v => {  
        if(JSON.parse(v.validation)){
          this.router.navigate(["/videojuegos",this.gmail])
        }else {
          this.warnL = 1
        }
      });
    }
}
}
