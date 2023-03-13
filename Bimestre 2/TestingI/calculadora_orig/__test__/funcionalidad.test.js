const {init, limpiar, resetear, resolver} = require("../funcionalidad");
const fs = require("fs");
document.body.innerHTML = fs.readFileSync("./calculadora.html");

test("suma", () =>{
    limpiar();
    resetear();
    init();
    uno.onclick();
    suma.onclick();
    tres.onclick();
    igual.onclick();
    expect(resultado.textContent).toBe("4");
})