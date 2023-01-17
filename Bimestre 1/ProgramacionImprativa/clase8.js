// PUNTO 1
/*
function diezSiguientes(num){
    for (let i = num + 1 ; i <= num + 10; i++){
        console.log(i);
    }
}

diezSiguientes(10);
*/

// PUNTO 2 
/*
for (let i = 5; i <= 20; i += 3){
    console.log(i);
}

let i = 5;
while(i <= 20){
    console.log(i);
    i += 3;
}
*/

// PUNTO 3
/*
let total = 0;
for (let i = 0; i <= 100; i++){
    total += i;
}
console.log(total);
*/

// PUNTO 4
/*
function factorial(num){
    let total = 1;
    for (let i = 1; i <= num ; i++){
        total *= i;
    }
    return total;
}

console.log(factorial(10));
*/

/*
function fibonacci(num){
    let n1 = 0, n2 = 1, proximo = n1 + n2;
    console.log(n1);
    console.log(n2);

    while (proximo <= num){
        proximo = n1 + n2;
        console.log(proximo);
        n1 = n2;
        n2 = proximo;
        
    }
    
}
fibonacci(55);
*/


// PUNTO 5
/*
function fibonacci(num){
    let n1 = 0, n2 = 1;
    let proximo = n1 + n2;
    console.log(n1);
    console.log(n2);

    while (proximo <= num){
        console.log(proximo);
        n1 = n2;
        n2 = proximo;
        proximo = n1 + n2;
    }
    
}
fibonacci(55);
*/