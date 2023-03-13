SET sql_mode = 'ONLY_FULL_GROUP_BY';
-- ============================= Proyecto - DHespegar ============================= --
-- ================================ Checkpoint III ================================ --
-- Código de camada: 
-- Equipo N°: 11
-- Integrantes: Felipe Calvache, Monica Muñoz, Jose Alvarez, Jorge Sierra

-- Consigna - CheckPoint III
-- 1. Listar todas las reservas de hoteles realizadas en la ciudad de Nápoles.
select h.nombre Hotel, h.ciudad Ciudad, r.idhotelesxreserva idHxR
from hoteles h
join hotelesxreserva r on r.idhotel = h.idhotel
where ciudad = "Napoles";

-- Row(s): 6

-- 1. Listar todas las reservas de hoteles realizadas en la ciudad de Nápoles.
select h.ciudad , idhotelesxreserva from hotelesxreserva hxr
inner join hoteles h on h.idhotel = hxr.idHotel
where h.ciudad = "Napoles";
 --  6 rows. 


-- 2. Listar el número de pago (idpago), el precio, la cantidad de cuotas de todas las
-- reservas realizadas con tarjeta de crédito.
select p.idpago idPagos, p.precioTotal Total, p.cantidadCuotas Cuotas, m.nombre MedioPago
from pagos p
join metodospago m on m.idmetodospago = p.idMetodosPago
where m.nombre = "Tarjeta de Crédito";

-- Row(s): 19

-- 2. Listar el número de pago (idpago), el precio, la cantidad de cuotas de todas las
-- reservas realizadas con tarjeta de crédito.
select idpago , p.precioTotal as total , p.cantidadCuotas ,mp.nombre as metodo_pago from pagos p
inner join metodospago mp on mp.idmetodospago = p.idMetodosPago
where mp.nombre = "Tarjeta de Crédito";
-- 19 rows 

-- 3. Listar la cantidad de reservas realizadas de acuerdo al método de pago.
select m.nombre MetodoPago, count(*) Reservas
from reservas r
join pagos p on p.idpago = r.idpago
join metodospago m on m.idmetodospago = p.idMetodosPago
group by m.nombre;

-- Row(s): 3

-- 3. Listar la cantidad de reservas realizadas de acuerdo al método de pago.
select mp.nombre as metodo_pago , count(idreserva) as cant_Reservas from reservas r 
inner join pagos p on p.idpago = r.idPago
inner join metodospago mp on mp.idmetodospago = p.idMetodosPago
group by  mp.nombre;
-- 3 row 


-- 4. Listar las reservas de los clientes cuyo pago lo hicieron a través de tarjeta de
-- crédito, se pide mostrar el nombre, apellido, país y el método de pago.
select m.nombre MetodoPago, concat(c.nombres, " ",c.apellidos) NombreCliente, pa.nombre Pais
from reservas r
join pagos p on p.idpago = r.idpago
join metodospago m on m.idmetodospago = p.idMetodosPago
join clientes c on c.idcliente = r.idCliente
join paises pa on pa.idpais = c.idPais
where m.nombre = "Tarjeta de Crédito";

-- Nos falta la columna del idReserva
-- Row(s): 19

-- 4. Listar las reservas de los clientes cuyo pago lo hicieron a través de tarjeta de
-- crédito, se pide mostrar el nombre, apellido, país y el método de pago.

select r.idreserva , c.nombres , c.apellidos , p.nombre as pais , mp.nombre as metodo_pago from clientes c
inner join paises p on p.idpais = c.idPais
inner join reservas r on r.idCliente = c.idcliente
inner join pagos on pagos.idpago = r.idPago
inner join metodospago mp on mp.idmetodospago = pagos.idmetodospago
where mp.nombre = "Tarjeta de Crédito";
-- 19 row 


-- 5. Listar la cantidad de reservas de hoteles por país, se necesita mostrar el nombre
-- del país y la cantidad.
select pa.idpais Paisid, pa.nombre Pais, count(r.idReserva) Reservas
from reservas r
join hotelesxreserva hr on hr.idReserva = r.idReserva
join hoteles h on h.idhotel = hr.idHotel
join paises pa on pa.idpais = h.idPais
group by pa.idpais
order by h.idhotel;

