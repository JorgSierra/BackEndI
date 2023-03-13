/*
REQUERIMIENTOS
- utilizar el formulario para captar el texto ingresado
 
- implmentar el evento "submit", utilizarlo para guardar el comentario en un array

- cada vez que se agrega un nuevo comentario renderizarlo en una etiqueta "p"(sacar del html los hardcodeados y hacerlo dinamico)

- constantemente guardar la informacion en localStorage, si se recarga la pagina deberian mantenerse los comentarios
*/

// - utilizar el formulario para captar el texto ingresado
let comentario = document.querySelector("#comentario");
const form = document.querySelector("form");

form.addEventListener("submit", (e) =>{
    e.preventDefault();
    let aRenderizar = document.querySelectorAll(".comentarios p");
    aRenderizar[2].innerHTML = aRenderizar[1].innerHTML;
    aRenderizar[1].innerHTML = aRenderizar[0].innerHTML;
    aRenderizar[0].innerHTML = comentario.value;
    
    let searchHistory = []; 
    aRenderizar.forEach(element => {
        searchHistory.push(element.innerHTML);
    });

    console.log(searchHistory);



    

    // function saveSearchInHistory(textToSearch) {
    //     // Busco del localStore para que no se pierda el historial al refrescar la pÃ¡gina
    //     if(localStorage.getItem('search') != null){
    //         searchHistory = JSON.parse(localStorage.getItem('search'));
    //     }
    //     searchHistory.push(textToSearch);
    //     localStorage.setItem('search', JSON.stringify(searchHistory));
    // }

});
