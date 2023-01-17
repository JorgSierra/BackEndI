#!/bin/bash

#Convierte todos los espacios consecutivos en comas
#Se encuentra un problem con el personaje Twisted Fate (linea 105) ya que tiene un espacio en su nombre

cat personajes_lol | sed 's/\s/,/g' > personajes.csv
