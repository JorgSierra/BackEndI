DELIMITER $$
-- ****************************** Stored Procedures - e-Market ******************************
-- 1) Empleados
-- a) Crear un SP que liste los apellidos y nombres de los empelados ordenados alfabéticamente.
DROP PROCEDURE IF EXISTS sp_listar_correo $$
CREATE PROCEDURE sp_listar_correo()
BEGIN	
     SELECT Apellido, Nombre FROM empleados order by Apellido;
END $$
-- b) Invocar el SP para verificar el resultado.
CALL sp_listar_correo()$$

-- 2) Empleados por ciudad
-- a) Crear un SP que reciba el nombre de una ciudad y liste los empleados de esa ciudad.
DROP PROCEDURE IF EXISTS sp_listar_ciudad_x_empleado $$
CREATE PROCEDURE sp_listar_ciudad_x_empleado(IN nom_ciudad VARCHAR(30))
BEGIN	
     SELECT Ciudad, apellido, nombre FROM empleados WHERE Ciudad = nom_ciudad;
END $$
-- b) Invocar al SP para listar los empleados de Seattle.
CALL sp_listar_ciudad_x_empleado('London') $$

-- 3) Clientes por país
-- a) Crear un SP que reciba el nombre de un país y devuelva la cantidad de clientes en ese país.
DROP PROCEDURE IF EXISTS sp_contar_cliente_x_pais $$
CREATE PROCEDURE sp_contar_cliente_x_pais(IN nom_pais VARCHAR(30), OUT cant_pais INT)
BEGIN	
     SELECT count(ClienteId) INTO cant_pais FROM clientes WHERE Pais = nom_pais;
END $$
-- b) Invocar el SP para consultar la cantidad de clientes en Portugal.
CALL sp_contar_cliente_x_pais('Brazil',@cantidad) $$
SELECT @cantidad $$

-- 4) Productos sin Stock
-- a) Crear un SP que reciba un número y liste los productos cuyo stock está por debajo de ese número. 
-- El resultado debe mostrar el nombre del producto, el Stock actual, y el nombre de la categoría a la que pertenece el producto.
DROP PROCEDURE IF EXISTS sp_listar_producto_x_stock $$
CREATE PROCEDURE sp_listar_producto_x_stock(IN numero INT)
BEGIN	
     SELECT p.ProductoNombre, p.UnidadesStock, c.CategoriaNombre FROM productos AS p
     INNER JOIN categorias AS c ON c.CategoriaID = p.CategoriaID
     WHERE p.UnidadesStock < numero;
END $$
-- b) Listar los productos con menos de 10 unidades en stock.
CALL sp_listar_producto_x_stock(10) $$
-- c) Listar los productos sin stock.
CALL sp_listar_producto_x_stock(1) $$

-- 5) Ventas con descuento
-- a) Crear un SP que reciba un porcentaje y liste los nombres de los productos que hayan sido vendidos
-- con un descuento igual o superior al valor indicado, indicando además el nombre del cliente al que se lo vendió.
DROP PROCEDURE IF EXISTS sp_listar_producto_x_porcentaje $$
CREATE PROCEDURE sp_listar_producto_x_porcentaje(IN porcentaje INT)
BEGIN
	SELECT p.ProductoNombre,fd.Descuento, c.Compania, (fd.PrecioUnitario / 100 * porcentaje) AS Porcentaje FROM facturas AS f
	INNER JOIN clientes AS c ON c.ClienteID= f.ClienteID
	INNER JOIN facturadetalle AS fd ON fd.FacturaID = f.FacturaID
	INNER JOIN productos AS p ON p.ProductoId= fd.ProductoId
	WHERE fd.Descuento >= (fd.PrecioUnitario / 100 * porcentaje);
END $$
-- b) Listar la información de los productos que hayan sido vendidos con un descuento mayor al 10%.
CALL sp_listar_producto_x_porcentaje(10) $$
