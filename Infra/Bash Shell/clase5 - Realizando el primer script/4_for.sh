#!/bin/bash

#Maneras de usar el comando for
<< 'MULTILINE-COMMENT'
for <instruccion>; do
    //Bloque de instrucciones
done
MULTILINE-COMMENT

#Tradicionalmente
for ((i=1;i<=10;i++)); do
    echo "El valor de i es: $i"
done

#Para leer archivos
for nombre in $(ls); do
    echo "EL archivo se llama: $nombre"
done