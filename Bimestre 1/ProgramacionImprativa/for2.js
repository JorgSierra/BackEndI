function noParesDeContarImparesHasta(numero){
    // Escribe aqui tu código
    let count = 0;
    for(let i = 1; i <= numero; i++)
    {
        if (i%2 != 0)
        {
            count++;
        }
    }
    return count;
}

// console.log(noParesDeContarImparesHasta(5));

function tablaDeMultiplicar(numero) {
    //Escribí tu código aquí   
   let i = 1;
   while(i <= 10)
   {
       console.log(numero + " * " + i + " = " + i * numero);
       i++;
   }
}
tablaDeMultiplicar(5)


let arreglo = [1, 2, 3, 4, 5]

function suma(arreglo) {
    let sumatoria = 0
    for (let i = 0; i < arreglo.length; i++){
        sumatoria += arreglo[i]
    }
    return sumatoria
}

let rdo3 = suma(arreglo)
console.log(rdo3)

// Deberás escribir un objeto literal llamado empresa que contenga las siguientes propiedades que deberás completar con tus datos:
// nombre string
// actividad string
// sueldos array de 10 números


let empresa = {
    nombre: "digital house",
    actividad: "educacion",
    sueldos: [1000, 2000, 3000, 4000, 5000, 6000, 7000, 80000,9000, 10000],
    totalPaga: function(){
        let sumatoria = 0;
        for(let i = 0; i < this.sueldos.length; i++){
            sumatoria += this.sueldos[i];
        }
        if (sumatoria > 200000){
            return "La empresa " + this.nombre + " se encuentra en quiebra ya que su pago de sueldos es de " + sumatoria + " por lo tanto, necesita hacer un ajuste en sus empleados";
        }
        else{
            return "La empresa " + this.nombre + " esta bien economicamente, ya que su pago de sueldos es de " + sumatoria + " por lo tanto, NO necesita hacer un ajuste en sus empleados";
        }
    }
}

// 2. Teniendo en cuenta los datos del punto número 1:
// Crear un método del objeto que calcule los sueldos que paga la empresa y si supera los 200.000 retornará:  ‘La empresa [nombre] se encuentra en quiebra ya que su pago de sueldos es de  [sueldos] por lo tanto, necesita hacer un ajuste en sus empleados’ , y si no retornará: ‘La empresa [nombre] esta bien economicamente, ya que su pago de sueldos es de [sueldos] por lo tanto, NO necesita hacer un ajuste en sus empleados’

let string = empresa.totalPaga();
console.log(string);



let historiasInconscientes = {
    anio  : 2013,
    autor : "Gabriel Rolón",
    paginas: 352
 }
 let elAlquimista = {
     anio  : 1988,
    autor : "Paulo Coehlo",
    paginas: 192
 }
 let elCampamento = {
    anio  : 2021,
    autor : "Blue Jeans",
    paginas: 480
 }
 let operacionMasacre = {
    anio: 2009,
    autor: "Rodolfo Walsh",
    paginas: 236
 }

let arr = [historiasInconscientes, elAlquimista, elCampamento, operacionMasacre];


console.log(arr);