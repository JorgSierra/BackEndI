const {inputsAreEmpty, inputsNoSonNumeros, updateLabel, getNumber1, getNumber2} = require("../get-started.js");

test("Testeando que sean numeros", () =>{
    let numero = inputsNoSonNumeros("a");
    expect(numero).toBeTruthy;
});