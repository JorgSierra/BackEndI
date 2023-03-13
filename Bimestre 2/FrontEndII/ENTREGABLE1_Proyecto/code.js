/* --------------------------- NO TOCAR DESDE ACÁ --------------------------- */
let datosPersona = {
  nombre: "",
  edad: 0,
  ciudad: "",
  interesPorJs: "",
};

const listado = [{
    imgUrl: "https://huguidugui.files.wordpress.com/2015/03/html1.png",
    lenguajes: "HTML y CSS",
    bimestre: "1er bimestre",
  },
  {
    imgUrl: "https://jherax.files.wordpress.com/2018/08/javascript_logo.png",
    lenguajes: "Javascript",
    bimestre: "2do bimestre",
  },
  {
    imgUrl: "https://upload.wikimedia.org/wikipedia/commons/thumb/4/47/React.svg/1200px-React.svg.png",
    lenguajes: "React JS",
    bimestre: "3er bimestre",
  },
];

const profileBtn = document.querySelector("#completar-perfil");
const materiasBtn = document.querySelector("#obtener-materias");
const verMasBtn = document.querySelector("#ver-mas");
const cambiarTema = document.querySelector('#cambiar-tema');

profileBtn.addEventListener("click", renderizarDatosUsuario);
materiasBtn.addEventListener("click", recorrerListadoYRenderizarTarjetas);
cambiarTema.addEventListener("click", alternarColorTema);
/* --------------------------- NO TOCAR HASTA ACÁ --------------------------- */

function obtenerDatosDelUsuario() {
  /* --------------- PUNTO 1: Escribe tu codigo a partir de aqui --------------- */
  datosPersona.nombre = prompt("Ingrese su nombre");
  datosPersona.edad = 2022 - parseInt(prompt("Ingrese su año de nacimiento"));
  datosPersona.ciudad = prompt("Ingrese su ciudad");
  datosPersona.interesPorJs = confirm("Está interesado en JavaScript?") ? "Si" : "No";

  /* -------------- Verificando que la entrada del cliente sea valida
  let isValid = false;
  let espanolRegex = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/
  let anioActual = 2022;
  do
  {
    datosPersona.nombre = prompt("Ingrese su nombre");
    isValid = datosPersona.nombre.match(espanolRegex);
    if(!isValid){
      alert("El nombre debe contener letras unicamente");
    }
  }while(!isValid);
  do
  {
    datosPersona.edad = anioActual - parseInt(prompt("Ingrese su año de nacimiento"));
    isValid = !isNaN(datosPersona.edad);
    if(!isValid){
      alert("El año debe ser un valor numerico");
    }
  }while(!isValid);
  do
  {
    datosPersona.ciudad = prompt("Ingrese su ciudad");
    isValid = datosPersona.ciudad.match(espanolRegex);
    if(!isValid){
      alert("La ciudad debe contener letras unicamente");
    }
  }while(!isValid);
  datosPersona.interesPorJs = confirm("Está interesado en JavaScript?") ? "Si" : "No";
  Fin verificado -------------- */

}

function renderizarDatosUsuario() {
  /* ------------------- NO TOCAR NI ELIMINAR ESTA FUNCION. ------------------- */
  obtenerDatosDelUsuario();
  /* ------------------ PUNTO 2: Escribe tu codigo desde aqui ------------------ */
  let nombre = document.querySelector("#nombre");
  let edad = document.querySelector("#edad");
  let ciudad = document.querySelector("#ciudad");
  let javascript = document.querySelector("#javascript");

  nombre.textContent = datosPersona.nombre;
  edad.textContent = datosPersona.edad;
  ciudad.textContent = datosPersona.ciudad;
  javascript.textContent = datosPersona.interesPorJs;
}


function recorrerListadoYRenderizarTarjetas() {
  /* ------------------ PUNTO 3: Escribe tu codigo desde aqui ------------------ */
  let fila = document.querySelector("#fila");
  if (fila.innerHTML == ""){
    listado.forEach(e => {
      fila.innerHTML += `<div class="caja">
        <img src="${e.imgUrl}" alt="${e.lenguajes}">
        <p class="lenguajes">${e.lenguajes}</p>
        <p class="bimestre">${e.bimestre}</p>
      </div>`
    });
  }
}

function alternarColorTema() {
  /* --------------------- PUNTO 4: Escribe tu codigo aqui --------------------- */
  let sitio = document.querySelector("#sitio");
  sitio.classList.toggle("dark");
}

/* --------------------- PUNTO 5: Escribe tu codigo aqui --------------------- */

window.addEventListener("keyup", function(e){
  if (e.key == "f" || e.key == "F"){
    let aboutMe = document.querySelector("#sobre-mi");

    if (hasClass("oculto", aboutMe.getAttribute("class"))){
      aboutMe.classList.remove("oculto");
    }
  }  
});

function hasClass(word, ClassString){
  if (ClassString != null){
    array = ClassString.split(" ");
    for (let i = 0; i < array.length; i++){
      if (array[i] == word){
        return true;
      }
    }
  }
  return false;
}

/* -------------- Verificando que el mouse este sobre la card
card.addEventListener("mouseover", function(e) {
  let card = document.querySelector("#card");
  card.classList.add("active");
});
card.addEventListener("mouseout", function(e) {
  let card = document.querySelector("#card");
  card.classList.remove("active");
});
window.addEventListener("keyup", function(e){
  if (e.key == "f" || e.key == "F"){
    let card = document.querySelector("#card");
    let aboutMe = document.querySelector("#sobre-mi");

    if (hasClass("oculto", aboutMe.getAttribute("class"))){
      if (hasClass("active", card.getAttribute("class"))){
        aboutMe.classList.remove("oculto");
      }
    }
  }  
});
Fin verificado -------------- */