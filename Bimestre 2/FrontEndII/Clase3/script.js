const STONE = 1;
const PAPER = 2;
const SCISSORS = 3;

// console.log(userOption);
// console.log(pcOption);

// function unaFuncion() {
//     console.log(SCISSORS);
// }

// function otraFuncion(userOption) {
//     console.log(valor);
// }

// unaFuncion();
// otraFuncion(SCISSORS);
let resultadoJuego;
let contadorJugador = 0;
let contadorPC = 0;
let i = 0;
do{
    resultadoJuego = playGame();
    console.log(resultadoJuego);
    if (resultadoJuego == 'victoria'){
        contadorJugador++;
    }
    else if (resultadoJuego == 'derrota'){
        contadorPC++;
    }
    console.log("Jugador: " + contadorJugador);
    console.log("PC: " + contadorPC);
    i++;
}while(i < 3);


function playGame() {
    let isInputValid;
    let userOption;
    do {
        userOption = prompt("¿Piedra(1), papel(2) o tijera(3)");
        isInputValid = isUserOptionValid(userOption);
    } while (isInputValid == false);

    const pcOption = parseInt(Math.random() * 3 + 1);

    return checkWinner(userOption, pcOption);
}

function playGame1() {
    let isInputValid = false;
    let userOption;

    while (isInputValid == false) {
        userOption = prompt("¿Piedra(1), papel(2) o tijera(3)");
        isInputValid = isUserOptionValid(userOption);
    }

    const pcOption = parseInt(Math.random() * 3 + 1);
    console.log(checkWinner(userOption, pcOption));
}

function checkWinner(userOpt, pcOpt) {
    let resultado = 'empate';

    // 2 == 1 + 1  1 == 3 - 2
    // 3 == 2 + 1
    if (userOpt == pcOpt + 1 || userOpt == pcOpt - 2) {
        resultado = 'victoria';
    }

    if (userOpt == pcOpt - 1 || pcOpt == userOpt - 2) {
        resultado = 'derrota';
    }

    return resultado;
}

function isUserOptionValid(userOpt) {
    let result = parseInt(userOpt);
    return !isNaN(result) && result >= 1 && result <= 3;
    // if (!isNaN(result) && result >= 1 && result <= 3) {
    //     return true;
    // } else {
    //     return false;
    // }
}

playGame();