-- Order by no funciona porque no lo borramos por no poner la sentencia del FULL GROUP
-- Row(s): 8

-- 5. Listar la cantidad de reservas de hoteles por país, se necesita mostrar el nombre
-- del país y la cantidad.
select count(idhotelesxreserva) as cantidad , p.nombre as pais from hotelesxreserva hxr 
inner join hoteles h on h.idhotel = hxr.idHotel
inner join paises p on p.idpais = h.idPais
group by p.nombre;
-- 8 rows


-- 6. Listar el nombre, apellido, número de pasaporte,ciudad y nombre del país de los
-- clientes de origen Peruano.
select concat(c.nombres, " ",c.apellidos) NombreCliente, c.numeroPasaporte Pasaporte, c.ciudad Ciudad, pa.nombre Pais
from clientes c
join paises pa on pa.idpais = c.idPais
where pa.nombre = "Perú";

-- Row(s): 5


-- 6. Listar el nombre, apellido, número de pasaporte,ciudad y nombre del país de los
-- clientes de origen Peruano.
select c.nombres as nombre , c.apellidos as apellido , c.numeroPasaporte , c.ciudad as ciudad ,p.nombre as pais  from clientes c 
inner join paises p on p.idpais = c.idPais
where p.nombre = "Peru";
-- 5 rows

-- 7. Listar la cantidad de reservas realizadas de acuerdo al método de pago y el
-- nombre completo del cliente.
select m.nombre MetodoPago, concat(c.nombres, " ",c.apellidos) NombreCliente, count(m.nombre) Cantidad
from reservas r
join pagos p on p.idpago = r.idpago
join metodospago m on m.idmetodospago = p.idMetodosPago
join clientes c on c.idcliente = r.idCliente
group by m.nombre, concat(c.nombres, " ",c.apellidos);

-- Row(s): 51

-- 7. Listar la cantidad de reservas realizadas de acuerdo al método de pago y el
-- nombre completo del cliente.
select count(idreserva) as cantidad , concat (c.nombres ," ", c.apellidos) as cliente , mp.nombre as metodo_pago from clientes c 
inner join reservas r on r.idCliente = c.idcliente
inner join pagos on pagos.idpago = r.idPago
inner join metodospago mp on mp.idmetodospago = pagos.idmetodospago
group by cliente , mp.nombre;
-- 51 rows 

-- 8. Mostrar la cantidad de clientes por país, se necesita visualizar el nombre del
-- país y la cantidad de clientes.
select pa.nombre Pais, count(c.idcliente) Clientes
from clientes c
join paises pa on pa.idpais = c.idPais
group by pa.idpais;

-- Row(s): 11

-- 8. Mostrar la cantidad de clientes por país, se necesita visualizar el nombre del
-- país y la cantidad de clientes.

select p.nombre as pais , count(idcliente) as cant_clientes from paises p 
inner join clientes c on c.idPais = p.idpais
group by p.nombre;
-- 11 rows 


-- 9. Listar todas las reservas de hotel, se pide mostrar el nombre del hotel,dirección,
-- ciudad, el país, el tipo de pensión y que tengan como tipo de hospedaje 'Media
-- pensión'.
select h.nombre Hotel, concat(h.direccion, " ", h.ciudad, " ", pa.nombre) Locacion, th.nombre TipoHospedaje
from hotelesxreserva hr
join hoteles h on h.idhotel = hr.idHotel
join paises pa on pa.idpais = h.idpais
join tiposhospedaje th on th.idtiposhospedaje = hr.idTiposHospedaje
where th.nombre = "Media Pensión";

-- Row(s): 22

-- 9. Listar todas las reservas de hotel, se pide mostrar el nombre del hotel,dirección,
-- ciudad, el país, el tipo de pensión y que tengan como tipo de hospedaje 'Media
-- pensión'.

select idhotelesxreserva as id, h.nombre as hotel, h.direccion as direccion , h.ciudad as ciudad, p.nombre as pais , th.nombre as tipo_hospedaje from hotelesxreserva hxr
inner join hoteles h on hxr.idHotel = h.idhotel
inner join paises p on p.idpais = h.idPais
inner join tiposhospedaje th on th.idtiposhospedaje = hxr.idTiposHospedaje
where th.nombre = "Media pensión";
-- 22 rows 


