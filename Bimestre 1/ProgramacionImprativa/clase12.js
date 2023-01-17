/*
const alicia = [10, 80, 75];
const bob = [90, 20, 25];

function encontrarGanador(a, b) {
    let puntos = [0, 0];
    let string = "";
    for(let i = 0; i < a.length; i++){
        if (a[i] > b[i]){
            puntos[0]++;
        }
        else if (a[i] < b[i]){
            puntos[1]++;
        }
    }
    if (puntos[0] > puntos[1]){
        string = "a"
    }
    else if (puntos[0] < puntos[1])
    {
        string = "b";
    }
    return string;
}

console.log("El ganador es: " + encontrarGanador(alicia,bob) + " participante");


*/

const alicia = [10, 80, 75];
const bob = [90, 20, 25];
 
let Concurso = {
    etapas: 0,
    ganador: "",
    encontrarGanador: function(a, b, nombreA, nombreB){
        let puntos = [0, 0];
        let string = "";
        for(let i = 0; i < a.length; i++){
            this.etapas++;
            if (a[i] > b[i]){
                puntos[0]++;
            }
            else if (a[i] < b[i]){
                puntos[1]++;
            }
        }
        if (puntos[0] > puntos[1]){
            string = nombreA;
        }
        else if (puntos[0] < puntos[1])
        {
            string = nombreB;
        }
        this.ganador = string;
    },
    exportarResultados : function(){
        let fs = require('fs');
        let obj = {
            etapas: this.etapas,
            ganador: this.ganador
        }

        let data = JSON.stringify(obj);
        fs.writeFile("concurso.json", data, (err) => {
            if (err){
                throw err;
            }
            console.log("El archivo ha sido creado");
        });
    } 
}

console.log(Concurso);
Concurso.encontrarGanador(alicia, bob, "Alicia", "Bob");
console.log(Concurso);
Concurso.exportarResultados();