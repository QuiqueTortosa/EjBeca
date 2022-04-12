import { Usuario } from "../entidades/Usuario"

export class DaoUsuario {

    private static listaUsuarios: Usuario[] = [] 

    static {
        this.listaUsuarios.push(new Usuario("a","a","123123123","a"))
    }

    /*
    *@param gmail del Usuario
    * @return el usuario, en caso contrario devuelve null
    */
    public getByGmail(gmail: String): Usuario | undefined{
        let u: Usuario;
        for(u of DaoUsuario.listaUsuarios) {
            if(u.gmail === gmail){
                console.log("coincide")
                return u;
            }
        }
        return undefined;
    }

    /*
    *@param id del Usuario
    *@return usuario si lo encuentra undefined si no lo encuentra
    */
    public getById(id: number): Usuario | undefined {
        let u: Usuario;
        for(u of DaoUsuario.listaUsuarios) {
            if(u.id === id){
                return u;
            }
        }
        return undefined;
    }

    /*
    *@param el usuario a añadir
    */
    public anadirUsuario(usuario: Usuario) {
        DaoUsuario.listaUsuarios.push(usuario)
    }
}