-- 10. Mostrar por cada método de pago el monto total obtenido,se pide visualizar el
-- nombre del método de pago y el total.
select m.nombre MetodoPago, sum(p.precioTotal) Total
from pagos p
join metodospago m on m.idmetodospago = p.idMetodosPago
group by m.idmetodospago; 

-- Row(s): 3


-- 10. Mostrar por cada método de pago el monto total obtenido,se pide visualizar el
-- nombre del método de pago y el total.

select mp.nombre , sum(precioTotal) as total from pagos 
inner join metodospago mp on mp.idmetodospago = pagos.idmetodospago
group by mp.nombre;
-- 3 rows 

-- 11. Mostrar la suma de los pagos realizados en la sucursal de Mendoza, llamar al
-- resultado “TOTAL MENDOZA”.
select s.ciudad Ciudad, sum(p.precioTotal) Total
from pagos p
join metodospago m on m.idmetodospago = p.idMetodosPago
join reservas r on r.idPago = p.idpago
join sucursales s on s.idSucursal = r.idSucursal
where s.ciudad = "Mendoza";

-- Row(s): 1

-- 11. Mostrar la suma de los pagos realizados en la sucursal de Mendoza, llamar al
-- resultado “TOTAL MENDOZA”.
select sum(precioTotal) as "TOTAL MENDOZA" from pagos p
inner join reservas r on r.idPago = p.idpago
inner join sucursales s on s.idSucursal = r.idSucursal
where s.ciudad = "Mendoza";
-- 1 row 


-- 12. Listar todos los clientes que no han realizado reservas.
select concat(c.nombres, " ",c.apellidos) NombreCliente, 
case
	when r.codigoReserva is null then "Sin reserva"
    else r.codigoReserva
end as Reserva
from clientes c
left join reservas r on r.idCliente = c.idcliente
where r.idreserva is null or r.idreserva = "";

-- Row(s): 33


-- 12. Listar todos los clientes que no han realizado reservas.
select concat (c.nombres ," ", c.apellidos) as cliente , idreserva from clientes c 
left join reservas r on r.idCliente = c.idcliente
where idreserva is null;
-- 33 rows 

-- 13. Listar todas las reservas de vuelos realizadas donde el origen sea Chile y el
-- destino Ecuador, mostrar el id Reserva, id Vuelo, fecha de partida, fecha de
-- llegada, fecha de la reserva.
select r.idreserva reservaID, r.codigoReserva CodigoReserva, v.idvuelo VueloId, 
v.fechaPartida Partidad, v.fechaLlegada Llegada, r.fechaRegistro Registro, 
v.origen Origen, v.destino Destino
from vuelos v 
join vuelosxreserva vr on vr.idVuelo = v.idvuelo
join reservas r on r.idreserva = vr.idReserva
where v.origen = "Chile" 
and v.destino = "Ecuador";

-- Row(s): 3


-- 13. Listar todas las reservas de vuelos realizadas donde el origen sea Chile y el
-- destino Ecuador, mostrar el id Reserva, id Vuelo, fecha de partida, fecha de
-- llegada, fecha de la reserva.	
select v.origen as origen , v.destino as destino , vxr.idReserva , vxr.idVuelo , v.fechaPartida , v.fechaLlegada , fechaRegistro from vuelosxreserva vxr
inner join reservas r on r.idreserva = vxr.idReserva
inner join vuelos v on v.idvuelo = vxr.idVuelo
where origen = "Chile" and destino = "Ecuador";
-- 3 rows 

-- 14. Listar el nombre y cantidad de habitaciones de aquellos hoteles que tengan de
-- 30 a 70 habitaciones pertenecientes al país Argentina.
select h.nombre Hotel, h.cantidadHabitaciones CantidadHab, pa.nombre Pais
from hoteles h
join paises pa on pa.idpais = h.idPais
where h.cantidadHabitaciones >= 30
and h.cantidadHabitaciones <= 70
and pa.nombre = "Argentina";

-- Row(s): 3


-- 14. Listar el nombre y cantidad de habitaciones de aquellos hoteles que tengan de
-- 30 a 70 habitaciones pertenecientes al país Argentina.
select h.nombre as hotel , h.cantidadHabitaciones from hoteles h 
inner join paises p on p.idpais = h.idPais
where h.cantidadHabitaciones between 30 and 70 and p.nombre = "Argentina";
-- 3 rows 


