// 1. Capturamos el input del usuario
const form = document.forms[0];
const saveSessionInfo = document.querySelector("#checkSaveComments");
form.addEventListener('submit', function(event) {
    event.preventDefault();
    let inputComentario = document.querySelector('#comentario');
    
    if (inputComentario.value != '') {
        addComment(inputComentario.value);
        renderComments(event);
        form.reset();
    }
});

const recupera = document.querySelector("#recuperar");
recupera.addEventListener("click", renderComments);

let savedComments = [];
const KEY_COMMENTS = 'Comments';

function addComment(comment) {
    // El objeto comentario se conforma de la siguiente manera
    // {comment:'string', date: timestamp}
    let objectComment = {comment: comment, date: Date.now()};
    if (saveSessionInfo.checked){
        let commentsFromStorage = getCommentsFromStorage();
        commentsFromStorage.push(objectComment);
        sessionStorage.setItem(KEY_COMMENTS, JSON.stringify(commentsFromStorage));
    }
    else{
        savedComments.push(objectComment);
    }
}

function renderComments(e) {
    let commentsToRender;
    let formatedDate;
    let arrayData = false;
    if (saveSessionInfo.checked || e.srcElement.getAttribute('id') == "recuperar"){
        commentsToRender = getCommentsFromStorage();
        if (commentsToRender.length == 0){
            alert("No tienes comentarios guardados en la sesion");
        }
    }
    else{
        commentsToRender = savedComments;
        arrayData = true;
    }

    let container = document.querySelector('.comentarios');
    container.innerHTML = '';

    commentsToRender.forEach((element, index) => {
        formatedDate = new Date(element.date);
        formatedDate = `${formatedDate.getDate()}/${formatedDate.getMonth()+1}/${formatedDate.getFullYear()} - ${formatedDate.getHours()}:${formatedDate.getMinutes()}`;
        container.innerHTML += `<div class="commentBox" id="comment_${index}">
        <p>${element.comment} -> Posted on: ${formatedDate}</p>
        <button>Eliminar</button>
        </div>`;
        if (arrayData){
            document.querySelector(`#comment_${index}`).classList.add("fromArray");
        }
    });
    
    let botones = document.querySelectorAll(".commentBox button");
    botones.forEach(boton => {
       boton.addEventListener("click", buttHandler);
    });    
}

function getCommentsFromStorage() {
   let savedComments = sessionStorage.getItem(KEY_COMMENTS);
   if (savedComments != null) {
    return JSON.parse(savedComments);
   }
   return [];
}


function buttHandler(e){
   let padre = e.srcElement.parentNode;
   let index = padre.getAttribute("id").split("_")[1];
   if (padre.classList.contains("fromArray")){
    savedComments.splice(index, 1);
   }
   else{
    let sessionArray = getCommentsFromStorage();
    sessionArray.splice(index, 1);
    sessionStorage.setItem(KEY_COMMENTS, JSON.stringify(sessionArray));
   }
   renderComments(e);
}


// Mesa:
// Preguntarle al usuario (utilizando el check) si quiere guardar la información en el Storage o no
// Poder eliminar un comentario
// Mostar en la hora los minutos y segundos ('dateNowFormated')


// PROBANDO

// let timestamp = Date.now();
// console.log(timestamp);
// let date = new Date(timestamp);
// console.log(date);

// date = `${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()} - ${date.getHours()}:${date.getMinutes()}`;
// console.log(date);

// let array = [1,2,3,4,5,6,7];

// array.forEach((element, index) => {
//     console.log(element + " " + index)
// });