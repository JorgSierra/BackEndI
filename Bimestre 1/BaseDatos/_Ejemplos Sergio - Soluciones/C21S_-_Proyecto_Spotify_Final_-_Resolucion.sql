-- ================================ --
-- Responder las siguientes preguntas:
-- ================================ --

-- 1. ¿Cuál es la diferencia entre LEFT y RIGHT JOIN?
-- Left trae los registro de la primera tabla y agrega los registros que no cumplen con la condición del ON. Right hace lo mismo pero con la segunda tabla.

-- 2. ¿Cuál es el orden en el que se procesan las queries SELECT, FROM, WHERE, GROUP BY, HAVING y ORDER BY?
-- FROM, WHERE, GROUP BY, HAVING, SELECT, ORDER BY.

-- 3. ¿Qué función podríamos utilizar si quisiéramos traer el promedio de likes de todas las canciones?
-- AVG.

-- 4. Si tenemos una query que trae un listado ordenado por el ID de usuarios la cual cuenta con un LIMIT 20 OFFSET 27, ¿cuál sería el primer ID de los registros 
-- y cuál sería el último?
-- El primero es el 28 y el último 47.

-- 5. ¿Por qué no se recomienda utilizar en exceso DISTINCT, ORDER BY y GROUP BY?
-- Porque consumen muchos recursos.

-- ================================ --
-- Realizar los siguientes informes:
-- ================================ --
SET sql_mode = 'ONLY_FULL_GROUP_BY';
-- Base de datos: Spotify

-- 1. Mostrar la cantidad de canciones que pertenecen a ambos géneros pop y rock cuyo nombre contiene la letra “m”.
SELECT g.Genero AS nombreGenero, COUNT(c.idCancion) AS cantidad FROM cancion c
INNER JOIN generoxcancion gc ON c.idCancion = gc.idCancion 
INNER JOIN genero g ON g.idGenero = gc.idGenero
WHERE g.idGenero IN(9,11) AND c.titulo LIKE "%m%"
GROUP BY g.idGenero;

-- 2. Listar todas las canciones que pertenezcan a más de una playlist. Incluir en el listado el nombre de la canción,
--    el código y a cuántas playlists pertenecen.
SELECT c.titulo AS nombreCancion, c.idCancion AS codigo, COUNT(pc.IdPlaylist) AS cantidadDePlaylist FROM cancion c 
INNER JOIN playlistxcancion pc ON pc.Idcancion = c.idCancion
GROUP BY c.titulo, c.idCancion
HAVING cantidadDePlaylist > 1;

-- 3. Generar un reporte con el nombre del artista y el nombre de la canción que no pertenecen a ninguna lista, ordenados alfabéticamente por el nombre del artista.
SELECT ar.nombre As nombreArtista, c.titulo AS nombreCancion FROM cancion c 
LEFT JOIN playlistxcancion pxc ON c.Idcancion = pxc.Idcancion
LEFT JOIN album a ON c.IdAlbum = a.idAlbum
LEFT JOIN artista ar ON ar.idArtista = a.idArtista
WHERE pxc.Idcancion IS NULL
ORDER BY ar.nombre;

-- 4. Modificar el país de todos los usuarios con el código postal “7600” a “Argentina”.
CREATE VIEW vUsuariosDeAgentina AS
SELECT * FROM usuario u
INNER JOIN pais p ON p.idPais = u.Pais_idPais
WHERE p.Pais = "Argentina";
UPDATE vUsuariosDeAgentina SET CP = 7600;
SELECT * FROM vUsuariosDeAgentina;

-- 5. Listar todos los álbumes que tengan alguna canción que posea más de un género.
SELECT a.titulo AS album, COUNT(pxc.idGeneroxCancion) AS cantidadDeGeneros FROM album a
INNER JOIN artista ar ON ar.idArtista = a.idArtista
INNER JOIN cancion c ON c.IdAlbum = a.IdAlbum
INNER JOIN generoxcancion pxc ON pxc.Idcancion = c.Idcancion
GROUP BY a.titulo
HAVING cantidadDeGeneros > 1;

-- 6. Crear un índice agrupado para las canciones cuyo identificador sea el ID.
CREATE INDEX idxIdTitulo ON cancion (idCancion, titulo);