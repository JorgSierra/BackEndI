#!/bin/bash

chequeoActivo=$(systemctl status apache2 | grep running | wc -l)

if [[ $chequeoActivo -ge 1 ]]; then
    echo "Todo esta funcionando perfectamente"
else
	echo "----------------------------->"
    echo "Apache2 status: Inactivo"
	echo "Iniciando apache2"
    sudo systemctl start apache2
	echo "Apache2 iniciado"
fi
