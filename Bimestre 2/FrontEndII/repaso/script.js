const premioTotal = 2500;
const casilla = 10;

function calcular(aciertos){
    let premioXcasilla = premioTotal/casilla;
    return premioXcasilla * aciertos;
}
console.log(calcular(5));

console.log(Math.random())


window.addEventListener("load", () =>{
    const hola = document.querySelector("p")
    const boton = document.querySelector("button")
    hola.classList.add("gogo")
    hola.classList.remove("hola")
    
    boton.addEventListener("click", () =>{
        hola.classList.toggle("yes")

        if (hola.classList.contains("yes"))
        {
            console.log("si existe la clase yes")
        }
        else
        {
            console.log("no existe la clase yes")
        }
    })

});


