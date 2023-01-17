// Ejercicio 1
// En un concurso de fotografía, donde los usuarios publican una fotografía y obtienen
// likes, se registra la cantidad de likes obtenidos por cada usuario en un array. Ordenar
// los valores para poder indicar cuál fue la mayor cantidad de likes obtenidos, cuánto
// obtuvo el segundo, cuánto el tercero y cuánto el que menos likes obtuvo —suponer
// que participaron 15 usuarios y suponer para cada uno, una cantidad de likes—.
let array = [
    {
        nombre : "Juan1",
        likes: 15
    },
    {
        nombre : "Juan2",
        likes: 14
    },
    {
        nombre : "Juan3",
        likes: 13
    },
    {
        nombre : "Juan4",
        likes: 80
    },
    {
        nombre : "Juan5",
        likes: 26
    },
    {
        nombre : "Juan6",
        likes: 800
    },
    {
        nombre : "Jua",
        likes: 100
    },
    {
        nombre : "Juan7",
        likes: 900
    },
    {
        nombre : "Juan8",
        likes: 254
    },
    {
        nombre : "Juan9",
        likes: 385
    },
    {
        nombre : "Juan10",
        likes: 15
    },
    {
        nombre : "Juan11",
        likes: 178
    },
    {
        nombre : "Juan12",
        likes: 555
    },
    {
        nombre : "Jua151",
        likes: 8545
    },
    {
        nombre : "Juan54654",
        likes: 15672
    }
]

function Ordenar (array){
    let aux;
    for (let i = 0; i < array.length; i++){
        for (let j = 0; j < array.length - 1; j++){
            if(array[j].likes < array[j + 1].likes){
                aux = array[j];
                array[j] = array[j + 1];
                array[j + 1] = aux;
            }
        }
    }
}

console.table(array);
Ordenar(array);
console.table(array);


function ganadores (array){
    console.log("Primeros puestos")
    for (let i = 0; i < 3; i++){
        console.log((i + 1) + ". " + array[i].nombre + " " + array[i].likes)
    }
    console.log("\nMenor likes")
    console.log(array[array.length -1]);
}

ganadores(array);

// Ejercicio 2
// El servicio meteorológico, para llevar el control diario de temperatura, utiliza un
// objeto temperatura donde registra día —valor numérico del día—, mes —valor
// numérico—, temperatura máxima y temperatura mínima, correspondiente a dicho
// día. Las temperaturas —objeto temperatura— están cargados en un array.
// a) Ordenar por temperatura mínima de menor a mayor.
// b) Ordenar por temperatura máxima de mayor a menor.