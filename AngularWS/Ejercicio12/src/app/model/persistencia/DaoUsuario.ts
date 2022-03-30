import { Usuario } from "../entidades/Usuario"

export class DaoUsuario {

    private static listaUsuarios: Usuario[] = [] 

    static {
        this.listaUsuarios.push(new Usuario("a@gmail.com","a","123123123","a"))
        this.listaUsuarios.push(new Usuario("pepe@gmail.com", "pepe", "123123123", "pepe"))
        this.listaUsuarios.push(new Usuario("alex@gmail.com", "alex", "123123123", "alex"))
        this.listaUsuarios.push(new Usuario("clara@gmail.com","clara","123123123","clara"))
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