/*
// Loop de pares
function loopDePares(numero){
    for (let i = 0; i <= 100; i++){
        if ((i + numero)%2 == 0){
            console.log("El numero " + (i + numero) + " es par");
        }
    }
}

loopDePares (2);

*/

/*
// Loop impares con palabra
function loopDeImpares(numero, palabra){
    for (let i = 0; i <= 100; i++){
        console.log(i);
        if ((i + numero)%2 != 0){
            console.log("El numero " + (i + numero) + " es impar");
        }
    }
    console.log(palabra);
}

loopDeImpares(10, "HOla hola halsdf");
*/


/*
//Sumatoria
function sumatoria(numero){
    let resultado = 0;
    for (let i = 0; i <= numero; i++){
        resultado += i;
    }
    return(resultado);
}
console.log(sumatoria(3));

*/

/*
// Nuevo arreglo
function nuevoArreglo(numero){
    let arr = [];
    for (let i = 0; i < numero; i++){
        arr.push(i + 1);
    }
    return arr;
}

console.log(nuevoArreglo(5));

*/



//split

function split(str){
    let arr = [];
    for (let i = 0; i < str.length; i++){
        arr[i] = str.slice(i, i + 1);
    }
    return arr;
}
console.log(split("que pasa cuando escribo mucho"));



/*

// Manejando dos arreglos

function arrayHandler(arr1, arr2){
    for (let i = 0; i < arr1.length; i++){
        console.log("Soy " + arr1[i] + " yo soy " + arr2[i]);
    }
}

arrayHandler([1,2,3,4], ["h","o","l","a"]);

*/

//Palindromo 
function palindromo(str){
    let arr = split(str);
    let revArr = arr.reverse();
    let half = Math.floor(str.length / 2);
    for (let i = 0; i < half ; i++){
        if (arr[i] != revArr[i]){
            return false;
        }
    }
    return true;
}

console.log(palindromo("ana"));
console.log(palindromo("anilina"));
console.log(palindromo("enrique"));