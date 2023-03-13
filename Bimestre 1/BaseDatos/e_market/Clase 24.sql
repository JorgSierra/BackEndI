DELIMITER $$
-- 1) Cálculo de edad 
-- a) Crear un SP que muestre apellidos, nombres y edad de cada empleado, debe calcular la edad de los empleados 
-- a partir de la fecha de nacimiento y que tengan entre n y n años de edad. 
CREATE PROCEDURE sp_empleados (IN ENTRE INT, IN HASTA INT)
BEGIN
	SELECT apellido, nombre, timestampdiff(YEAR, FechaNacimiento, NOW()) Edad
    from empleados
    having Edad between ENTRE and HASTA;
END $$

call sp_empleados (1, 100) $$
-- b) Ejecutar el SP indicando un rango de edad entre 50 y 60 años de edad. 
call sp_empleados (50, 60) $$

-- 2) Actualización de productos 
-- a) Crear un SP que reciba un porcentaje y un nombre de categoría y actualice los productos pertenecientes a esa categoría,
--  incrementando las unidades pedidas según el porcentaje indicado. 
-- Por ejemplo: si un producto de la categoría Seafood tiene 30 unidades pedidas, 
-- al invocar el SP con categoría Seafood y porcentaje 10%, 
-- el SP actualizará el valor de unidades pedidas con el nuevo valor 33. 
DELIMITER $$
CREATE PROCEDURE sp_actualizaPedidos (IN porcentaje INT, IN categoria varchar(15))
BEGIN
	update productos p
    join categorias c on c.CategoriaID = p.CategoriaID
    set p.UnidadesPedidas = p.UnidadesPedidas + (p.UnidadesPedidas / 100 * porcentaje) 
    where c.CategoriaNombre = categoria; 
END $$

DROP PROCEDURE  sp_empleados $$

call sp_empleados (10, "Condiments") $$

select p.ProductoNombre, p.UnidadesPedidas, c.CategoriaNombre 
from productos p join categorias c on c.CategoriaID = p.CategoriaID 
where c.CategoriaNombre = "Condiments" $$

-- b) Listar los productos de la categoría Beverages para ver cuántas unidades pedidas hay de cada uno de ellos. 
select p.ProductoNombre, p.UnidadesPedidas, c.CategoriaNombre 
from productos p join categorias c on c.CategoriaID = p.CategoriaID 
where c.CategoriaNombre = "Beverages" $$

-- c) Invocar al SP con los valores Beverages como categoría y 15 como porcentaje. 
call sp_empleados (15, "Beverages") $$

-- d) Volver a listar los productos como en (a), y validar los resultados. 
select p.ProductoNombre, p.UnidadesPedidas, c.CategoriaNombre 
from productos p join categorias c on c.CategoriaID = p.CategoriaID 
where c.CategoriaNombre = "Beverages" $$


-- 3) Actualización de empleados 
-- a) Crear un SP que cree una tabla con los nombres, 
-- apellidos y teléfono de contacto de todos los empleados que hayan sido 
-- contratados con fecha anterior a una fecha dada. 
DELIMITER $$
CREATE PROCEDURE sp_empleadosContratados (IN HASTA DATE)
BEGIN
	SELECT apellido, nombre, Telefono
    from empleados
    WHERE FechaContratacion < HASTA;
END $$

call sp_empleadosContratados("1998-01-01") $$

-- b) Ejecutar el SP para generar una tabla de empleados con fecha de contratación anterior a 01/01/1994. 
call sp_empleadosContratados("1994-01-01") $$
-- c) Consultar la tabla generada y validar los resultados. 
select FechaContratacion from empleados $$
