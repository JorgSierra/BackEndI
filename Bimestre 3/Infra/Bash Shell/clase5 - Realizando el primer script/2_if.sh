#Maneras de usar el comando if
<< 'MULTILINE-COMMENT'
if [[ <expresión> ]]; then
    comandos
else
    comandos
fi
MULTILINE-COMMENT

n1=34
n2=34

if [[ $n1 -eq $n2 ]]; then 
    echo "Tienen el mismo valor"
else
    echo "Tienen un valor diferente"
fi

#Comparando archivos y carpetas

if [[ -f $HOME/Documents/Bash/Actores_señor_de_los_anillos ]]; then
    echo "Si existe ese archivo"
else
    echo "No existe ese archivo"
fi

if [[ -d $HOME/Documents/Bash ]]; then
    echo "Si existe esa carpeta"
else
    echo "No existe esa carpeta"
fi
