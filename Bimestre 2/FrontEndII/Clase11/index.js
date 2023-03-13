const registerUser = {
    name: '',
    password: '',
    telephone: 0,
    hobbies: [],
    nationality: ''
};

const inputName = document.querySelector('#nombre');
inputName.addEventListener('keydown', (e) => {
    if(!isNaN(e.key)){
        e.preventDefault();
    }
});

const inputTel = document.querySelector('#tel');
inputTel.addEventListener('keydown', (e) => {
    if(isNaN(e.key)){
        e.preventDefault();
    }
});





// Mesa:
// 1- normalizar el campo teléfono
// 2- capturar los datos del formulario y guardarlos en el objeto 'registerUser'