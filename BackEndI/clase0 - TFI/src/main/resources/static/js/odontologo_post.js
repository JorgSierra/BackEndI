window.addEventListener('load', function () {
    // Link formulario
    const formulario = document.querySelector('#add_new_odontologo');
    formulario.addEventListener('submit', (e) => {
        console.log("entra al boton")
        e.preventDefault();
       // Obtener y formatear datos del formulario
        const formData = {
            matricula: document.querySelector('#matricula').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,

        };
        // Ruta y configuracion de fetch
        const url = '/odontologos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        // Ejecución fetch
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                 // Alerta de exito
                let successAlert = '<p> Agregado con exito </p>';
                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();

            })
            .catch(error => {
                // Alerta de error
                let errorAlert = '<p> Error al agregar </p>';
                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
    });


    const resetUploadForm = () => {
        document.querySelector('#matricula').value = "";
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
    }

});