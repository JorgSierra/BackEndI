#!/bin/bash

echo "7 ultimos elementos despues de shuffle"
echo "$(cat personajes_lol | shuf | tail -n 7)"
echo ""
echo "7 primeros elementos despues de shuffle"
echo "$(cat personajes_lol | shuf | head -n 7)"
