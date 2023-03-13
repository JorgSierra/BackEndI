-- Parte 1:
-- ¡Estos reportes ya los conoces! Pero te pedimos que en este caso no utilices los
-- identificadores, sino que los reemplaces por su correspondiente descripción. Para
-- esto, vas a tener que realizar JOINS.
-- Por ejemplo, si quiero mostrar un reporte de películas más alquiladas, en lugar de
-- mostrar el ID de película, debemos mostrar el título.
-- Manos a la obra:
-- 1. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
-- que más dinero gastan y en cuantos alquileres lo hacen?
select concat(c.last_name, " ", c.first_name) Nombre, sum(amount) totalGastado, count(p.payment_id) Alquileres
from customer c
join payment p on p.customer_id = c.customer_id
group by c.customer_id
order by totalGastado desc
limit 10;

-- 2. Generar un reporte que indique: el id del cliente, la cantidad de alquileres y
-- el monto total para todos los clientes que hayan gastado más de 150 dólares
-- en alquileres.
select concat(c.last_name, " ", c.first_name) Nombre, sum(amount) totalGastado, count(p.payment_id) Alquileres
from customer c
join payment p on p.customer_id = c.customer_id
group by c.customer_id
having totalGastado > 150
order by totalGastado desc;

-- 3. Generar un reporte que responda a la pregunta: ¿cómo se distribuyen la
-- cantidad y el monto total de alquileres en los meses pertenecientes al año
-- 2005? (tabla payment).

select month(p.payment_date) Mes, sum(amount) total, count(p.payment_id) Alquileres
from payment p
group by month(p.payment_date);


-- 2

-- 4. Generar un reporte que responda a la pregunta: ¿cuáles son los 5 inventarios
-- más alquilados? (columna inventory_id en la tabla rental) Para cada una de
-- ellas, indicar la cantidad de alquileres.
select f.title Titulo, i.inventory_id, count(r.rental_id) Alquileres
from inventory i
join rental r on r.inventory_id = i.inventory_id
join film f on f.film_id = i.film_id
group by i.inventory_id;

-- Parte 2:
-- 1. Generar un reporte que responda a la pregunta: Para cada tienda
-- (store), ¿cuál es la cantidad de alquileres y el monto total del dinero
-- recaudado por mes?
select s.store_id IdTienda, sum(p.amount) Total, count(*) Alquileres
from store s 
join inventory i on i.store_id = s.store_id
join rental r on r.inventory_id = i.inventory_id
join payment p on p.rental_id = r.rental_id
group by s.store_id;

-- 2. Generar un reporte que responda a la pregunta: ¿cuáles son las 10 películas
-- que generan más ingresos? ¿ Y cuáles son las que generan menos ingresos?
-- Para cada una de ellas indicar la cantidad de alquileres.
select f.title Titulo, count(r.rental_id) Alquileres, sum(amount) Total
from inventory i
join rental r on r.inventory_id = i.inventory_id
join film f on f.film_id = i.film_id
join payment p on p.rental_id = r.rental_id
group by f.film_id
order by Total desc
limit 10;

select f.title Titulo, count(r.rental_id) Alquileres, sum(amount) Total
from inventory i
join rental r on r.inventory_id = i.inventory_id
join film f on f.film_id = i.film_id
join payment p on p.rental_id = r.rental_id
group by f.film_id
order by Total
limit 10;

-- 3. ¿Existen clientes que no hayan alquilado películas?
select *
from customer c
left join payment p on p.customer_id = c.customer_id
where p.payment_id is null or p.payment_id = "";

select *
from customer c
left join rental r on r.customer_id = c.customer_id
where r.rental_id is null or r.rental_id = "";

-- 4. Nivel avanzado: El jefe de stock quiere discontinuar las películas (film) con
-- menos alquileres (rental). ¿Qué películas serían candidatas a discontinuar?
-- Recordemos que pueden haber películas con 0 (Cero) alquileres.
select f.film_id, f.title as Pelicula, count(i.inventory_id) as Alquileres
from film f
join inventory i on i.film_id = f.film_id
left join rental r on r.inventory_id = i.inventory_id
group by f.title
order by Alquileres;






























-- Parte 1:
-- ¡Estos reportes ya los conoces! Pero te pedimos que en este caso no utilices los
-- identificadores, sino que los reemplaces por su correspondiente descripción. Para
-- esto, vas a tener que realizar JOINS.
-- Por ejemplo, si quiero mostrar un reporte de películas más alquiladas, en lugar de
-- mostrar el ID de película, debemos mostrar el título.
-- Manos a la obra:
-- 1. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes
-- que más dinero gastan y en cuantos alquileres lo hacen?


