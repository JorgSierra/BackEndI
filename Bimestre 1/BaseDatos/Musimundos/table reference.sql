select canciones.id, canciones.nombre, compositor, generos.id, generos.nombre
from canciones, generos
where id_genero = generos.id
and compositor = "Willie Dixon"
and generos.nombre = "Blues"
limit 3460;

select * from generos;
select * from canciones;