-- CONSIGNAS
-- 1. Reportar los productos (nombre en mayúsculas), stock, unidad de medida y precio (agregar el signo de la moneda). Ordenarlos por nombre de producto.
select upper(p.nombre) as NombreProducto, p.stock, u.nombre as UnidadMedida, concat("$ ", p.precio) as Precio
from producto p
join unidad_medida u on p.unidad_medida_id = u.id
order by p.nombre;

-- 2.1 Reportar los productos (nombre en minúsculas), stock y las unidades de medidas sin importar si están o no asignadas a algún producto. Mostrar la leyenda –Sin Asignación- 
-- para los productos que figuren como nulos. Ordenarlos por el nombre de la unidad de medida.
select 
u.nombre as UnidadMedida,
case 
	when p.nombre is null then "–Sin Asignación-"
    else lower(p.nombre)
end as NombreProducto, 
case 
	when p.stock is null then "–Sin Asignación-"
    else p.stock
end as Stock,
case 
	when p.precio is null then "–Sin Asignación-"
    else concat("$ ", p.precio)
end as Precio
from producto p
right join unidad_medida u on p.unidad_medida_id = u.id
order by u.nombre;

-- 2.2 Modificar la consulta (2.1) para que muestre solamente los registros donde las unidades de medida aún no fueron asignadas a algún producto.
select 
u.nombre as UnidadMedida,
case 
	when p.nombre is null then "–Sin Asignación-"
    else lower(p.nombre)
end as NombreProducto, 
case 
	when p.stock is null then "–Sin Asignación-"
    else p.stock
end as Stock,
case 
	when p.precio is null then "–Sin Asignación-"
    else concat("$ ", p.precio)
end as Precio
from producto p
right join unidad_medida u on p.unidad_medida_id = u.id
where p.nombre is null
order by u.nombre;

-- 3.1 Listar todas las VENTAS mostrando el número de factura, nombre del producto, cantidad, importe y total facturado. Ordenarlo por número de factura. 
select f.id as NumeroFactura, p.nombre, d.cantidad, d.importe, f.total
from factura f
join factura_detalle d on f.id = d.factura_id
join producto p on d.producto_id = p.id;

-- 3.2 Modificar la consulta (3.1) para que muestre todas las VENTAS incluyendo a aquellos productos que aún no han sido vendidos. Finalmente, ordenarlo por número de Factura.  
select f.id as NumeroFactura, p.nombre, d.cantidad, d.importe, f.total
from factura f
join factura_detalle d on f.id = d.factura_id
right join producto p on d.producto_id = p.id;

-- 4.1 Listar todas las VENTAS mostrando el número de factura, fecha, nombre completo del cliente, nombre del producto, cantidad, 
-- unidad de medida, importe y total facturado. Ordenarlo por el número de factura de mayor a menor. 
select f.id as NumeroFactura, f.fecha as Fecha, concat(c.nombre, " ", c.apellido) as NombreCompleto,
p.nombre as Producto, d.cantidad, u.nombre as UnidadMedida, d.importe, f.total
from factura f
join factura_detalle d on f.id = d.factura_id
join producto p on d.producto_id = p.id
join cliente c on f.cliente_id = c.id
join unidad_medida u on p.unidad_medida_id = u.id
order by NumeroFactura desc;

-- 4.2 Modificar la consulta (4.1) para que muestre todas las ventas incluyendo a aquellos productos que aún no han sido vendidos. 
-- Finalmente, ordenarlo por número de factura. 
select f.id as NumeroFactura, f.fecha as Fecha, concat(c.nombre, " ", c.apellido) as NombreCompleto,
p.nombre as Producto, d.cantidad, u.nombre as UnidadMedida, d.importe, f.total
from factura f
join cliente c on f.cliente_id = c.id
join factura_detalle d on f.id = d.factura_id
right join producto p on d.producto_id = p.id
left join unidad_medida u on p.unidad_medida_id = u.id
order by NumeroFactura desc; 

