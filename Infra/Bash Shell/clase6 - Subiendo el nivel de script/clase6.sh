#!/bin/bash

req=$(curl -s https://raw.githubusercontent.com/olea/lemarios/master/nombres-propios-es.txt | shuf)

countA=0
countL=1

ahorrador(){
    curl -s https://api.genderize.io/?name=$nombre | jq '.gender' | { read genero; echo "Gender of $nombre is: $genero"; } 
    curl -s https://api.nationalize.io/?name=$nombre | jq '.country[0].country_id' | { read -r country; echo "Country of $nombre is: $country"; }
    echo "----------------------------------"
}

for nombre in $req; do
    if [[ $nombre = A* ]] && [[ $countA -le 4 ]]; then    
        echo $nombre
        ahorrador
        let "countA++"
    fi
    if [[ $nombre = L* ]] && [[ $countL -le 5 ]]; then    
        echo $nombre
        ahorrador
        let "countL++"
    fi
done
