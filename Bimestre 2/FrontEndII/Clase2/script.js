const STONE = 1;
const PAPER = 2;
const SCISSORS = 3;
let userOption;
let pcOption;

do{
    do{
        userOption = parseInt(prompt("¿Piedra(1), papel(2) o tijera(3)?"));
    }
    while(!isValid(userOption));
    pcOption = parseInt(Math.random() * 3 + 1);
    whoWins (userOption, pcOption);
}while(confirm("Quieres volver a jugar?"));
alert("GAME OVER!");

function whoWins (USER_OPTION, PC_OPTION){
    console.log("La opción del PC es: " + PC_OPTION);
    if (USER_OPTION == PC_OPTION) {
        console.log("Empate, intentá de nuevo");
    } else {
        if (USER_OPTION == STONE) {
            if (PC_OPTION == SCISSORS) {
                console.log("¡Ganaste!")
            } else {
                console.log("Perdiste :(")
            }
        }

        if (USER_OPTION == SCISSORS) {
            if (PC_OPTION == PAPER) {
                console.log("¡Ganaste!")
            } else {
                console.log("Perdiste :(")
            }
        }

        if (USER_OPTION == PAPER) {
            if (PC_OPTION == STONE) {
                console.log("¡Ganaste!")
            } else {
                console.log("Perdiste :(")
            }
        }
    }
}

function isValid(USER_OPTION){
    if (USER_OPTION == STONE || USER_OPTION == PAPER || USER_OPTION == SCISSORS){
        return true;
    }
    else{
        alert("La opción ingresada no es valida, por favor reingrese un entero valido");
        return false;
    }
}





    
    
    




// PARA HACER EN LA MESA
// 1- Validar que la opción ingresada por el usuario sea válida
// 2- En caso de que no sea válida, volver a pedir