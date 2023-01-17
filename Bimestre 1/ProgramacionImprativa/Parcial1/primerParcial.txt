// Ejercicio 1: 
console.log("- - - - - - Ejercicio 1 - - - - - -")
// Desarrollar una función para cada uno de las siguientes apartados: 
// Que reciba por parámetro un número entero y retorne su triple.
function triple (num){
    return num * 3;
}
// Test
console.log("- Triple de el número 3");
console.log(triple(3));


// Que reciba por parámetro dos números enteros y retorne la multiplicación de ambos.  
function mutl (a, b){
    return a * b;
}
// Test
console.log("- Multiplicación 3 * 2");
console.log(mutl(3, 2));

// Que reciba por parámetro dos números enteros, verificar que sean distintos de 0 y retorne la división de ambos.
function div (a, b){
    if (a != 0 && b != 0){
        return a / b;
    }
}
// Test
console.log("- División 3 * 2");
console.log(div(3, 2));


// Ejercicio 2:
console.log("\n- - - - - - Ejercicio 2 - - - - - -");
//  Deberás escribir un objeto literal llamado turista que contenga las siguientes propiedades que deberás completar con tus datos:
// nombre
// apellido 
// temperatura
// está Vacunado (TRUE/FALSE)
let turista = {
    nombre : "Jorge",
    apellido : "Sierra",
    temperatura : 38.9,
    vacunado : true
}

// Crear una función que reciba por parámetro el objeto y retorne un string en base a las siguientes condiciones :
// -     si temperatura es menor a 37:  “puede pasar”,
// -	 si temperatura es mayor o igual a 37 y menor que 39 y si está vacunado: “puede pasar porque está vacunado”
// -	si temperatura es 39 o mayor: “no puede pasar“
function acceso (persona){
    if (persona.temperatura < 37){
        return "pude pasar";
    }
    else if (persona.temperatura >= 37 && persona.temperatura < 39 && persona.vacunado){
        return "puede pasar porque está vacunado";
    }
    else{
        return "no puede pasar";
    }
}

// Test
console.log("- Acceso");
let mensajeDeAcceso = acceso(turista);
console.log(mensajeDeAcceso);


// Ejercicio 3:
console.log("\n- - - - - - Ejercicio 3 - - - - - -");
// Crear un array VACÍO llamado destinos. 
let destinos = [];
// Dados estos tres objetos:
let brasil = {
    cantidadDeVisitas : 3,
    clima: "soleado",
    habitantes: "212 millones"
}
let rusia = {
    cantidadDeVisitas : 4,
    clima: "frío",
    habitantes: "144 millones"
}
let estadosUnidos = {
    cantidadDeVisitas : 1,
    clima: "nublado",
    habitantes: "329 millones"
}
// Agregarlos al array. (utilizando un método JS, pensa cuál podrías utilizar)
destinos.push(brasil);
destinos.push(rusia);
destinos.push(estadosUnidos);
// Mostrar por consola el array para ver que contenga esos objetos.
console.log("- Contenido de destinos");
console.log(destinos);
// Crea una función que reciba el array destinos como parámetro, e incremente en 1 la cantidad de visitas de cada uno de los destinos, llámala siguienteViaje. 
function siguienteViaje (arr){
    for (let i = 0; i < arr.length; i++){
        arr[i].cantidadDeVisitas++;
    }
}
// Mostrar por consola el array de destinos antes y después de la ejecución de la función. 
console.log("- Mostrar contenido antes de sigienteViaje");
console.log(destinos);
siguienteViaje(destinos);
console.log("- Luego de sigienteViaje");
console.log(destinos);
