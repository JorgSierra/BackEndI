window.addEventListener("load", (e) =>{
    const form = document.querySelector("form");
    const inputName = document.querySelector('#nombre');
    const inputTel = document.querySelector('#tel');
    const inputHobbies = document.getElementsByName("hobbies");
    
    inputName.addEventListener('keydown', preventNumberKeyInput);
    inputTel.addEventListener('keydown', preventAlphaKeyInput);
    inputHobbies.forEach(checkbox => {
        checkbox.addEventListener('click', checkboxHandler);
    });

    form.addEventListener("submit", (e) =>{
        e.preventDefault();
        let errores = [];
        if (!isTotalNameLengthValid(inputName.value)){
            errores.push("Se permite máximo 150 caracteres en el nombre.");
        }
        if (!hasAtLeastTwoWords(inputName.value)){
            errores.push("El campo de nombre completo debe tener por lo menos dos palabras.");
        }
        if (!areNamesLengthValid(inputName.value)){
            errores.push("Cada palabra del nombre debe tener más de un caracter.");
        }
        console.log(errores);
    });

    function preventNumberKeyInput(e){
        if(!isNaN(e.key)){
            e.preventDefault();
        }
    }

    function preventAlphaKeyInput(e){
        if(isNaN(e.key)){
            e.preventDefault();
        }
    }

    function isTotalNameLengthValid(toValidate){
        return toValidate.length <= 150;
    }
    
    function hasAtLeastTwoWords(toValidate){
        let array = toValidate.split(" ");
        return array.length >= 2;
    }
    
    function areNamesLengthValid(toValidate){
        let array = toValidate.split(" ");
        for (let i = 0; i < array.length; i++){
            if (array[i].length <= 1){
                return false;
            }        
        }
        return true;
    }

    function checkboxHandler(e){
        console.log(inputHobbies)
        console.log(e)
        let justClicked = e.srcElement.id;
        let count = 0;
        let limit = 4;
        
        inputHobbies.forEach(checkbox => {
            if (checkbox.checked){
                count++;
            }
        });
        if (count > limit){
            e.preventDefault();
        }
    }
});



// let GamingCook = false;
//         if (justClicked == "hobbiesVideoJuegos" || justClicked == "hobbiesCocina"){
//             GamingCook = true;
//         }
//         let GuitarReading = false;
//         if (justClicked == "hobbiesGuitarra" || justClicked == "Lectura"){
//             GuitarReading = true;
//         }
//         let NetflixWeave = false;
//         if (justClicked == "hobbiesNetflix" || justClicked == "hobbiesTejer"){
//             NetflixWeave = true;
//         }
//         let aux;


        

//         aux = checkbox.getAttribute("id");
//                 if ((aux == "hobbiesVideoJuegos" && justClicked == "hobbiesCocina") || (aux == "hobbiesCocina" && justClicked == "hobbiesVideoJuegos")){
//                     alert(1);
//                     e.preventDefault();
//                 }