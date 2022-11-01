// Clase 11
// Mesa:
// 1- Normalizar el campo teléfono
// 2- Capturar los datos del formulario y guardarlos en el objeto 'registerUser'

const registerUser = {
    name: '',
    password: '',
    telephone: 123,
    hobbies: ['', ''],
    nationality: ''
};

const nameInput = document.querySelector('#nombre');
nameInput.addEventListener('keyup', (e) => {
    console.log(e.key);
    nameInput.value = getNormalizedName(nameInput.value);

    function getNormalizedName(name) {
        name = setUpperCaseOnlyToTheFirstLetter(name);
        name = removeNumbersFromText(name);
        return setUpperCaseAfterEachSeparation(name);
    }

    function setUpperCaseOnlyToTheFirstLetter(text) {
        return text[0].toUpperCase() + text.slice(1).toLowerCase();
    }

    function removeNumbersFromText(text) {
        const lastChar = parseInt(text[text.length - 1]);

        if (isNaN(lastChar) == false) {
            // si estamos acá, 'lastChart' es número
            return text.replace(lastChar, '');
        }

        return text;
    }

    function setUpperCaseAfterEachSeparation(text) {
        let nextIsUpperCase = true;
        let newText = '';
        for (let i = 0; i < text.length; i++) {
            if (nextIsUpperCase) {
                newText += text[i].toUpperCase();
            } else {
                newText += text[i].toLowerCase();
            }

            nextIsUpperCase = text[i] == ' ';
        }

        return newText;
    }
});

// Agregamos un punto final al salir del input nombre
nameInput.addEventListener('blur', (e) => {
    nameInput.value = nameInput.value.concat('.');
});



// Mesa 11 - Normalizamos el teléfono y obtenemos la info guardada
const nameTelephone = document.querySelector('#tel');
nameTelephone.addEventListener('keyup', (e) => {
    nameTelephone.value = getNormalizedTelephone(nameTelephone.value);
    console.log(nameTelephone.value);

    function getNormalizedTelephone(telephone) {
        return removeNotNumbersFromText(removeEmptySpaces(telephone));
    }

    function removeNotNumbersFromText(text) {
        const lastChar = text[text.length - 1];

        if (isNaN(lastChar)) {
            // si estamos acá, 'lastChart' es número
            return text.replace(lastChar, '');
        }

        return text;
    }

    function removeEmptySpaces(text) {
        return text.trim();
    }
});

function validateInfo(e) {
    e.preventDefault();

    if (isNameValid() && isTelephoneValid() && isNationalityValid()) {
        registerUser.name = getName();
        registerUser.password = getPassword();
        registerUser.telephone = getTelephone();
        registerUser.nationality = getNationality();
        registerUser.hobbies = getHobbies();

        console.log(registerUser);
    }

    function isNameValid() {
        return getName().length >= 4;
    }

    function isTelephoneValid() {
        return getTelephone().length >= 7;
    }

    function isNationalityValid() {
        return document.querySelector('input[type=radio][name=nacionalidad]:checked') != null;
    }

    function getName() {
        return document.querySelector('#nombre').value;
    }

    function getPassword() {
        return document.querySelector('#pass').value;
    }

    function getTelephone() {
        return document.querySelector('#tel').value;
    }

    function getNationality() {
        return document.querySelector('input[type=radio][name=nacionalidad]:checked').value;
    }

    function getHobbies() {
        let hobbies = [];
        const checks = document.getElementsByName('hobbies');
        checks.forEach(element => {
            if (element.checked) {
                hobbies.push(element.value);
            }
        });

        // for (let i = 0; i < checks.length; i++) {
        //     // element== checks[i]
        //     if (checks[i].checked) {
        //         hobbies.push(element.value);
        //     }
        // }

        return hobbies;
    }
}

// Clase 12 - validamos todo
window.addEventListener('submit', validateInfoAndShowMessage);

// Clase 13 - mostramos mensajes por pantalla y resaltamos los componentes
function validateInfoAndShowMessage(e) {
    e.preventDefault();
    const errors = [];

    if (!isNameValid()) {
        errors.push('El nombre es inválido');
    }

    if (!isTelephoneValid()) {
        errors.push('El teléfono es inválido');
    }

    if (!isNationalityValid()) {
        errors.push('La nacionalidad es inválida');
    }

    if (errors.length > 0) {
        showErrorMessages(errors);
    } else {
        location.href = `Home.html?name=${getName()}`;
    }

    function showErrorMessages(errors) {
        const container = document.querySelector('.errors');
        let list = '';

        errors.forEach(error => {
            list += `<li>${error}</li>`;
        });

        container.innerHTML += `<ul>${list}</ul>`;
    }

    function isNameValid() {
        return getName().length >= 4;
    }

    function isTelephoneValid() {
        return getTelephone().length >= 7;
    }

    function isNationalityValid() {
        return document.querySelector('input[type=radio][name=nacionalidad]:checked') != null;
    }

    function getName() {
        return document.querySelector('#nombre').value;
    }

    function getPassword() {
        return document.querySelector('#pass').value;
    }

    function getTelephone() {
        return document.querySelector('#tel').value;
    }

    function getNationality() {
        return document.querySelector('input[type=radio][name=nacionalidad]:checked').value;
    }

    function getHobbies() {
        let hobbies = [];
        const checks = document.getElementsByName('hobbies');
        checks.forEach(element => {
            if (element.checked) {
                hobbies.push(element.value);
            }
        });

        // for (let i = 0; i < checks.length; i++) {
        //     // element== checks[i]
        //     if (checks[i].checked) {
        //         hobbies.push(element.value);
        //     }
        // }

        return hobbies;
    }
}