-- Ejercicio 1

-- 1. Crear una vista para poder organizar los envíos de las facturas. Indicar número
-- de factura, fecha de la factura y fecha de envío, ambas en formato dd/mm/yyyy,
-- valor del transporte formateado con dos decimales, y la información del
-- domicilio del destino incluyendo dirección, ciudad, código postal y país, en una
-- columna llamada Destino.
create view v_enviosFacturas as
select f.FacturaID, date_format(f.FechaFactura, "%d/%m/%y") as FechaFactura, 
date_format(f.FechaEnvio, "%d/%m/%y") as FechaEnvio, round(Transporte,2) as Transporte,
concat(f.DireccionEnvio, " , ", f.CiudadEnvio, " , ", f.CodigoPostalEnvio, " , ", f.PaisEnvio) as Destino
from facturas f;
-- 2. Realizar una consulta con todos los EnvioVia y 
-- el detalle de las facturas que usaron ese EnvioVia. Utilizar la vista creada.

select v.FacturaID, f.EnvioVia, d.ProductoID, d.PrecioUnitario, d.Cantidad, d.Descuento
from v_enviosFacturas v
join facturas f on f.FacturaID = v.FacturaID
join facturadetalle d on d.FacturaID = v.FacturaID;

-- 3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
-- alternativa o solución.

-- Buscar todos de facturas 
select * from facturas f
join facturadetalle d on f.FacturaID = d.FacturaID;

-- Ejercicio 2

-- 1. Crear una vista con un detalle de los productos en stock. Indicar id, nombre del
-- producto, nombre de la categoría y precio unitario.
create view v_productoCategoria as
select p.ProductoID, p.ProductoNombre, p.PrecioUnitario, c.CategoriaNombre
from productos p
join categorias c on c.CategoriaID = p.CategoriaID;
-- 2. Escribir una consulta que liste el nombre y la categoría de todos los productos
-- vendidos. Utilizar la vista creada.
-- ProductoNombre, CategoriaNombre

select v.ProductoNombre, v.CategoriaNombre, count(FacturaID) as cantidadFacturas
from v_productoCategoria v
join facturadetalle d on d.productoID = v.productoID
group by v.ProductoID;


-- 3. ¿Qué dificultad o problema encontrás en esta consigna? Proponer alguna
-- alternativa o solución.

-- Hacer una vista de la consulta anterior