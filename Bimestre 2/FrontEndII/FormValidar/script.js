const button = document.querySelector('button');
button.addEventListener('click', (e) =>{
    e.preventDefault();
    const nombre = document.querySelector("#nombre");
    const correo = document.querySelector("#correo");
    const contrasenia = document.querySelector("#contrasenia");
    const terminos = document.querySelector("#terminos");
    console.log("Esto fue un click");
    console.log(nombre.value);
    if (nombre.value.length >= 25){
        alert("Cabezon! el nobre no puede tener más de 25 caracteres");
    }
    console.log(correo.value.indexOf('@'));
    console.log(correo.value.indexOf('.com'));

});

