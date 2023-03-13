// emiliano.gallo@digitalhouse.com 1234

window.addEventListener('load', function() {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const FAILED = "wrong";
    const FAILED_EMAIL = "El e-mail ingresado no es valido";
    const FAILED_USER = "El usuario ingresado no existe";
    const FAILED_PASS = "La contraseña ingresada no es correcta";
    const form = document.forms[0];
    const email = document.querySelector('#inputEmail');
    const password = document.querySelector('#inputPassword');
    const url = 'https://ctd-todo-api.herokuapp.com/v1';
    let errorArray = [];
    

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', (e) => {
        e.preventDefault();
        resetAPIerrors();
        if (errorArray.length == 0){
            email.classList.remove(FAILED);
            password.classList.remove(FAILED);
            
            let informacion = {
                email : email.value,
                password : password.value
            }

            doLogIn(informacion);
        }        
    });


    /* -------------------------------------------------------------------------- */
    /*                     FUNCIÓN 2: Realizar el login [POST]                    */
    /* -------------------------------------------------------------------------- */
    function doLogIn(info){
        let settings = {
            method: 'POST',
            headers: {"Content-Type": "application/json; charset=UTF-8"},
            body: JSON.stringify(info)
        }

        fetch(url + "/users/login", settings)
        .then((response) => {
            if (!response.ok){
                if (response.status == 400){
                    password.classList.add(FAILED);
                    addArrayError(FAILED_PASS);
                    throw new Error("400: " + FAILED_PASS);
                }
                else if (response.status == 404){
                    email.classList.add(FAILED);
                    addArrayError(FAILED_USER);
                    throw new Error("404: " + FAILED_USER);
                }
                else if (response.status == 500){
                    throw new Error("500_Error del servidor");
                }
            }
            return response.json();
        })
        .then((data) => {
            localStorage.setItem("jwt",data.jwt);
            location.replace('./mis-tareas.html');
        })
        .catch((error) => {
            console.error(error);
            errorPrint();
        });
    }


    // Escuchar y validar el campo de email
    email.addEventListener("keyup", (e) =>{
        if (validarEmail(email.value)){
            removeArrayError(FAILED_EMAIL);
            email.classList.remove(FAILED);
        }
        else{
            addArrayError(FAILED_EMAIL);
            email.classList.add(FAILED);
        }
        errorPrint();
    });

    // Modificadores de array de errores
    function addArrayError(error){
        if (!errorArray.includes(error)){
            errorArray.push(error);
        }
    }

    function removeArrayError(error){
        let index = errorArray.indexOf(error);
        if (index > -1){
            errorArray.splice(index, 1);
        }
    }

    // Resetear validacion de los erroes de la API
    function resetAPIerrors(){
        removeArrayError(FAILED_USER);
        removeArrayError(FAILED_PASS);
        errorPrint();
    }

    // Imprimir errores
    function errorPrint(){
        let errorList = document.querySelector("form ul.errorList");
        errorList.innerHTML = "";
        if (errorArray.length > 0){
            errorArray.forEach(error => {
                errorList.innerHTML += '<li>' + error + '</li>';    
            });
        }
    }
});