#!/bin/bash

#Maneras de usar while
<< 'MULTILINE-COMMENT'
while [[ condición ]]; do
    //Bloque de instrucciones
done
MULTILINE-COMMENT

#Tradicionalmente
n=0
while [[ $n -le 10 ]]; do
    echo "El valor del contador es: $n"
    let "n++" # ++n // n=n+1 // n+1 
done

#Para leer archivos
while read -r i; do
   echo "$i" ;
done < Actores_señor_de_los_anillos