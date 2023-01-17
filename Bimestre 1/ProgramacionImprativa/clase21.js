function piramide(num) {
    let str;
    for (let i = num; i > 0; i--) {
      str = "";
      for (let j = 0; j < i; j++) {
        str += i.toString();
      }
      console.log(str);
    }
  }
  piramide(7);


let fila1 = [4,9,2]
let fila2 = [3,5,7]
let fila3 = [8,1,6]
let matrix = [fila1, fila2, fila3];

console.table(matrix);

function sumaFilas(mat){
    let sumaFila;
    for (let i = 0; i < mat.length; i++){
        sumaFila = 0;
        for (let j = 0; j < mat[i].length; j++){
            sumaFila += mat[i][j];
        }
        console.log("Fila " + (i + 1) + " : " + sumaFila);
    }
}
sumaFilas(matrix);

function multCol(mat){
    let mult;
    let fil = mat.length;
    let col = mat[0].length;
    for (let i = 0; i < col; i++){
        mult = 1;
        for (let j = 0; j < fil; j++){
            mult *= mat[j][i];
        }
        if (mult % 2 == 0){
            console.log("Columna " + (i + 1) + " : " + mult);
        }
    }
}
multCol(matrix);

function sumaDiags(mat){
    let fil = mat.length;
    let sumDiag1 = 0;
    let sumDiag2 = 0;
    for (let i = 0; i < fil; i++){
        sumDiag1 += mat[i][i];
        sumDiag2 += mat[i][fil - i - 1];
    }
    console.log("Suma diagonal 1: " + sumDiag1);
    console.log("Suma diagonal 2: " + sumDiag2);
}
sumaDiags(matrix);