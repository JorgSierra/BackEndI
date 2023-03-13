const { generateText, validateInput, createElement } = require('../util.js');

describe('Pruebas de salida de datos', () => {
    test('Salida con datos', () =>{
        const text = generateText('Daniel',30);
        expect(text).toBe('Daniel (30 years old)');
    });
      
    test('Salida con datos vacios', () =>{
        const text = generateText('',null);
        expect(text).toBe(' (null years old)');    
    });
    
    test('Salida sin datos', () =>{
        const text = generateText();
        expect(text).toBe('undefined (undefined years old)');    
    });
});

describe("Pruebas a la creacion del elemento", () => {
    test("Salida de elemento creado", () => {
        const testType = "li";
        const testContent = "Probando";
        const testClass = "laClass";

        const expectedClassList = {
            "0" : testClass
        };

        const element = createElement(testType, testContent, testClass);

        const tag = element.tagName.toLowerCase();
        const content = element.textContent;
        const classes = element.classList;

        expect(tag).toBe(testType);
        expect(content).toBe(testContent);
        expect(classes).toMatchObject(expectedClassList);
    });
});

describe("Pruebas de validador", () =>{
    test("Texto vacio booleanos falsos", () =>{
        const result = validateInput("",false,false);
        expect(result).toBeFalsy();
    });
    test("Texto existente con booleanos falsos", () =>{
        const result = validateInput("asdf",false,false);
        expect(result).toBeTruthy();
    });
    test("Texto espacio not empty true y num false", () =>{
        const result = validateInput(" ",true,false);
        expect(result).toBeFalsy();
    });
    test("Texto existente not empty true y num false", () =>{
        const result = validateInput("asdf",true,false);
        expect(result).toBeTruthy();
    });
    test("Texto existente not empty false y num true", () =>{
        const result = validateInput("&%",false,true);
        expect(result).toBeFalsy();
    });
});