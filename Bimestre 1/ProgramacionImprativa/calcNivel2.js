const prompt = require("prompt-sync")({ sigint: true });

function sumar(num1, num2){
    return num1 + num2;
}

let resultadoSuma = sumar(); 

function restar(num1, num2){
    return num1 - num2;
}
let resultadoResta = restar();

function multiplicar(num1, num2){
    return num1 * num2;
}

let resultadoMultiplicacion = multiplicar;

function dividir(num1, num2){
    return num1 / num2;
}

function cuadradoDeUnNumero(num){
    return multiplicar(num, num);
}



console.log("-------------------- Testeo de operaciones/calculadora -----------")

console.log(sumar(2, 4));
console.log(restar(2, 4));
console.log(multiplicar(2, 4));
console.log(dividir(2, 4));
console.log(cuadradoDeUnNumero(2));