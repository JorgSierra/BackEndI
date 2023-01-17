import React, { useState } from 'react'

const Counter = () => {
  const [ counter, setCounter ] = useState(1);
  const [ nombre, setNombre ] = useState(0);

  const suma = () => {
    const cuenta = counter + nombre; 
    if (validar(cuenta)){
        setCounter(cuenta);
    }
  }
  const resta = () => {
    const cuenta = counter - nombre; 
    if (validar(cuenta)){
        setCounter(cuenta);
    }
  }
  const multiplicar = () => {
    const cuenta = counter * nombre; 
    if (validar(cuenta)){
        setCounter(cuenta);
    }
  }
  const dividir = () => {
    const cuenta = counter / nombre; 
    if (validar(cuenta)){
        setCounter(cuenta);
    }
  }

  const validar = (valor) =>{
    if(valor < 1 || valor > 50){
        return false;
    }
    return true;
  }

  return (
    <div>
        <h1>Counter es: {counter}</h1>
        <h1>El valor a operar es: {nombre}</h1>
        <label>
            Inserte su numero:
        <input type="text" name="name" onChange={event => setNombre(parseInt(event.target.value))}/>
        </label>
        <button onClick={suma}>Suma</button>
        <button onClick={resta}>resta</button>
        <button onClick={multiplicar}>multiplicar</button>
        <button onClick={dividir}>dividir</button>
    </div>
  )
}

export default Counter
