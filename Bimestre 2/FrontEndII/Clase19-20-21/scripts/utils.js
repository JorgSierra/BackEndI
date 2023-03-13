/* ---------------------------------- texto --------------------------------- */
function validarTexto(texto) {
    
}

function normalizarTexto(texto) {
    
}

/* ---------------------------------- email --------------------------------- */
function validarEmail(email) {
    let RFC2822_emailValidation = /[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/g;
    if(email.match(RFC2822_emailValidation)){
        return true;
    }
    return false;
}

function normalizarEmail(email) {
    return email.toLowerCase();
}

/* -------------------------------- password -------------------------------- */
function validarContrasenia(contrasenia) {
    if (contrasenia == ""){
        return false;
    }
}

function compararContrasenias(contrasenia_1, contrasenia_2) {
    if (contrasenia_1 === contrasenia_2){
        return true;
    }
    return false;
}

