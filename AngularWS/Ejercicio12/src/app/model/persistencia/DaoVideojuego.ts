import { Videojuego } from "../entidades/Videojuego" 

export class DaoVideojuego {

    private static listaVideojuegos: Videojuego[] = []

    static {
        this.listaVideojuegos.push(new Videojuego("Mario","Nintendo","/assets/img/mario.png",8))
        this.listaVideojuegos.push(new Videojuego("Sonic", "Sega","/assets/img/sonic.jpg",7))
        this.listaVideojuegos.push(new Videojuego("League of Legends", "Riot Games","/assets/img/lol.jpg",10))
        this.listaVideojuegos.push(new Videojuego("Assassin's Creed","Ubisoft","/assets/img/odyssey.png",9))
    }

    /*
    * Devuelve el usuario, en caso contrario devuelve null
    */

    public getById(id: number): Videojuego | undefined {
        let u: Videojuego;
        for(u of DaoVideojuego.listaVideojuegos) {
            if(u.id === id){
                console.log("coincide")
                return u;
            }
        }
        return undefined;
    }

    public getAllVideojuegos(): Videojuego [] | undefined {
        return DaoVideojuego.listaVideojuegos
    }
}