
function calculoMateria(cp1: number, cp2: number, cp3: number, ce: number, tf: number): number {
    console.log(`Calificaciones parciales: ${cp1}, ${cp2} y ${cp3} \nCalificacion examen: ${ce} \nCalificacion trabajo: ${tf}`)
    return ((cp1+cp2+cp3)/3)*0.55 + ce*0.3 + tf*0.15;
}

function listaJuegos(...juegos: String[]): String[]{
    return juegos.filter(juego => {return juego.toLocaleLowerCase() !== "mario"})
}

function factorial(number: number): number {
    if(number <= 1) return 1;
    return number * factorial(number-1);
}
console.log("--------------------------------------------------------")
console.log("El resultado final de la materia es:"+calculoMateria(5,5,5,5,7));
console.log("--------------------------------------------------------")
console.log("Lista final de juegos:"+listaJuegos("Spiderman","LoL","mario"));
console.log("--------------------------------------------------------")
console.log("Calculo de factorial: "+factorial(5))