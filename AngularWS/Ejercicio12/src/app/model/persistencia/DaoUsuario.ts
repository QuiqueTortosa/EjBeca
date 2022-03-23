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
    * Devuelve el usuario, en caso contrario devuelve null
    */
    public getByGmail(gmail: String): Usuario | undefined{
        //console.log("gmail"+gmail)
        let u: Usuario;
        for(u of DaoUsuario.listaUsuarios) {
            if(u.gmail === gmail){
                console.log("coincide")
                return u;
            }
        }
        return undefined;
    }

    public getById(id: number): Usuario | undefined {
        let u: Usuario;
        for(u of DaoUsuario.listaUsuarios) {
            if(u.id === id){
                return u;
            }
        }
        return undefined;
    }

    public anadirUsuario(usuario: Usuario) {
        DaoUsuario.listaUsuarios.push(usuario)
    }
}