import { Videojuego } from "../entidades/Videojuego";
import { DaoVideojuego } from "../persistencia/DaoVideojuego";

export class GestorVideojuego {

    private dv: DaoVideojuego = new DaoVideojuego();

    /*
    * return 0 cuando faltan parametros
    * return 1 cuando no encuentra un usuario o la contraseña no coincide
    * return 2 en caso de que registre correctamente
    */
    public getById(id: number): Videojuego | undefined {
        return this.dv.getById(id)
    }

    public getAllVideojuegos(): Videojuego [] | undefined {
        return this.dv.getAllVideojuegos();
    }
}