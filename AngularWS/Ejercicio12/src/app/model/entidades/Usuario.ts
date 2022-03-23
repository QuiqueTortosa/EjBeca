export class Usuario{

    private _id : number = 0;
    
    private static contadorId : number = 1;

    constructor(public gmail : string, public password : string, public telefono: string, public nombre: string){
        this._id = Usuario.contadorId++;
        this.gmail = gmail;
        this.password = password;
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public get id() : number{
        return this._id;
    }
}