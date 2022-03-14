
let arrayN = []

function agregarNumero() {
    if (!numberAdd.value == "") {
        var almacen = ""
        arrayN.push(parseInt(document.getElementById("numberAdd").value))
        document.getElementById("inf").textContent = "Has añadido el numero " + document.getElementById("numberAdd").value;
        for(n of arrayN) {
            almacen += " " + n;
        }
        document.getElementById("mostarNum").textContent = "Numeros en el array: " + almacen;
        console.log(almacen)
    }
}

function randomNumber() {
    document.getElementById("numeroAleatorio").textContent = arrayN[Math.floor(getRandomInterval(0, arrayN.length))];

}

function getRandomInterval(min, max) {
    return Math.random() * (max - min) + min;
}