select p.customer_id as idCliente, concat(c.last_name, " ", c.first_name) as NombreCliente , sum(p.amount) as TotalGastado, count(p.rental_id) as CantidadAlquileres
from payment p
join customer c on p.customer_id = c.customer_id
group by p.customer_id
order by TotalGastado desc
limit 10;

-- 2. Generar un reporte que indique: el id del cliente, la cantidad de alquileres y
-- el monto total para todos los clientes que hayan gastado más de 150 dólares
-- en alquileres.
select p.customer_id as idCliente, concat(c.last_name, " ", c.first_name) as NombreCliente , sum(p.amount) as TotalGastado, count(p.rental_id) as CantidadAlquileres
from payment p
join customer c on p.customer_id = c.customer_id
group by p.customer_id
having TotalGastado > 150
order by TotalGastado desc;

-- 3. Generar un reporte que responda a la pregunta: ¿cómo se distribuyen la
-- cantidad y el monto total de alquileres en los meses pertenecientes al año
-- 2005? (tabla payment).
select year(payment_date) as Año, month(payment_date) as Mes, sum(amount) as Monto, count(payment_id) as Alquileres
from payment
group by year(payment_date), month(payment_date);


-- 2

-- 4. Generar un reporte que responda a la pregunta: ¿cuáles son los 5 inventarios
-- más alquilados? (columna inventory_id en la tabla rental) Para cada una de
-- ellas, indicar la cantidad de alquileres.
select i.inventory_id as IdInventario, count(r.customer_id) as VecesAlquilado
from inventory i
join rental r on r.inventory_id = i.inventory_id
group by IdInventario
order by VecesAlquilado desc
limit 5;

-- Parte 2:
-- 1. Generar un reporte que responda a la pregunta: Para cada tienda
-- (store), ¿cuál es la cantidad de alquileres y el monto total del dinero
-- recaudado por mes?
select s.store_id, count(*) as CantidadAlquileres, sum(amount) as TotalDinero
from store s
join inventory i on i.store_id = s.store_id
join rental r on r.inventory_id = i.inventory_id
join payment p on p.rental_id = r.rental_id
group by s.store_id;

-- 2. Generar un reporte que responda a la pregunta: ¿cuáles son las 10 películas
-- que generan más ingresos? ¿ Y cuáles son las que generan menos ingresos?
-- Para cada una de ellas indicar la cantidad de alquileres.
select f.title, count(r.rental_id) as Alquileres, sum(p.amount) as MontoPelicula
from film f
join inventory i on i.film_id = f.film_id
join rental r on r.inventory_id = i.inventory_id
join payment p on p.rental_id = r.rental_id
group by f.film_id
order by MontoPelicula desc
limit 10;

select f.title, count(r.rental_id) as Alquileres, sum(p.amount) as MontoPelicula
from film f
join inventory i on i.film_id = f.film_id
join rental r on r.inventory_id = i.inventory_id
join payment p on p.rental_id = r.rental_id
group by f.film_id
order by MontoPelicula
limit 10;


-- 3. ¿Existen clientes que no hayan alquilado películas?
select c.customer_id, p.payment_id
from customer c
left join payment p on p.customer_id = c.customer_id
where p.payment_id is null or p.payment_id = "";

-- 4. Nivel avanzado: El jefe de stock quiere discontinuar las películas (film) con
-- menos alquileres (rental). ¿Qué películas serían candidatas a discontinuar?
-- Recordemos que pueden haber películas con 0 (Cero) alquileres.
select f.film_id, f.title as Pelicula, 
case 
	when r.rental_id is null then 0
    else count(*)
end as CantidadRentas
from film f
join inventory i on i.film_id = f.film_id
left join rental r on r.inventory_id = i.inventory_id
group by f.title
having CantidadRentas <= 5
order by CantidadRentas;


-- Insertar nueva unidad a el inventario de la pelicula id 1
insert into inventory (film_id, store_id, last_update)
values (1, 1, now()); 
-- Insertar una nueva pelicula 
insert into film (title,language_id,rental_duration,rental_rate,replacement_cost,last_update)
values ("Los Pollos de mi cazuela", 1, 6, 4.99, 22.99,now());
-- Revisar la creacion de pelicula
select * from film
order by film_id desc;
-- Insertar nueva unidad a el inventario de la pelicula id 1001
insert into inventory (film_id, store_id, last_update)
values (1001, 1, now()); 
-- Revisar creación de inventario
select * 
from inventory
order by film_id desc;
-- Borrar pelicula de id 1 creada
delete from inventory where film_id = 1 and year(last_update) = 2022;
