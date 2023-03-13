-- Caso de estudio: Sakila - Volver al Futuro II (Resolución)
-- Base de datos: sakila

-- PARTE 1
-- 1. Generar un reporte que responda la pregunta: ¿cuáles son los diez clientes que más dinero gastan y en cuantos alquileres lo hacen?
SELECT CONCAT(c.first_name, ' ', c.last_name) AS Cliente, COUNT(r.rental_id) Cantidad, SUM(p.amount) AS Total FROM customer c
INNER JOIN rental r ON r.customer_id = c.customer_id
INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY c.customer_id
ORDER BY Total DESC
LIMIT 10;

-- 2. Generar un reporte que indique: el id del cliente, la cantidad de alquileres y el monto total para todos los clientes que hayan gastado más de 150 dólares
-- en alquileres.
SELECT c.customer_id AS ClienteID, COUNT(r.rental_id) AS Cantidad, SUM(p.amount) Monto_Total FROM customer c
INNER JOIN rental r ON r.customer_id = c.customer_id
INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY c.customer_id
HAVING Monto_Total > 150;

-- 3. Generar un reporte que responda a la pregunta: ¿cómo se distribuyen la cantidad y el monto total de alquileres en los meses pertenecientes al año 2005?
-- tabla: payment
SELECT MONTH(p.payment_date) AS Mes, COUNT(r.rental_id) AS Cantidad, SUM(p.amount) As Total FROM payment p
INNER JOIN rental r ON r.rental_id = p.rental_id
WHERE YEAR(p.payment_date) = 2005
GROUP BY Mes;

-- 4. Generar un reporte que responda a la pregunta: ¿cuáles son los 5 inventarios más alquilados? (columna inventory_id en la tabla rental) Para cada una de ellas, indicar la cantidad de alquileres.
SELECT i.inventory_id, COUNT(r.rental_id) AS Cantidad FROM rental r
INNER JOIN inventory i ON i.inventory_id =r.inventory_id
GROUP BY r.inventory_id
ORDER BY Cantidad DESC
LIMIT 5;

-- PARTE 2
-- 1. Generar un reporte que responda a la pregunta: Para cada tienda (store), ¿cuál es la cantidad de alquileres y el monto total del dinero recaudado por mes?
SELECT s.store_id AS TiendaID, MONTH(p.payment_date) AS Mes, COUNT(r.rental_id) AS Cantidad, SUM(p.amount) AS Total FROM store s
INNER JOIN staff ON staff.staff_id = s.manager_staff_id
INNER JOIN rental r ON r.staff_id = staff.staff_id
INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY TiendaID, Mes;

-- 2. Generar un reporte que responda a la pregunta: 
-- a) ¿cuáles son las 10 películas que generan más ingresos?
SELECT f.title AS Pelicula, SUM(p.amount) Total, COUNT(r.rental_id) Cantidad FROM film f
INNER JOIN inventory i ON i.film_id = f.film_id
INNER JOIN rental r ON r.inventory_id = i.inventory_id
INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY f.film_id
ORDER BY Total DESC
LIMIT 10;
-- b) ¿ Y cuáles son las que generan menos ingresos? Para cada una de ellas indicar la cantidad de alquileres.
SELECT f.title AS Pelicula, SUM(p.amount) Total, COUNT(r.rental_id) Cantidad FROM film f
INNER JOIN inventory i ON i.film_id = f.film_id
INNER JOIN rental r ON r.inventory_id = i.inventory_id
INNER JOIN payment p ON p.rental_id = r.rental_id
GROUP BY f.film_id
ORDER BY Total
LIMIT 10;

-- 3. ¿Existen clientes que no hayan alquilado películas?
SELECT CONCAT(c.first_name, c.last_name) AS Cliente, r.rental_id FROM customer c
LEFT JOIN rental r ON r.customer_id = c.customer_id
WHERE ISNULL(r.rental_id);

-- 4. Nivel avanzado: El jefe de stock quiere discontinuar las películas (film) con menos alquileres (rental). ¿Qué películas serían candidatas a discontinuar? Recordemos que pueden haber películas con 0 (Cero) alquileres.
SELECT f.title AS Pelicula, COUNT(r.rental_id) AS Cantidad FROM film f
LEFT JOIN inventory i ON i.film_id = f.film_id
LEFT JOIN rental r ON r.inventory_id = i.inventory_id
GROUP BY Pelicula
ORDER BY Cantidad;