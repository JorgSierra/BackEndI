let edades = [33, 27, 34, 30, 34, 25];


function bubbleSortMeMa(array){
    for(let i = 0; i < array.length; i++){
        for(let j = 0; i < j < array.length - 1; j++){
            if(array[j] > array[j+1]){
                let temporal = array[j];
                array[j] = array[j+1];
                array[j+1] = temporal;
            }
        }
    }
}

console.log(bubbleSortMeMa(edades));