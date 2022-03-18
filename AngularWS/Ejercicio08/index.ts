class Equipo {

    private _id: number;
    private _nombre: String;
    private _fechaFundacion: Date;
    private _jugadoresLista: Jugador[] = [];

    constructor(id: number, nombre: String, fechaFundacion: Date) {
        this._id = id;
        this._nombre = nombre;
        this._fechaFundacion = fechaFundacion;
    }

    anadirJugador(jugador: Jugador) {
        this._jugadoresLista.push(jugador)
    }

    toString() {
        let resultado: String = `Equipo: ${this._nombre}\nFecha Origen: ${this._fechaFundacion}\nJugadores:\n`
        for (let jugador of this._jugadoresLista) {
            resultado += `\tNombre: ${jugador.nombre}, Edad: ${jugador.edad}, Pais: ${jugador.pais}\n`
        }
        console.log(resultado)
    }
}

class Jugador {

    private _id: number;
    private _nombre: String;
    private _edad: number;
    private _pais: String;
    private _historial: Historial = null;

    constructor(id: number, nombre: String, edad: number, pais: String) {
        this._id = id;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
    }

    public get nombre() {
        return this._nombre
    }

    public get edad() {
        return this._edad
    }

    public get pais() {
        return this._pais
    }

    anadirHistorial(historial: Historial) {
        this._historial = historial;
    }

    toString() {
        if (this._historial != null) {
            console.log(`ID: ${this._id} 
            \nJugador: ${this._nombre}
            \nEdad: ${this._edad}
            \nPais: ${this._pais} 
            \nHistorial:
            \n${this._historial.toString()}`)
        } else {
            console.log(`ID: ${this._nombre} 
            \nJugador: ${this._nombre}
            \nEdad: ${this._edad}
            \nPais: ${this._pais}`)
        }
    }
}

class Historial {

    private _id: number;
    private _nmGoles: number;
    private _nmTRojas: number;
    private _nmTAm: number;

    constructor(id: number, nmGoles: number, nmTRojas: number, nmTAm: number) {
        this._id = id;
        this._nmGoles = nmGoles;
        this._nmTAm = nmTAm;
        this._nmTRojas = nmTRojas;
    }

    toString() {
        return `\t- Id: ${this._id} 
        \n\t- Goles: ${this._nmGoles}
        \n\t- Tarjetas Rojas: ${this._nmTRojas}
        \n\t- Tarjetas Amarillas: ${this._nmTAm}`;
    }
}

console.log("--------------------------------------------------")
console.log("--------------------Equipo 1----------------------")
console.log("--------------------------------------------------")

let equipo1 = new Equipo(1, "Madrid", new Date("2019-10-10"));
let pepe = new Jugador(1, "Pepe", 33, "España")
let fran = new Jugador(2, "Fran", 23, "España")
let pique = new Jugador(3, "Pique", 25, "España")
let benito = new Jugador(4, "Benito", 19, "España")
equipo1.anadirJugador(pepe);
equipo1.anadirJugador(fran);
equipo1.anadirJugador(pique);
equipo1.anadirJugador(benito);
equipo1.toString();

console.log("--------------------------------------------------")
console.log("----------------Equipo Frances--------------------")
console.log("--------------------------------------------------")
let francia = new Equipo(1, "Francia", new Date("2002-10-10"));
let Mikel = new Jugador(1, "Mikel", 35, "Francia")
let Mule = new Jugador(2, "Mule", 23, "Francia")
let Cale = new Jugador(3, "Cale", 25, "Francia")
let Nton = new Jugador(4, "Nton", 19, "Francia")
francia.anadirJugador(Mikel);
francia.anadirJugador(Mule);
francia.anadirJugador(Cale);
francia.anadirJugador(Nton);
francia.toString();

console.log("--------------------------------------------------")
console.log("--------------------Historial Pepe----------------")
console.log("--------------------------------------------------")
pepe.anadirHistorial(new Historial(1, 5, 0, 2));

pepe.toString();

console.log("--------------------------------------------------")
console.log("--------------------Historial Mikel---------------")
console.log("--------------------------------------------------")
Mikel.anadirHistorial(new Historial(2, 15, 4, 12));

Mikel.toString();