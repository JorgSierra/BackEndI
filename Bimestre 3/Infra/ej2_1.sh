#!/bin/bash
cantMele=$(cat personajes_lol | grep "N" | awk '{print$2}' | sed 's_/_and_g' | grep -w M | wc -l)
cantRanged=$(cat personajes_lol | grep "N" | awk '{print$2}' | sed 's_/_and_g' | grep -w R | wc -l)
cantRandM=$(cat personajes_lol | grep "N" | awk '{print$2}' | sed 's_/_and_g' | grep -w RandM | wc -l)

#Se hace la conversion (sed) de / a "and" porque al buscar con grep R trae tanto los R como los R/M

echo " --- --- --- --- --- --- Resultados --- --- --- --- --- --- "
echo "Personajes de mele que empiezan por N: $cantMele"
echo "Personajes de range que empiezan por N: $cantRanged"
echo "Personajes de range y mele que empiezan por N: $cantRandM"
