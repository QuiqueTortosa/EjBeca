class Equipo {
    constructor(id, nombre, fechaFundacion) {
        this._jugadoresLista = [];
        this._id = id;
        this._nombre = nombre;
        this._fechaFundacion = fechaFundacion;
    }
    anadirJugador(jugador) {
        this._jugadoresLista.push(jugador);
    }
    toString() {
        let resultado = `Equipo: ${this._nombre}\nFecha Origen: ${this._fechaFundacion}\nJugadores:\n`;
        for (let jugador of this._jugadoresLista) {
            resultado += `\tNombre: ${jugador.getNombre()}, Edad: ${jugador.getEdad()}, Pais: ${jugador.getPais()}\n`;
        }
        console.log(resultado);
    }
}
class Jugador {
    constructor(id, nombre, edad, pais) {
        this._historial = null;
        this._id = id;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
    }
    getNombre() {
        return this._nombre;
    }
    getEdad() {
        return this._edad;
    }
    getPais() {
        return this._pais;
    }
    anadirHistorial(historial) {
        this._historial = historial;
    }
    toString() {
        if (this._historial != null) {
            console.log(`ID: ${this._id} 
            \nJugador: ${this._nombre}
            \nEdad: ${this._edad}
            \nPais: ${this._pais} 
            \nHistorial:
            \n${this._historial.toString()}`);
        }
        else {
            console.log(`ID: ${this._nombre} 
            \nJugador: ${this._nombre}
            \nEdad: ${this._edad}
            \nPais: ${this._pais}`);
        }
    }
}
class Historial {
    constructor(id, nmGoles, nmTRojas, nmTAm) {
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
console.log("--------------------------------------------------");
console.log("--------------------Equipo 1----------------------");
console.log("--------------------------------------------------");
let equipo1 = new Equipo(1, "Madrid", new Date("2019-10-10"));
let pepe = new Jugador(1, "Pepe", 33, "España");
let fran = new Jugador(2, "Fran", 23, "España");
let pique = new Jugador(3, "Pique", 25, "España");
let benito = new Jugador(4, "Benito", 19, "España");
equipo1.anadirJugador(pepe);
equipo1.anadirJugador(fran);
equipo1.anadirJugador(pique);
equipo1.anadirJugador(benito);
equipo1.toString();
console.log("--------------------------------------------------");
console.log("----------------Equipo Frances--------------------");
console.log("--------------------------------------------------");
let francia = new Equipo(1, "Francia", new Date("2002-10-10"));
let Mikel = new Jugador(1, "Mikel", 35, "Francia");
let Mule = new Jugador(2, "Mule", 23, "Francia");
let Cale = new Jugador(3, "Cale", 25, "Francia");
let Nton = new Jugador(4, "Nton", 19, "Francia");
francia.anadirJugador(Mikel);
francia.anadirJugador(Mule);
francia.anadirJugador(Cale);
francia.anadirJugador(Nton);
francia.toString();
console.log("--------------------------------------------------");
console.log("--------------------Historial Pepe----------------");
console.log("--------------------------------------------------");
pepe.anadirHistorial(new Historial(1, 5, 0, 2));
pepe.toString();
console.log("--------------------------------------------------");
console.log("--------------------Historial Mikel---------------");
console.log("--------------------------------------------------");
Mikel.anadirHistorial(new Historial(2, 15, 4, 12));
Mikel.toString();
