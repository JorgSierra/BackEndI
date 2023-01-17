
function crearMatrizCuadradaRand (n){
    let matrix = [];
    let rand;
    for (let i = 0; i < n; i++) {
        matrix[i] = [];
        for (let j = 0; j < n; j++) {
            rand = Math.round(Math.random() * 100);
            matrix[i].push(rand);
        }
    }
    return matrix;
}


let mat = crearMatrizCuadradaRand(5);
console.table(mat);


function crearMatrizCuadradaOrdenada (n){
    let matrix = [];
    let rand = 1;
    for (let i = 0; i < n; i++) {
        matrix[i] = [];
        for (let j = 0; j < n; j++) {
            matrix[i].push(rand);
            rand++;
        }
    }
    return matrix;
}


mat = crearMatrizCuadradaOrdenada(10);
console.table(mat);



function sumaRojo (matrix){
    let suma = 0;
    for (let i = 0; i < matrix[0].length; i++) {
        suma += matrix[i][i];
    }
    return suma;
}

let suma = sumaRojo(mat);
console.log(suma);

function sumaVerde (matrix){
    let suma = 0;
    let tam = matrix[0].length;
    for (let i = 0; i < tam; i++) {
        suma += matrix[(tam - 1 - i)][i];
    }
    return suma;
}


suma = sumaVerde(mat);
console.log(suma); 