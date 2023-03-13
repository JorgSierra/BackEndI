const form = document.querySelector("form");


form.addEventListener("submit", function (evento) {
    evento.preventDefault();

    const inputRaza = document.querySelector("#input-raza");

    const validacion = validarTexto(inputRaza.value);

    if (validacion) {
        buscarPerro(inputRaza.value);
    } else {
        alert("Búsqueda incorrecta, reintente.")
    }

    form.reset();
});

/* -------------------------------------------------------------------------- */
/*                                 CONSIGNA 1                                 */
/* -------------------------------------------------------------------------- */
/*
CONSIGNA: Validando el campo. Crear una funcion que reciba el input del usuario
y realice las siguientes tareas:

--> No se deben contar los espacios extra al principio o final
--> Validar que el texto tenga al menos 3 caracteres

✅-> Si pasa las validaciones la función debe devolver TRUE
⛔-> Si NO pasa las validaciones la función debe devolver FALSE
*/
function validarTexto(texto) {
    let validacion = texto.trim();
    if (validacion.length < 3){
        return false;
    }
    else{
        return true;
    }
};
/* -------------------------------------------------------------------------- */
/*                                 CONSIGNA 2                                 */
/* -------------------------------------------------------------------------- */
/*
CONSIGNA: Desarrollar la función que realice un fetch a la API
de Dog API y obtenga una imagen random de perro según la raza buscada.
Recibe por parametros la raza, y debe interpolar la raza en la Endpoit mencionado abajo.

MÉTODO: GET
ENDPOINT: https://dog.ceo/api/breed/{{raza}}/images/random
RESULTADO: Nos devuelve un objeto con la información.

Dentro del <div> con la clase "tarjeta" debemos insertar:
✅-> Si la raza existe, una imagen con la url que nos llega.
⛔-> Si NO existe la raza, un párrafo que diga "Raza no encontrada"
*/
function buscarPerro(raza) {

    let url = `https://dog.ceo/api/breed/${raza}/images/random`;

    fetch(url)
    .then(respuesta =>{
        return respuesta.json();
    }).then(info => {
        const contenedor = document.querySelector(".tarjeta");
        if (info.status == "success"){
            contenedor.innerHTML = `<img src="${info.message}">`;
        }
        else{
            contenedor.innerHTML = "<p>Raza no encontrada</p>";
        }
    });
         
   
};