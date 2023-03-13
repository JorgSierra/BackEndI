SET sql_mode = 'ONLY_FULL_GROUP_BY';
-- Clientes
-- 1) ¿Cuántos clientes existen?
select count(ClienteID) from clientes;

-- ROWs : 1

-- 2) ¿Cuántos clientes hay por ciudad?
select ciudad, count(ClienteID)
from clientes
group by ciudad;

-- ROWs : 69

-- Facturas
-- 1) ¿Cuál es el total de transporte?
select sum(Transporte) as "Total transporte"
from facturas;

-- ROWs : 1

-- 2) ¿Cuál es el total de transporte por EnvioVia (empresa de envío)?
select EnvioVia, sum(Transporte) as "Total transporte"
from facturas
group by EnvioVia;

-- ROWs : 3

-- 3) Calcular la cantidad de facturas por cliente. Ordenar descendentemente por
-- cantidad de facturas.
select ClienteID, count(FacturaID) as "Total facturas"
from facturas
group by ClienteID
order by count(FacturaID) desc;

-- ROWs : 89

-- 4) Obtener el Top 5 de clientes de acuerdo a su cantidad de facturas.
select ClienteID, count(FacturaID) as "Total facturas"
from facturas
group by ClienteID
order by count(FacturaID) desc
limit 5;

-- ROWs : 5

-- 5) ¿Cuál es el país de envío menos frecuente de acuerdo a la cantidad de facturas?
select PaisEnvio, count(FacturaID)
from facturas
group by PaisEnvio
order by count(FacturaID)
limit 1;

-- ROWs : 1

-- 6) Se quiere otorgar un bono al empleado con más ventas. ¿Qué ID de empleado
-- realizó más operaciones de ventas?
select EmpleadoID, count(FacturaID)
from facturas
group by EmpleadoID
order by count(FacturaID) desc
limit 1;

-- ROWs : 1


-- Factura detalle
-- 1) ¿Cuál es el producto que aparece en más líneas de la tabla Factura Detalle?	
select ProductoID, count(*)
from facturadetalle
group by ProductoID
order by count(*) desc
limit 1;

-- ROWs : 1

-- 2) ¿Cuál es el total facturado? Considerar que el total facturado es la suma de
-- cantidad por precio unitario.
select sum(Cantidad * PrecioUnitario)
from facturadetalle;

-- ROWs : 1

-- 3) ¿Cuál es el total facturado para los productos ID entre 30 y 50?
select sum(Cantidad * PrecioUnitario)
from facturadetalle
where ProductoID between 30 and 50;

-- ROWs : 1

-- 4) ¿Cuál es el precio unitario promedio de cada producto?
select productoID, avg(PrecioUnitario)
from facturadetalle
group by productoID;

-- ROWs : 77

-- 5) ¿Cuál es el precio unitario máximo?


-- Consultas queries XL parte II - JOIN
-- 1) Generar un listado de todas las facturas del empleado 'Buchanan'.
select f.FacturaID, e.Apellido
from empleados e
join facturas f on e.EmpleadoID = f.EmpleadoID
where e.Apellido = 'Buchanan';
-- 2) Generar un listado con todos los campos de las facturas del correo 'Speedy
-- Express'.
-- 3) Generar un listado de todas las facturas con el nombre y apellido de los
-- empleados.
-- 4) Mostrar un listado de las facturas de todos los clientes “Owner” y país de envío
-- “USA”.
-- 5) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
-- “Leverling” o que incluyan el producto id = “42”.
-- 6) Mostrar todos los campos de las facturas del empleado cuyo apellido sea
-- “Leverling” y que incluya los producto id = “80” o ”42”.
-- 7) Generar un listado con los cinco mejores clientes, según sus importes de
-- compras total (PrecioUnitario * Cantidad).
-- 8) Generar un listado de facturas, con los campos id, nombre y apellido del cliente,
-- fecha de factura, país de envío, Total, ordenado de manera descendente por
-- fecha de factura y limitado a 10 filas.