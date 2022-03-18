import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  n1: number = 2;
  n2: number = 2;
  operation: string = "operacion"
  resultado: number = 0;

  constructor() { }

  ngOnInit() {

  }

  public sumar() {
    this.operation = "suma"
    this.resultado = (Number(this.n1)+Number(this.n2))
  }

  public restar() {
    this.operation = "resta"
    this.resultado = this.n1 - this.n2
  }
  public dividir() {
    this.operation = "division"
    this.resultado = this.n1 / this.n2
  }

  public multiplicar() {
    this.operation = "multiplicacion"
    this.resultado = this.n1 * this.n2;
  }

}
