-- 1. Obtener los artistas que han actuado en una o más películas.
select a.nombre, a.apellido, count(*) as totalpelis
from artista a
join artista_x_pelicula axp on axp.artista_id = a.id
group by a.id
having totalpelis >= 1;

-- 2. Obtener las películas donde han participado más de un artista según nuestra
-- base de datos.
select p.id, p.titulo, p.anio, count(artista_id) as cantArtistas
from artista a
join artista_x_pelicula axp on axp.artista_id = a.id
join pelicula p on axp.pelicula_id = p.id
group by axp.pelicula_id
having cantArtistas > 1;

-- 3. Obtener aquellos artistas que han actuado en alguna película, incluso
-- aquellos que aún no lo han hecho, según nuestra base de datos.
select a.id, a.nombre, a.apellido, count(axp.pelicula_id) as cantPeliculas
from artista a
left join artista_x_pelicula axp on axp.artista_id = a.id
group by a.id;

-- 4. Obtener las películas que no se le han asignado artistas en nuestra base de
-- datos.
select p.id, p.titulo, p.anio, axp.artista_id
from pelicula p
left join artista_x_pelicula axp on axp.pelicula_id = p.id
group by p.id
having	axp.artista_id is null;

-- 5. Obtener aquellos artistas que no han actuado en alguna película, según
-- nuestra base de datos.
select a.id, a.apellido, a.nombre, axp.pelicula_id
from artista a
left join artista_x_pelicula axp on axp.artista_id = a.id
group by a.id
having	axp.pelicula_id is null;

-- 6. Obtener aquellos artistas que han actuado en dos o más películas según
-- nuestra base de datos.
select a.nombre, a.apellido, count(*) as totalpelis
from artista a
join artista_x_pelicula axp on axp.artista_id = a.id
group by a.id
having totalpelis >= 2;

-- 7. Obtener aquellas películas que tengan asignado uno o más artistas, incluso
-- aquellas que aún no le han asignado un artista en nuestra base de datos.
select *, count(axp.artista_id) as totalArtistas
from pelicula p
left join artista_x_pelicula axp on axp.pelicula_id = p.id
group by p.id
having totalArtistas >= 1; 


select * from pelicula;
select * from artista_x_pelicula;
select * from artista;