-- 4.3 Modificar la consulta (4.1) para que muestre todas las ventas incluyendo a aquellos clientes que aún no han realizado alguna compra. 
-- Finalmente, ordenarlo por número de factura.
select f.id as NumeroFactura, f.fecha as Fecha, concat(c.nombre, " ", c.apellido) as NombreCompleto,
p.nombre as Producto, d.cantidad, u.nombre as UnidadMedida, d.importe, f.total
from factura f
join factura_detalle d on f.id = d.factura_id
join producto p on d.producto_id = p.id
right join cliente c on f.cliente_id = c.id
left join unidad_medida u on p.unidad_medida_id = u.id
order by NumeroFactura;

-- 4.4 Modificar la consulta (4.1) para que muestre todas las ventas incluyendo a aquellos productos que aún no han sido vendidos y 
-- las unidades de medidas que aún no han sido asignadas a algún producto.
select f.id as NumeroFactura, f.fecha as Fecha, concat(c.nombre, " ", c.apellido) as NombreCompleto,
p.nombre as Producto, d.cantidad, u.nombre as UnidadMedida, d.importe, f.total
from factura f
right join factura_detalle d on f.id = d.factura_id
right join producto p on d.producto_id = p.id
left join cliente c on f.cliente_id = c.id
right join unidad_medida u on p.unidad_medida_id = u.id
union
select f.id as NumeroFactura, f.fecha as Fecha, concat(c.nombre, " ", c.apellido) as NombreCompleto,
p.nombre as Producto, d.cantidad, u.nombre as UnidadMedida, d.importe, f.total
from factura f
right join factura_detalle d on f.id = d.factura_id
right join producto p on d.producto_id = p.id
left join cliente c on f.cliente_id = c.id
left join unidad_medida u on p.unidad_medida_id = u.id
order by NumeroFactura desc;
 

-- 5.1 Reportar los productos y cantidades que ha comprado cada cliente (id y nombre completo). Ordenar por cliente en forma descendente
-- y por producto en forma ascendente.
select c.id, concat(c.nombre, " ", c.apellido) as NombreCompleto, sum(d.cantidad) as CantidadDeTodasLasCompras, p.nombre as NombreProducto
from producto p
join factura_detalle d on d.producto_id = p.id
join factura f on f.id = d.factura_id
join cliente c on c.id = f.cliente_id
group by c.id, p.nombre
order by NombreCompleto, NombreProducto desc;

-- 5.2 Modificar la consulta (5.1) para que incluya aquellos clientes (id y nombre completo) que aún no han generado compras.

-- 6.2 Modificar la consulta (6.1) para que incluya aquellos productos que aún no han generado ventas.

-- 7.1 Reportar las ventas discriminando por fecha y cliente. Mostrar la fecha, nombre completo del cliente, cantidad de compras realizadas por día, 
-- recaudación total y la recaudación promedio. Finalmente, ordenar por la fecha de facturación y cliente.  

-- 8.1 Listar la cantidad de productos comprados por cada cliente. Se debe mostrar el número de documento y el nombre completo del cliente y, la cantidad, 
-- el menor y mayor precio de los productos.

-- 8.2 Listar la cantidad de productos comprados por cada cliente (incluir aquellos que aún no han hayan realizado una compra). 
-- Se debe mostrar el número de documento y el nombre completo del cliente y, la cantidad, el menor y mayor precio de los productos.

-- 9 Listar los productos y clasificar su stock. Mostrar el id y nombre del producto, el stock y su clasificación. 
-- Se debe clasificar como ‘Bajo’ cuando el stock es menor o igual a 5, ‘Medio’ cuando se encuentra entre 6 y 25, 
-- ‘Alto’ cuando es mayor a 25, y, ‘Sin Clasificación’ para algún otro rango.

-- 10 Listar los usuarios que tienen más de 32 años. Se debe mostrar el apellido, nombre y edad de cada uno.

-- 11 Mostrar el email y edad del usuario más joven que tiene más de 35 años.

-- 12 Mostrar el precio del producto más caro.

-- 13 Mostrar el producto más caro. Se debe mostrar nombre y precio. Al precio agregarle el signo pesos. 
