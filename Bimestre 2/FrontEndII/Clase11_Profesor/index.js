const registerUser = {
    name: '',
    password: '',
    telephone: 0,
    hobbies: [],
    nationality: ''
};


const inputName = document.querySelector('#nombre');
inputName.addEventListener('keyup', (e) => {
    // console.log(inputName.value);
    inputName.value = getNormalizedName(inputName.value);
});

function getNormalizedName(name) {
    name = removeNumbersFromText(name);
    name = setUpperCaseOnlyToTheFirstLetter(name);
    return name;
}

// function getNormalizedName(name) {
//     return setUpperCaseOnlyToTheFirstLetter(removeNumbersFromText(name));
// }

function setUpperCaseOnlyToTheFirstLetter(text) {
    // text = 'hola, ¿cómo estás?'
    if (text == '') {
        return '';
    }
    return text[0].toUpperCase() + text.slice(1).toLowerCase();
}

function removeNumbersFromText(text) {
    // text ='ho1la'

    const lastChar = parseInt(text[text.length - 1]);

    if (isNaN(lastChar) == false) {
        // si estamos acá, 'lastChart' es número
        return text.replace(lastChar, '');
    }

    return text;
}

// Mesa:
// 1- normalizar el campo teléfono
// 2- capturar los datos del formulario y guardarlos en el objeto 'registerUser'