#!/bin/bash

mele=$(cat personajes.csv | awk -F"," '{print$2}' | sed 's_/_and_g' | grep -w M | wc -l)
range=$(cat personajes.csv | awk -F"," '{print$2}' | sed 's_/_and_g' | grep -w R | wc -l)
rangeAndMele=$(cat personajes.csv | awk -F"," '{print$2}' | sed 's_/_and_g' | grep -w RandM | wc -l)

echo "Total personajes de mele: $mele"
echo "Total presonajes de range: $range"
echo "Total personajes de range y mele: $rangeAndMele"

#La suma de los totales no es la misma que la cantidad de nombres en el archivo (falta 1) ya que en la columna 2
#del nombre Twisted Fate (linea 105) se encuentra la palabra Fate
