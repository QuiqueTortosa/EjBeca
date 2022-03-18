var Equipo = /** @class */ (function () {
    function Equipo(id, nombre, fechaFundacion) {
        this._jugadoresLista = [];
        this._id = id;
        this._nombre = nombre;
        this._fechaFundacion = fechaFundacion;
    }
    Equipo.prototype.anadirJugador = function (jugador) {
        this._jugadoresLista.push(jugador);
    };
    Equipo.prototype.toString = function () {
        var resultado = "Equipo: ".concat(this._nombre, "\nFecha Origen: ").concat(this._fechaFundacion, "\nJugadores:\n");
        for (var _i = 0, _a = this._jugadoresLista; _i < _a.length; _i++) {
            var jugador = _a[_i];
            resultado += "\tNombre: ".concat(jugador.nombre, ", Edad: ").concat(jugador.edad, ", Pais: ").concat(jugador.pais, "\n");
        }
        console.log(resultado);
    };
    return Equipo;
}());
var Jugador = /** @class */ (function () {
    function Jugador(id, nombre, edad, pais) {
        this._historial = null;
        this._id = id;
        this._nombre = nombre;
        this._edad = edad;
        this._pais = pais;
    }
    Object.defineProperty(Jugador.prototype, "nombre", {
        get: function () {
            return this._nombre;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Jugador.prototype, "edad", {
        get: function () {
            return this._edad;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Jugador.prototype, "pais", {
        get: function () {
            return this._pais;
        },
        enumerable: false,
        configurable: true
    });
    Jugador.prototype.anadirHistorial = function (historial) {
        this._historial = historial;
    };
    Jugador.prototype.toString = function () {
        if (this._historial != null) {
            console.log("ID: ".concat(this._id, " \n            \nJugador: ").concat(this._nombre, "\n            \nEdad: ").concat(this._edad, "\n            \nPais: ").concat(this._pais, " \n            \nHistorial:\n            \n").concat(this._historial.toString()));
        }
        else {
            console.log("ID: ".concat(this._nombre, " \n            \nJugador: ").concat(this._nombre, "\n            \nEdad: ").concat(this._edad, "\n            \nPais: ").concat(this._pais));
        }
    };
    return Jugador;
}());
var Historial = /** @class */ (function () {
    function Historial(id, nmGoles, nmTRojas, nmTAm) {
        this._id = id;
        this._nmGoles = nmGoles;
        this._nmTAm = nmTAm;
        this._nmTRojas = nmTRojas;
    }
    Historial.prototype.toString = function () {
        return "\t- Id: ".concat(this._id, " \n        \n\t- Goles: ").concat(this._nmGoles, "\n        \n\t- Tarjetas Rojas: ").concat(this._nmTRojas, "\n        \n\t- Tarjetas Amarillas: ").concat(this._nmTAm);
    };
    return Historial;
}());
console.log("--------------------------------------------------");
console.log("--------------------Equipo 1----------------------");
console.log("--------------------------------------------------");
var equipo1 = new Equipo(1, "Madrid", new Date("2019-10-10"));
var pepe = new Jugador(1, "Pepe", 33, "España");
var fran = new Jugador(2, "Fran", 23, "España");
var pique = new Jugador(3, "Pique", 25, "España");
var benito = new Jugador(4, "Benito", 19, "España");
equipo1.anadirJugador(pepe);
equipo1.anadirJugador(fran);
equipo1.anadirJugador(pique);
equipo1.anadirJugador(benito);
equipo1.toString();
console.log("--------------------------------------------------");
console.log("----------------Equipo Frances--------------------");
console.log("--------------------------------------------------");
var francia = new Equipo(1, "Francia", new Date("2002-10-10"));
var Mikel = new Jugador(1, "Mikel", 35, "Francia");
var Mule = new Jugador(2, "Mule", 23, "Francia");
var Cale = new Jugador(3, "Cale", 25, "Francia");
var Nton = new Jugador(4, "Nton", 19, "Francia");
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
