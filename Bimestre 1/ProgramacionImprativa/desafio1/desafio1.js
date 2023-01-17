/* // PUNTO 1
function puedeSubir(altura, acompaniado){
    if (altura > 0 && altura < 2){
        if (altura >= 1.4){
            return true;
        }
        else if (altura >= 1.2){
            return acompaniado ? true : false;
        }
    }
    else{
        return false;
    }
}

console.log(puedeSubir(1.3, true));

*/

/* //PUNTO 2

function puedeSubir(altura, acompaniado, penalizado){
    if (altura > 0 && altura < 2 && !penalizado){
        if (altura >= 1.4){
            return true;
        }
        else if (altura >= 1.2){
            return acompaniado ? true : false;
        }
    }
    else{
        return false;
    }
}

console.log(puedeSubir(1.4, false, true));

*/
