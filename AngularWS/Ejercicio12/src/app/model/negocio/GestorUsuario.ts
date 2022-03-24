import { Usuario } from "../entidades/Usuario";
import { DaoUsuario } from "../persistencia/DaoUsuario";

export class GestorUsuario {

    private du: DaoUsuario = new DaoUsuario();

    /*
    * return 0 cuando faltan parametros
    * return 1 cuando la comprobacion de contraseña no coincide
    * return 2 en caso de que registre correctamente
    */
    public registrar(gmail: string, password: string, passwordCheck: string, telefono: string, nombre: string): number {
            if(!gmail ||  !password  || !passwordCheck){
                return 0
            }
            else if(!(password == passwordCheck)){
                return 1;
            } else {
                this.du.anadirUsuario(new Usuario(gmail,password,telefono,nombre))
                return 2;
            }
    }


    /*
    * return 0 cuando faltan parametros
    * return 1 cuando no encuentra un usuario o la contraseña no coincide
    * return 2 en caso de que registre correctamente
    */
    public login (gmail:string, password: string): number{
        if(!gmail ||  !password){
            return 0
        }else if(!this.du.getByGmail(gmail) || this.du.getByGmail(gmail)?.password !== password){
            return 1
        }else {
            return 2
        }
    }

    public getById(id: number): Usuario | undefined {
        return this.du.getById(id)
    }

    public getByGmail(gmail: string): Usuario | undefined {
        return this.du.getByGmail(gmail)
    }

}