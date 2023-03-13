-- Ignacio Lopez, Gian Panigatti, Pablo Moya, Jorge Sierra


-- Consultas SELECT y GROUP BY
-- Realizar los siguientes informes:

-- 1. Listar las canciones cuya duración sea mayor a 2 minutos.
select nombre, milisegundos
from canciones
where milisegundos > 120000
limit 10000;

-- ROWs: 3409

-- 2. Listar las canciones cuyo nombre comience con una vocal ("a%","e%","i%","o%","u%").
select nombre
from canciones
where nombre like "a%"
or nombre like "e%"
or nombre like "i%"
or nombre like "o%"
or nombre like "u%";

-- ROWs: 618

-- 3. Listar las canciones ordenadas por compositor en forma descendente.
select nombre, compositor
from canciones
order by compositor desc
limit 10000;

-- ROWs: 3503

-- Luego, por nombre en forma ascendente. Incluir únicamente aquellas
-- canciones que tengan compositor.
select nombre, compositor
from canciones
where compositor != ""
order by nombre asc
limit 10000;

-- ROWs: 2525

-- 4. a) Listar la cantidad de canciones de cada compositor.
select compositor, count(*)
from canciones
group by compositor;

-- ROWs: 852

-- b) Modificar la consulta para incluir únicamente los compositores que
-- tengan más de 10 canciones.
select compositor, count(*) as cantidad
from canciones
group by compositor
having cantidad > 10;

-- ROWs: 56

-- 5. a) Listar el total facturado agrupado por ciudad.
select ciudad_de_facturacion, sum(total)
from facturas
group by ciudad_de_facturacion;

-- ROWs: 53

-- b) Modificar el listado del punto (a) mostrando únicamente las ciudades
-- de Canadá.
select ciudad_de_facturacion, pais_de_facturacion, sum(total)
from facturas
group by ciudad_de_facturacion
having pais_de_facturacion = "Canadá";

-- ROWs: 8

-- c) Modificar el listado del punto (a) mostrando únicamente las ciudades
-- con una facturación mayor a 38.
select ciudad_de_facturacion, sum(total) as total
from facturas
group by ciudad_de_facturacion
having total > 38;

-- ROWs: 29

-- d) Modificar el listado del punto (a) agrupando la facturación por país, y
-- luego por ciudad.
select pais_de_facturacion
from facturas
group by pais_de_facturacion;

-- ROWs: 24

select ciudad_de_facturacion
from facturas
group by ciudad_de_facturacion;

-- ROWs: 53

-- 6. a) Listar la duración mínima, máxima y promedio de las canciones.
select min(milisegundos) as minima, max(milisegundos) as maxima, avg(milisegundos) as promedio
from canciones;

-- ROWs: 1

-- b) Modificar el punto (a) mostrando la información agrupada por género.
select id_genero, min(milisegundos) as minima, max(milisegundos) as maxima, avg(milisegundos) as promedio
from canciones
group by id_genero;

-- ROWs: 25
