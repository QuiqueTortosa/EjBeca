
function sumar(){
    tipoP.textContent = "suma"
    resultado.textContent = "" + (parseInt(n1.value) + parseInt(n2.value))
}

function restar(){
    tipoP.textContent = "resta"
    resultado.textContent = "" + (parseInt(n1.value) - parseInt(n2.value))
}

function multiplicar(){
    tipoP.textContent = "multiplicación"
    resultado.textContent = "" + (parseInt(n1.value) * parseInt(n2.value))
}

function dividir(){
    tipoP.textContent = "división"
    resultado.textContent = "" + (parseInt(n1.value) / parseInt(n2.value))
}