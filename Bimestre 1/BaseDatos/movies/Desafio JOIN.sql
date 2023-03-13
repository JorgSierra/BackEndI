-- Join
-- 1. Utilizando la base de datos de movies, queremos conocer, por un lado, los
-- títulos y el nombre del género de todas las series de la base de datos.
select title, genres.name
from series
full join genres on genre_id = genres.id;
-- 2. Por otro, necesitamos listar los títulos de los episodios junto con el nombre y
-- apellido de los actores que trabajan en cada uno de ellos.
select title, first_name, last_name
from episodes
join actor_episode on episode_id = episodes.id
join actors on actor_id = actors.id;
-- 3. Para nuestro próximo desafío, necesitamos obtener a todos los actores o
-- actrices (mostrar nombre y apellido) que han trabajado en cualquier película
-- de la saga de La Guerra de las galaxias.
select title, first_name, last_name
from movies
join actor_movie on movie_id = movies.id
join actors on actor_id = actors.id
where title like "%La guerra de las galaxias%";
-- 4. Crear un listado a partir de la tabla de películas, mostrar un reporte de la
-- cantidad de películas por nombre de género.
select name, count(*)
from movies
join genres on genre_id = genres.id
group by genres.name;
