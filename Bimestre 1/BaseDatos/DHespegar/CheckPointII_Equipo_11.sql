-- Equipo 11 - Rocio Gomez, David Florez, Jorge Sierra


-- 1. Listar todos los clientes que su apellido empiece por A, ordenados por apellido
-- de manera ascendente.
SELECT idcliente, apellidos FROM clientes 
WHERE apellidos LIKE 'A%'
order by apellidos ASC;

-- CANTIDAD DE REGISTROS: 10

-- 2. Listar nombre, apellido,dirección de aquellos clientes que en su dirección
-- contengan la palabra “martin”.
select nombres, apellidos, direccion 
from clientes
where direccion like '%martin%';

-- CANTIDAD DE REGISTROS: 5

-- 3. Listar todos los hoteles que tengan de 30 a 60 habitaciones.
select * from hoteles
where cantidadHabitaciones between 30 
and 60;

-- CANTIDAD DE REGISTROS: 13

-- 4. Mostrar cuál ha sido el mayor importe facturado y llamarlo “Precio Mayor”,
-- también mostrar cuál es el total facturado y llamarlo “TOTAL”.
select max(precioTotal) as "Precio Mayor", sum(precioTotal) as "TOTAL"
from pagos;

-- CANTIDAD DE REGISTROS: 1

-- 5. Listar las reservas que fueron realizadas el día 16/01/2022 entre las 15hs y las
-- 21hs pertenecientes a la sucursal número 5.
select * 
from reservas
where date(fechaRegistro) = "2022-01-16"
and time(fechaRegistro) between "15:00:00" and "21:00:00"
and idSucursal = 5;

-- CANTIDAD DE REGISTROS: 3

-- 6. Mostrar el top 3 de reservas con mayor cantidad de vuelos.
select idReserva, count(idVuelo) from vuelosxreserva
group by idReserva
order by count(idVuelo) desc
limit 3;

-- CANTIDAD DE REGISTROS: 3


-- 7. Listar los 10 pagos de menor precio.
select idpago, precioTotal
from pagos
order by precioTotal asc
limit 10;

-- CANTIDAD DE REGISTROS: 10

-- 8. Listar todos los países ordenados alfabéticamente y con su nombre en
-- mayúsculas.
select upper(nombre), idpais
from paises
order by nombre;

-- CANTIDAD DE REGISTROS: 30

-- 9. Mostrar todos las reservas de vuelos que sean de clase turista y el id de vuelo
-- sea 11 o 13.
select idVuelo, idReserva
from vuelosxreserva
where idVuelo = 11
or idVuelo = 13;

-- CANTIDAD DE REGISTROS: 11

-- 10. Listar los usuarios que hayan realizado 2 reservas.
select idCliente, count(idreserva) as CantidadReservas
from reservas
group by idCliente
having CantidadReservas = 2;

-- CANTIDAD DE REGISTROS: 9

-- 11. Mostrar todos los vuelos que tengan como origen Italia o destino Jamaica.
SELECT idvuelo, origen, destino FROM vuelos
WHERE origen = 'Italia' OR destino = 'Jamaica';

-- CANTIDAD DE REGISTROS: 8

-- 12. Mostrar todos los vuelos que tengan como destino Cuba y la cantidad de
-- pasajeros de primera clase sea menor o igual a 15 personas.
SELECT * FROM vuelos
WHERE destino = 'Cuba' 
AND cantidadPrimeraClase <= 15;

-- CANTIDAD DE REGISTROS: 2

-- 13. Se desea conocer cuál es la cantidad de vuelos que tienen como origen México.
SELECT count(idvuelo) 
FROM vuelos
WHERE origen = 'Mexico';

-- CANTIDAD DE REGISTROS: 1


-- 14. Se desea conocer cuál es la cantidad de reservas realizadas en la sucursal de
-- Mendoza por el cliente cuyo pasaporte es EC158846.
select * FROM clientes
WHERE numeroPasaporte = 'EC158846';
select * From sucursales; 
select * From reservas; 

SELECT count(idreserva) FROM reservas
WHERE idSucursal = 1 AND idCliente = 13;

-- CANTIDAD DE REGISTROS: 1

-- 15. Cual es el promedio de pasajeros de clase turista que tengan como destino
-- Jamaica.
SELECT AVG(cantidadTurista) FROM vuelos
WHERE destino = 'Jamaica'; 

-- CANTIDAD DE REGISTROS: 1

-- 16. Cual es el monto total de los pagos realizados en efectivo.(campo:preciototal ).
select idMetodosPago, sum(precioTotal) 
from pagos
group by idMetodosPago
having idMetodosPago = 1;

-- CANTIDAD DE REGISTROS: 1

-- 17. Mostrar el tercer importe de pagos realizado con menor valor.
select idpago, precioTotal
from pagos
order by precioTotal
limit 1
offset 2;

-- CANTIDAD DE REGISTROS: 1

-- 18. Se desea conocer la cantidad de reservas realizadas en Chile más
-- específicamente en el 'Santiago Hotel' .
select idHotel, count(idReserva)
from hotelesxreserva
where idHotel = 15;

-- CANTIDAD DE REGISTROS: 1

-- 19. Agregar al cliente Solari Carlos cuyo pasaporte es AR221422 , domiciliado en
-- calle Av.Libertad 451 de la ciudad de Córdoba-Argentina, teléfono móvil
-- +542645667714.
insert into clientes (apellidos, nombres, numeropasaporte, direccion, ciudad, telefono, idPais)
values ("Solari", "Carlos", "AR221422", "Av.Libertad 451", "Cordoba", "+542645667714", 1); 


-- CANTIDAD DE REGISTROS: 1

-- 20. Modificar el tipo de hospedaje de 'Pensión Completa' a 'Pensión Premium'
-- Se solicita
update tiposhospedaje
set nombre = 'Pensión Premium'
where idtiposhospedaje = 2;

-- CANTIDAD DE REGISTROS: 1

select * from tiposhospedaje;

-- CANTIDAD DE REGISTROS: 2
