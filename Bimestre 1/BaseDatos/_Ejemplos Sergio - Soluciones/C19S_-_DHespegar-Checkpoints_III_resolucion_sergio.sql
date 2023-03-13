-- ============================= Proyecto - DHespegar ============================= --
-- =========================== ResoluciON Checkpoint III ========================== --

SET sql_mode = 'ONLY_FULL_GROUP_BY';

-- 1. Listar todas las reservas de hoteles realizadas en la ciudad de Nápoles.
-- rows:6
SELECT * from hotelesxreserva hr
JOIN tiposhospedaje th ON hr.idTiposHospedaje = th.idtiposhospedaje 
JOIN hoteles h ON hr.idHotel = h.idhotel
WHERE h.ciudad = 'napoles';

-- 2. Listar el número de pago (idpago), el precio, la cantidad de cuotas de todas las
-- reservas realizadas con tarjeta de crédito.
-- rows:19
SELECT p.idpago AS numeroDePago, p.precioTotal AS precio, p.cantidadCuotas, mp.nombre AS metodoDePago FROM pagos p
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
WHERE mp.nombre = 'Tarjeta de Credito';

-- 3. Listar la cantidad de reservas realizadas de acuerdo al método de pago.
-- rows:3
SELECT mp.nombre AS metodoDePago, COUNT(r.idreserva) AS cantidad FROM reservas r
JOIN pagos p ON r.idPago = p.idpago
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
GROUP BY mp.nombre;

-- 4. Listar las reservas de los clientes cuyo pago lo hicieron a través de tarjeta de
-- crédito, se pide mostrar el nombre, apellido, país y el método de pago.
-- rows:19
SELECT c.nombres, c.apellidos, pa.nombre, mp.nombre AS metodoDePago FROM reservas r
JOIN clientes c on r.idCliente = c.idcliente
JOIN pagos p ON r.idPago = p.idpago
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
JOIN paises pa ON c.idPais = pa.idPais
WHERE mp.nombre = 'Tarjeta de Crédito';

-- 5. Listar la cantidad de reservas de hoteles por país, se necesita mostrar el nombre
-- del país y la cantidad.
-- rows:8
SELECT p.nombre AS pais, COUNT(hr.idhotelesxreserva) AS cantidadDeReservas from hotelesxreserva hr
JOIN tiposhospedaje th ON hr.idTiposHospedaje = th.idtiposhospedaje 
JOIN hoteles h ON hr.idHotel = h.idhotel
JOIN paises p ON h.idPais = p.idpais
GROUP BY p.nombre;

-- 6. Listar el nombre, apellido, número de pasaporte,ciudad y nombre del país de los
-- clientes de origen Peruano.
-- rows:5
SELECT c.nombres, c.apellidos, c.numeroPasaporte, c.ciudad, p.nombre AS pais FROM clientes c
JOIN paises p ON p.idpais = c.idPais
WHERE p.nombre = 'Peru';

-- 7. Listar la cantidad de reservas realizadas de acuerdo al método de pago y el
-- nombre completo del cliente.
-- rows:51
SELECT mp.nombre AS metodoDePago, CONCAT(c.nombres, ' ', c.apellidos), COUNT(idreserva) AS cantidad FROM reservas r
JOIN pagos p ON r.idPago = p.idpago
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
JOIN clientes c ON r.idcliente = c.idcliente
GROUP BY mp.nombre, CONCAT(c.nombres, ' ', c.apellidos);

-- 8. Mostrar la cantidad de clientes por país, se necesita visualizar el nombre del
-- país y la cantidad de clientes.
-- rows:11
SELECT p.nombre AS Pais, COUNT(c.idcliente) AS cantidadDeClientes FROM clientes c
JOIN paises p ON p.idpais = c.idPais
GROUP BY p.nombre;

-- 9. Listar todas las reservas de hotel, se pide mostrar el nombre del hotel,dirección,
-- ciudad, el país, el tipo de pensión y que tengan como tipo de hospedaje 'Media
-- pensión'.
-- rows:22
SELECT h.nombre, h.direccion, h.ciudad, p.nombre, th.nombre FROM hotelesxreserva hr
JOIN tiposhospedaje th ON hr.idTiposHospedaje = th.idtiposhospedaje 
JOIN hoteles h ON hr.idHotel = h.idhotel
JOIN paises p ON h.idPais = p.idpais
WHERE th.nombre = 'Media Pensión';

-- 10. Mostrar por cada método de pago el monto total obtenido,se pide visualizar el
-- nombre del método de pago y el total.
-- rows:3
SELECT mp.nombre AS metododePago, SUM(precioTotal) AS montoTotal FROM pagos p
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
GROUP BY mp.nombre;

