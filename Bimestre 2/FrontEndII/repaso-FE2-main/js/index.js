const endpoint = 'https://jsonplaceholder.typicode.com/comments/';
const nodoMensajes = document.querySelector('.mensajes');
const btnConsultar = document.querySelector('#btnConsultar');
const h1 = document.querySelector('h1');



btnConsultar.addEventListener('click', function () {
    nodoMensajes.innerHTML = '<p>Cargando mensajes...</p>'
    llamadaApi()
})




function llamadaApi() {

    fetch(endpoint)
        .then(respuesta => respuesta.json())
        .then(listado => {
            console.log(listado)
            // limpiamos la caja antes de cargar todo
            nodoMensajes.innerHTML = "";

            listado = listado.slice(0, 10)

            // recorremos el listado y creamos los elementos en el dom
            listado.forEach(elemento => {
                // creamos un template👇
                const plantilla = crearArticulo(elemento);
                // insertamos el template en el DOM👇
                nodoMensajes.innerHTML += plantilla;
            });
        })
}



function crearArticulo(objeto) {
    return `
    <article>
        <h4>Asunto: <span>${objeto.name}</span></h4>
        <h6>Remitente: <span>${objeto.email}</span></h6>
        <hr>
        <p>Mensaje: <span>${objeto.body}</span></p>
    </article>
    `
}

// const ejemplo = {
//     body: "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium",
//     email: "Eliseo@gardner.biz",
//     id: 1,
//     name: "id labore ex et quam laborum",
//     postId: 1
// }