-- 15. Listar el top 10 de hoteles más utilizados y la cantidad de reservas en las que ha
-- sido reservado.
select h.idhotel Hotel, h.nombre HotelNombre, count(idReserva) Reservas
from hoteles h
join hotelesxreserva hr on hr.idHotel = h.idhotel
group by h.idhotel
order by Reservas desc
limit 10;

-- Row(s): 10

-- 15. Listar el top 10 de hoteles más utilizados y la cantidad de reservas en las que ha
-- sido reservado.
select h.nombre as hotel , count(hxr.idHotel) as cantidad from hotelesxreserva hxr 
inner join hoteles h on h.idhotel = hxr.idHotel
group by h.nombre
order by cantidad desc
limit 10;
-- 10 rows 


-- 16. Listar los clientes (nombre y apellido) y cuáles han sido los medios de pago que
-- han utilizado, esta lista deberá estar ordenada por apellidos de manera
-- ascendente.
select c.nombres NombreCli, c.apellidos ApellidoCli, m.nombre MetodoPago
from reservas r
join pagos p on p.idpago = r.idpago
join metodospago m on m.idmetodospago = p.idMetodosPago
join clientes c on c.idcliente = r.idCliente
order by ApellidoCli;

-- Row(s): 62


-- 16. Listar los clientes (nombre y apellido) y cuáles han sido los medios de pago que
-- han utilizado, esta lista deberá estar ordenada por apellidos de manera
-- ascendente.
select concat (c.nombres ," ", c.apellidos) as cliente , mp.nombre from clientes c
inner join reservas r on r.idCliente = c.idcliente
inner join pagos on pagos.idpago = r.idPago
inner join metodospago mp on mp.idmetodospago = pagos.idmetodospago
order by c.apellidos; 
-- 62 rows 


-- 17. Listar la cantidad de reservas que se realizaron para los vuelos que el origen ha
-- sido de Argentina o Colombia, en el horario de las 18hs. Mostrar la cantidad de
-- vuelos, la fecha de partida,número de vuelo, país de origen y de destino.

select v.fechaPartida Partida, v.nroVuelo "# Vuelo", 
v.origen Origenes, v.destino Destino, count(r.codigoReserva) Reserva
from vuelos v 
join vuelosxreserva vr on vr.idVuelo = v.idvuelo
join reservas r on r.idreserva = vr.idReserva
where (v.origen = "Argentina" or  v.origen = "Colombia")
and hour(v.fechaPartida) = "18"
group by Origenes, v.nroVuelo, Destino;

-- Row(s): 3


-- 17. Listar la cantidad de reservas que se realizaron para los vuelos que el origen ha
-- sido de Argentina o Colombia, en el horario de las 18hs. Mostrar la cantidad de
-- vuelos y país de origen.
select count(vxr.idVuelo) as cantidad , v.origen as origen from vuelosxreserva vxr
inner join vuelos v on v.idvuelo = vxr.idVuelo
where HOUR(v.fechaPartida) = "18"
group by v.origen
having v.origen = "Argentina" or v.origen = "Colombia";
-- 1 row 


-- 18. Mostrar los totales de ventas por países y ordenarlas de mayor a menor.
select s.idSucursal sucursal, sum(precioTotal) ventasTotales, pa.idpais pais
from pagos p
join reservas r on p.idpago = r.idPago
join sucursales s on s.idSucursal = r.idSucursal
join paises pa on pa.idpais = s.idPais
group by s.idSucursal
order by precioTotal desc;

-- Row(s):6

-- 19. Mostrar los países que no tienen clientes asignados ordenados por los que
-- empiezan por Z primero.
select *
from paises pa
where pa.nombre like "Z%";

-- Row(s): 0

-- 20. Generar un listado con los hoteles que no tuvieron reservas realizadas.
select h.nombre Hotel, 
case
	when (hr.idhotelesxreserva is null or hr.idhotelesxreserva = "") then "Sin reserva"
    else hr.idhotelesxreserva
end as Reserva
from hoteles h
left join hotelesxreserva hr on hr.idHotel = h.idhotel
where hr.idhotelesxreserva is null or hr.idhotelesxreserva = "";

-- Row(s): 16

