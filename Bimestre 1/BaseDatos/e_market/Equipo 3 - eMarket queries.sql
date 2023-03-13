-- Categorías y productos
-- 1. Queremos tener un listado de todas las categorías.
select * from categorias;
-- 2. Cómo las categorías no tienen imágenes, solamente interesa obtener un
-- listado de CategoriaNombre y Descripcion.
select CategoriaNombre, Descripcion from categorias;
-- 3. Obtener un listado de los productos.
select * from productos;
-- 4. ¿Existen productos discontinuados? (Discontinuado = 1).
select * from productos
where Discontinuado = 1;
-- 5. Para el viernes hay que reunirse con el Proveedor 8. ¿Qué productos son
-- los que nos provee?
select * from productos
where ProveedorID = 8;
-- 6. Queremos conocer todos los productos cuyo precio unitario se encuentre
-- entre 10 y 22.
select ProductoNombre, PrecioUnitario from productos
where PrecioUnitario between 10 and 22;
-- 7. Se define que un producto hay que solicitarlo al proveedor si sus unidades
-- en stock son menores al Nivel de Reorden. ¿Hay productos por solicitar?
select * from productos
where UnidadesStock < NivelReorden;
-- 8. Se quiere conocer todos los productos del listado anterior, pero que
-- unidades pedidas sea igual a cero.
select * from productos
where UnidadesStock < NivelReorden 
and UnidadesPedidas = 0;

-- Clientes
-- 1. Obtener un listado de todos los clientes con Contacto, Compania, Título,
-- País. Ordenar el listado por País.
select Contacto, Compania, Titulo, Pais 
from clientes
order by Pais;
-- 2. Queremos conocer a todos los clientes que tengan un título “Owner”.
select Contacto, Compania, Titulo, Pais 
from clientes
where Titulo like "%Owner%";
-- 3. El operador telefónico que atendió a un cliente no recuerda su nombre.
-- Solo sabe que comienza con “C”. ¿Lo ayudamos a obtener un listado con
-- todos los contactos que inician con la letra “C”?
select Contacto, Compania, Titulo, Pais 
from clientes
where Contacto like "C%";

-- Facturas 
-- 1. Obtener un listado de todas las facturas, ordenado por fecha de factura
-- ascendente.
select * from facturas
order by FechaFactura asc;
-- 2. Ahora se requiere un listado de las facturas con el país de envío “USA” y
-- que su correo (EnvioVia) sea distinto de 3.
select * from facturas
where PaisEnvio like "USA"
and EnvioVia != 3;
-- 3. ¿El cliente 'GOURL' realizó algún pedido?
select * from facturas
where ClienteID = 'GOURL';
-- 4. Se quiere visualizar todas las facturas de los empleados 2, 3, 5, 8 y 9.
select * from facturas
where EmpleadoID = 2 
or EmpleadoID = 3 
or EmpleadoID = 5 
or EmpleadoID = 8 
or EmpleadoID = 9
order by EmpleadoID asc;

-- Productos
-- 1. Obtener el listado de todos los productos ordenados
-- descendentemente por precio unitario.
select ProductoNombre, PrecioUnitario from productos
order by PrecioUnitario desc;
-- 2. Obtener el listado de top 5 de productos cuyo precio unitario es
-- el más caro.
select ProductoNombre, PrecioUnitario from productos
order by PrecioUnitario desc
limit 5;
-- 3. Obtener un top 10 de los productos con más unidades en stock.
select ProductoNombre, UnidadesStock from productos
order by UnidadesStock desc
limit 10;

-- FacturaDetalle
-- 1. Obtener un listado de FacturaID, Producto, Cantidad.
select FacturaID, ProductoID, Cantidad from facturadetalle; 
-- 2. Ordenar el listado anterior por cantidad descendentemente.
select FacturaID, ProductoID, Cantidad from facturadetalle
order by Cantidad desc; 
-- 3. Filtrar el listado solo para aquellos productos donde la cantidad
-- se encuentre entre 50 y 100.
select FacturaID, ProductoID, Cantidad from facturadetalle
where Cantidad between 50 and 100
order by Cantidad desc; 
-- 4. En otro listado nuevo, obtener un listado con los siguientes
-- nombres de columnas: NroFactura (FacturaID), Producto
-- (ProductoID), Total (PrecioUnitario*Cantidad).
select FacturaID, ProductoID, PrecioUnitario * Cantidad as total
from facturadetalle; 

-- ¿Te sobró tiempo? ¿Querés seguir practicando?
-- Te dejamos unos ejercicios extras a partir de la misma base:

-- 1. Obtener un listado de todos los clientes que viven en “Brazil" o “Mexico”,
-- o que tengan un título que empiece con “Sales”.
select titulo, pais from clientes
where pais = 'Brazil'
or pais = 'Mexico'
or Titulo like 'Sales%';
-- 2. Obtener un listado de todos los clientes que pertenecen a una compañía
-- que empiece con la letra "A".
select * from clientes
where Contacto like 'A%';
-- 3. Obtener un listado con los datos: Ciudad, Contacto y renombrarlo
-- como Apellido y Nombre, Titulo y renombrarlo como Puesto, de todos
-- los clientes que sean de la ciudad "Madrid".
select Ciudad, Contacto as "Apellido y Nombre",
Titulo as "Puesto" from clientes
where Ciudad = "Madrid";
-- 4. Obtener un listado de todas las facturas con ID entre 10000 y 10500
select * from facturas
where FacturaID between 10000 and 10500
order by FacturaID;
-- 5. Obtener un listado de todas las facturas con ID entre 10000 y 10500 o de
-- los clientes con ID que empiecen con la letra “B”.
select * from facturas
where FacturaID between 10000 and 10500
or ClienteID like "B%"
order by ClienteID;
-- 6. ¿Existen facturas que la ciudad de envío sea “Vancouver” o que
-- utilicen el correo 3?
select * from facturas
where CiudadEnvio = "Vancouver"
or ClienteID = 3
order by ClienteID;
-- 7. ¿Cuál es el ID de empleado de “Buchanan”?
select EmpleadoID from empleados
where Apellido = "Buchanan";
-- 8. ¿Existen facturas con EmpleadoID del empleado del ejercicio anterior?
-- (No relacionar, sino verificar que existan facturas)
select * from facturas
where EmpleadoID = 5;
