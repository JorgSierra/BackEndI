window.addEventListener('load', function() {
    /* ---------------------- obtenemos variables globales ---------------------- */
    const form = document.forms[0];
    const nombre = document.querySelector('#inputNombre');
    const apellido = document.querySelector('#inputApellido');
    const email_ = document.querySelector('#inputEmail');
    const password_ = document.querySelector('#inputPassword');
    const passwordConfirm = document.querySelector('#inputPasswordRepetida');
    const url = 'https://ctd-todo-api.herokuapp.com/v1';

    /* -------------------------------------------------------------------------- */
    /*            FUNCIÓN 1: Escuchamos el submit y preparamos el envío           */
    /* -------------------------------------------------------------------------- */
    form.addEventListener('submit', (e) =>{
        e.preventDefault();
        let informacion = {
            firstName: nombre.value,
            lastName: apellido.value,
            email: email_.value,
            password: password_.value
        }
        doSignUp(informacion);
    });

    /* -------------------------------------------------------------------------- */
    /*                    FUNCIÓN 2: Realizar el signup [POST]                    */
    /* -------------------------------------------------------------------------- */
    function doSignUp(info){
        let settings = {
            method: 'POST',
            headers: {'Content-type': 'application/json'},
            body: JSON.stringify(info)
        }

        fetch(url + "/users", settings)
        .then(res => res.json())
        .then((data) => {
            console.log(data)
        });
    }
});


// function doLogIn(info){
//     email.classList.remove("wrong");
//     password.classList.remove("wrong");

//     let settings = {
//         method: 'POST',
//         headers: {"Content-Type": "application/json; charset=UTF-8"},
//         body: JSON.stringify(info)
//     }

//     fetch(url + "/users/login", settings)
//     .then((response) => {
//         if (response.status != 200 || response.status != 201){
//             if (response.status == 400){
//                 password.classList.add("wrong");
//                 throw new Error("400_Contraseña incorrecta");
//             }
//             else if (response.status == 404){
//                 email.classList.add("wrong");
//                 throw new Error("404_El usuario no existe");
//             }
//             else if (response.status == 500){
//                 throw new Error("500_Error del servidor");
//             }
//         }
//         return response.json();
//     })
//     .then((data) => {
//         localStorage.setItem("jwt",data.jwt);
//         location.replace('./mis-tareas.html');
//     })
//     .catch((error) => {
//         console.error(error);
//     });
// }