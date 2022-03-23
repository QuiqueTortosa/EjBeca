export class Videojuego{

    private _id : number = 0;
    
    private static contadorId : number = 1;

    constructor(public titulo : string, public compania : string, public icono: string, public valoracion : number){
        this._id = Videojuego.contadorId++;
        this.titulo = titulo;
        this.compania = compania;
        this.icono = icono
        this.valoracion = valoracion;
    }

    public get id() : number{
        return this._id;
    }
}