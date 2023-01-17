#!/bin/bash

#Maneras de usar el comando case
<< 'MULTILINE-COMMENT'
case <expresión> in
    <patrón 1>)
        comandos
        ;;
    <patrón 2>)
        comandos
        ;;
    *)
        comandos
        ;;
esac
MULTILINE-COMMENT

case $1 in
    amarillo)
        echo "optimismo, claridad, calor"
        ;;
    naranja)
        echo "amigable, social, seguridad"
        ;;
    rojo)
        echo "atrevido, excitación, joven"
        ;;
    violeta)
        echo "creatividad, imaginativo, sabio"
        ;;
    azul)
        echo "útil, fuerza, fiel"
        ;;
    verde)
        echo "paz, salud, crecimiento"
        ;;
    blanco)
        echo "equilibrio, tranquilidad, neutro"
        ;;
    *)
        echo "Lo siento, no conozco ese color"
        ;;
esac
