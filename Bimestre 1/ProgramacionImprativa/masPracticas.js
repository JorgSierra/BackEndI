// PUNTO 1
console.log("---------------------------");
console.log("--------- PUNTO 1 ---------");
console.log("---------------------------");
const edades = [11, 12, 15, 18, 25, 22, 10, 33, 18, 5];
// a. Obtener en un nuevo array las edades menores a 18.
// b. Obtener en un nuevo array las edades mayor o igual a 18.
// c. Obtener en un nuevo array las edades igual a 18.
// d. Obtener el menor.
// e. Obtener el mayor. 
// f. Obtener el promedio de edades.
// g. Incrementar en 1 todas las edades.
function dataEdades (arr, menores, mayores, apenas){
    let menor = Math.min(...arr);
    let mayor  = Math.max(...arr);
    let sum = 0;
    for (let i = 0; i < arr.length; i++){
        sum += arr[i];
        if (arr[i] < 18){
            menores.push(arr[i]);
        }
        else if (arr[i] > 18){
            mayores.push(arr[i]);
        }
        else{
            apenas.push(arr[i]);
        }
    }
    prom = sum / arr.length;
    return [menor, mayor, prom];
}

// Test
let menores18 = [];
let mayores18 = [];
let sonDe18 = [];
let values = dataEdades (edades, menores18, mayores18, sonDe18);
console.log("Menores 18: ", menores18);
console.log("Mayores 18: ", mayores18);
console.log("18: ", sonDe18);
console.log("Edad minima: ", values[0]);
console.log("Edad maxima: ", values[1]);
console.log("Promedio: ", values[2]);



// PUNTO 2
console.log("\n\n---------------------------");
console.log("--------- PUNTO 2 ---------");
console.log("---------------------------");
// Tenemos como base un array de cuentas bancarias
const arrayCuentas =
[
    {
      titular: "Arlene Barr",
      estaHabilitada: false,
      saldo: "$3,253.40",
      edadTitular: 33,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Roslyn Torres",
      estaHabilitada: false,
      saldo: "$3,229.45",
      edadTitular: 27,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Cleo Lopez",
      estaHabilitada: true,
      saldo: "$1,360.19",
      edadTitular: 34,
      tipoCuenta: "corriente"
    },
    {
      titular: "Daniel Malone",
      estaHabilitada: false,
      saldo: "$3,627.12",
      edadTitular: 30,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Ethel Leon",
      estaHabilitada: true,
      saldo: "$1,616.52",
      edadTitular: 34,
      tipoCuenta: "sueldo"
    },
    {
      titular: "Harding Mitchell",
      estaHabilitada: true,
      saldo: "$1,408.68",
      edadTitular: 25,
      tipoCuenta: "corriente"
    }
]

// a. Obtener un nuevo array de cuentas cuyas edades sean menores a 30.
function cuentasMenoresDe30(arr){
    let nArr = [];
    let aux = {};
    for(let i = 0; i < arr.length; i++){
        if (arr[i].edadTitular < 30)
        {
            aux = arr[i];
            nArr.push(aux);
        }
    }
    return nArr;
}
//Test
console.log("** Cuentas menores de 30: \n");
let menores30 = cuentasMenoresDe30(arrayCuentas);
console.log(menores30);



// b. Obtener un nuevo array de cuentas cuyas edades sean mayor o igual a 30.
function cuentasMayoresDe30(arr){
    let nArr = [];
    let aux = {};
    for(let i = 0; i < arr.length; i++){
        if (arr[i].edadTitular >= 30)
        {
            aux = arr[i];
            nArr.push(aux);
        }
    }
    return nArr;
}

//Test
console.log("** Cuentas mayores o de 30: \n");
let mayores30 = cuentasMayoresDe30(arrayCuentas);
console.log(mayores30);



// c. Obtener un nuevo array de cuentas cuyas edades sean igual a 30.
function cuentasIguales30(arr){
    let nArr = [];
    let aux = {};
    for(let i = 0; i < arr.length; i++){
        if (arr[i].edadTitular == 30)
        {
            aux = arr[i];
            nArr.push(aux);
        }
    }
    return nArr;
}

//Test
console.log("** Cuentas iguales a 30: \n");
let igual30 = cuentasIguales30(arrayCuentas);
console.log(igual30);


// d. Obtener la cuenta con el titular de la misma más joven.
function titularMasJoven(arr){
    let aux = {};
    for (let i = 0; i < arr.length; i++){
        if (i == 0){
            aux = arr[i];
        }
        else if (aux.edadTitular > arr[i].edadTitular){
            aux = arr[i];
        }     
    }
    return aux;
}
//Test
console.log("** Titular mas joven: \n");
let joven = titularMasJoven(arrayCuentas);
console.log(joven);


// e. Obtener un nuevo array por cada tipo de cuenta.
function groupTipoCuenta(arr){
    let sueldoArr = [];
    let corrArr = [];
    let solt = [];
    for(let i = 0; i < arr.length; i++){
        if (arr[i].tipoCuenta == "sueldo")
        {
            sueldoArr.push(arr[i]);
        }
        else if (arr[i].tipoCuenta == "corriente"){
            corrArr.push(arr[i]);
        }
    }
    solt[0] = sueldoArr;
    solt[1] = corrArr;
    return solt;
}

//Test
console.log("** Gupos por tipo de cuenta: \n");
let groupDeCuentas = groupTipoCuenta(arrayCuentas);
console.log(groupDeCuentas);


// f. Obtener un nuevo array con las cuentas habilitadas.
// g. Obtener un nuevo array con las cuentas deshabilitadas.
// h. Obtener la cuenta con el menor saldo.
// i. Obtener la cuenta con el mayor saldo.
















