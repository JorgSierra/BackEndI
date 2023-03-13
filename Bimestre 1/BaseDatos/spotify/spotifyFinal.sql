-- Responder las siguientes preguntas:
-- 1. ¿Cuál es la diferencia entre LEFT y RIGHT JOIN?
-- Left toma en cuenta todos los datos de la tabla a la izquierda sin importar que no tenga
-- relación a la tabla de la derecha y viceversa.

-- 2. ¿Cuál es el orden en el que se procesan las queries SELECT, FROM, WHERE,
-- GROUP BY, HAVING y ORDER BY?
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- SELECT
-- ORDER BY

-- 3. ¿Qué función podríamos utilizar si quisiéramos traer el promedio de likes de
-- todas las canciones?
-- AVG()

-- 4. Si tenemos una query que trae un listado ordenado por el ID de usuarios la cual
-- cuenta con un LIMIT 20 OFFSET 27, ¿cuál sería el primer ID de los registros y cuál
-- el último?
-- Primer registro: 28
-- Ultimo registro: 48


-- 5. ¿Por qué no se recomienda utilizar en exceso DISTINCT, ORDER BY y GROUP BY?
-- Por performance y buenas practicas


-- Realizar los siguientes informes
-- 1. Mostrar la cantidad de canciones que pertenecen a ambos géneros pop y rock
-- cuyo nombre contiene la letra “m”.
select count(*) CantidadCanciones
from cancion c
join generoxcancion gc on gc.IdCancion = c.IdCancion
join genero g on g.idGenero = gc.IdGenero
where (g.Genero = "Pop" 
or g.Genero = "Rock")
and c.titulo like "%m%";

select c.titulo, gc.idCancion, g.Genero
from cancion c
join generoxcancion gc on gc.IdCancion = c.IdCancion
join genero g on g.idGenero = gc.IdGenero
where (g.Genero = "Pop" 
or g.Genero = "Rock")
and c.titulo like "%m%";


-- 2. Listar todas las canciones que pertenezcan a más de una playlist. Incluir en el
-- listado el nombre de la canción, el código y a cuántas playlists pertenecen.
select p.Idcancion, c.titulo, count(p.idPlaylistxCancion) Cantidad 
from playlistxcancion p
join cancion c on c.idCancion = p.idCancion
group by p.Idcancion
having Cantidad > 1;


-- 3. Generar un reporte con el nombre del artista y el nombre de la canción que no
-- pertenecen a ninguna lista, ordenados alfabéticamente por el nombre del
-- artista.
select a.Nombre Artista, c.titulo Cancion
from artista a
join album al on al.idArtista = a.idArtista
join cancion c on c.idAlbum = al.idAlbum
left join playlistxcancion pl on pl.Idcancion = c.idCancion
where pl.IdPlaylist is null;

-- 4. Modificar el país de todos los usuarios con el código postal “7600” a “Argentina”.
select *
from usuario
where CP = 7600; -- No hay??

-- 5. Listar todos los álbumes que tengan alguna canción que posea más de un
-- género.
-- 6. Crear un índice agrupado para las canciones cuyo identificador sea el ID.