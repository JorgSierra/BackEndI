-- Realizar los siguientes informes:
-- 1. Listar las canciones que poseen la letra “z” en su título.
select * from cancion
where titulo like "%z%";
-- 2. Listar las canciones que poseen como segundo carácter la letra “a” y como último, la letra “s”.
select * from cancion
where titulo like "_a%s";
-- 3. Mostrar la playlist que tiene más canciones, renombrando las columnas poniendo mayúsculas 
-- en la primera letra, los tildes correspondientes y agregar los espacios entre palabras.
select titulo as "Título" from playlist
order by cantcanciones
limit 1;
-- 4. En otro momento se obtuvo un listado con los 5 usuarios más jóvenes, 
-- obtener un listado de los 10 siguientes.
select nombreusuario, fecha_nac from usuario
order by fecha_nac desc
limit 10
offset 5;
-- 5. Listar las 5 canciones con más reproducciones, ordenadas descendentemente.
select titulo, cantreproduccion from cancion
order by cantreproduccion desc
limit 5;
-- 6. Generar un reporte de todos los álbumes ordenados alfabéticamente.
select * from album
order by titulo;
-- 7. Listar todos los álbumes que no tengan imagen, ordenados alfabéticamente.
select * from album
where imagenportada is null
order by titulo;
-- 8. Insertar un usuario nuevo con los siguientes datos (tener en cuenta las relaciones):
--   a) nombreusuario: nuevousuariodespotify@gmail.com
--   b) Nombre y apellido: Elmer Gomez
--   c) password: S4321m
--   d) Fecha de nacimiento: 15/11/1991
--   e) Sexo: Masculino
--   f) Código Postal: B4129ATF
--   g) País: Colombia
insert into usuario (nombreusuario, nyap, password, fecha_nac, sexo, CP, Pais_idPais, idUsuario)
values ("nuevousuariodespotify@gmail.com", "Elmer Gomez", "S4321m", '1991-11-15', "M", "B4129ATF", 2, 20);

-- 9. Eliminar todas las canciones de género “pop”.
-- Lista las relaciones existentes con genero 9
select * from generoxcancion
where IdGenero = 9;

delete from generoxcancion
where IdGenero = 9;

select * from generoxcancion;

select * from genero;

-- 10. Editar todos los artistas que no tengan una imagen cargada y cargarles el texto “Imagen faltante” 
-- en la columna de imagen.
select * from artista where imagen is null;
update artista set imagen = 'Imagen faltante' where imagen is null;
select * from artista;