-- 11. Mostrar la suma de los pagos realizados en la sucursal de Mendoza, llamar al
-- resultado “TOTAL MENDOZA”.
-- rows:
SELECT sum(precioTotal) AS "TOTAL MENDOZA" FROM pagos p
JOIN reservas r ON r.idPago = p.idPago
JOIN sucursales s ON r.idSucursal = s.idSucursal
WHERE s.ciudad = "Mendoza";

-- 12. Listar todos los clientes que no han realizado reservas.
-- rows:33
SELECT c.nombres, c.apellidos, c.telefono FROM clientes c
LEFT JOIN reservas s ON s.idCliente = c.idCliente 
WHERE s.idreserva IS NULL;

-- 13. Listar todas las reservas de vuelos realizadas donde el origen sea Chile y el
-- destino Ecuador, mostrar el id Reserva, id Vuelo, fecha de partida, fecha de
-- llegada, fecha de la reserva.
-- rows:3
SELECT r.idreserva, v.idVuelo, v.fechaPartida, v.fechallegada, r.fechaRegistro FROM reservas r
JOIN vuelosxreserva vr ON vr.idreserva = r.idreserva
JOIN vuelos v ON v.idvuelo = vr.idvuelo
WHERE v.origen = "chile" and v.destino = "ecuador";

-- 14. Listar el nombre y cantidad de habitaciones de aquellos hoteles que tengan de
-- 30 a 70 habitaciones pertenecientes al país Argentina.
-- rows:3
SELECT h.nombre, cantidadHabitaciones FROM hoteles h
JOIN paises p ON p.idpais=h.idPais
WHERE p.nombre = "Argentina" AND h.cantidadHabitaciones BETWEEN 30 AND 70;

-- 15. Listar el top 10 de hoteles más utilizados y la cantidad de reservas en las que ha
-- sido reservado.
-- rows:
SELECT h.nombre, cantidadHabitaciones 
FROM hoteles h
JOIN paises p ON p.idpais=h.idPais
WHERE p.nombre = "Argentina" AND h.cantidadHabitaciones BETWEEN 30 AND 70;

-- 15.Listar el top 10 de hoteles más utilizados y la cantidad de reservas en las que ha sido reservado.
-- rows:10
SELECT COUNT(r.idreserva) AS cantidad, h.nombre FROM reservas r 
JOIN hotelesxreserva hr ON r.idreserva = hr.idhotelesxreserva
JOIN hoteles h ON h.idhotel = hr.idHotel
GROUP BY h.nombre 
ORDER BY cantidad DESC
LIMIT 10 ;

-- 16. Listar los clientes (nombre y apellido) y cuáles han sido los medios de pago que
-- han utilizado, esta lista deberá estar ordenada por apellidos de manera ascendente.
-- rows:62
SELECT CONCAT(c.nombres, " ", apellidos) AS cliente, mp.nombre AS medioDePago FROM reservas r
JOIN pagos p ON p.idPago = r.idPago
JOIN metodospago mp ON mp.idmetodospago = p.idMetodosPago
JOIN clientes c ON c.idcliente = r.idcliente
ORDER BY c.apellidos;

-- 17. Listar la cantidad de reservas que se realizaron para los vuelos que el origen ha
-- sido de Argentina o Colombia, en el horario de las 18hs. Mostrar la cantidad de
-- vuelos y país de origen.
-- rows: 1
SELECT COUNT(*) AS cantidad, v.origen AS paisDeOrigen FROM reservas r 
JOIN clientes c ON c.idCliente = r.idcliente
JOIN vuelosxreserva rv ON rv.idreserva = r.idreserva
JOIN vuelos v ON v.idvuelo = rv.idvuelo 
WHERE v.origen IN("argentina","colombia") AND HOUR(fechaPartida) = 18
GROUP BY v.origen;

-- 18. Mostrar los totales de ventas de sucursales por países y ordenarlas de mayor a menor.
-- rows:2
SELECT SUM(p.precioTotal) AS total, pa.nombre FROM reservas r 
JOIN pagos p ON p.idpago = r.idpago 
JOIN sucursales s ON s.idsucursal = r.idsucursal
JOIN paises pa ON pa.idpais = s.idpais
GROUP BY pa.nombre 
ORDER BY total DESC;

-- 19. Mostrar los países que no tienen clientes asignados ordenados por los que
-- empiezan por Z primero.
-- rows:19
SELECT p.nombre FROM paises p
LEFT JOIN clientes c ON p.idpais = c.idpais
WHERE c.idcliente IS NULL
ORDER BY nombre DESC;

-- 20. Generar un listado con los hoteles que tuvieron más de 2 reservas realizadas.
-- Mostrar el nombre del hotel y la cantidad.
-- rows:
SELECT h.nombre AS hotel, COUNT(hr.idhotelesxreserva) AS cantidadDeReservas FROM hoteles h
LEFT JOIN hotelesxreserva hr ON hr.idHotel = h.idhotel
GROUP BY h.nombre
having cantidadDeReservas > 2;
