DELIMITER $$
-- ****************************** Stored Procedures Parte II ******************************
-- 1) Cálculo de edad 
-- a) Crear un SP que muestre apellidos, nombre y edad de los empleados, debe calcular la edad de los empleados
-- a partir de la fecha de nacimiento y que tengan entre n y n años de edad.
DROP PROCEDURE IF EXISTS sp_calcular_edad_empleado $$
CREATE PROCEDURE sp_calcular_edad_empleado(IN edad_min INT, IN edad_max INT)
BEGIN
	SELECT Apellido, Nombre, TIMESTAMPDIFF(YEAR,FechaNacimiento,CURDATE()) AS edad FROM empleados 
    WHERE TIMESTAMPDIFF(YEAR,FechaNacimiento,CURDATE()) BETWEEN edad_min AND edad_max;
END $$
-- b) Ejecutar el SP indicando un rango de edad entre 50 y 60 años de edad.
CALL sp_calcular_edad_empleado(50, 60) $$



-- 2) Actualización de Productos
-- a) Crear un SP que reciba un porcentaje y un nombre de categoría y actualice los productos pertenecientes a esa categoría,
-- incrementando las unidades pedidas según el porcentaje indicado. Por ejemplo: Si un producto de la categoría Seafood tiene 30 unidades
-- pedidas, al invocar el SP con categoría Seafood y porcentaje 10%, el SP actualizará el valor de unidades pedidas con el nuevo valor 33.
DROP PROCEDURE IF EXISTS sp_actualizar_demanda_x_porcentaje_categoria $$
CREATE PROCEDURE sp_actualizar_demanda_x_porcentaje_categoria(IN porcentaje INT, IN nom_categoria VARCHAR(30))
BEGIN
	DECLARE var_categoria INT $$
	SELECT CategoriaID INTO var_categoria FROM categorias WHERE CategoriaNombre = nom_categoria $$
    UPDATE productos SET UnidadesPedidas = UnidadesPedidas + (UnidadesPedidas / 100 * porcentaje) WHERE CategoriaID = var_categoria;
END $$
-- b) Listar los productos de la categoría Beverages para ver cuántas unidades pedidas hay de cada uno de ellos.
SELECT p.ProductoNombre, p.CategoriaID, p.UnidadesPedidas FROM productos AS p
INNER JOIN categorias AS c ON c.CategoriaID = p.CategoriaID WHERE c.CategoriaNombre = 'Beverages' $$
-- c) Invocar al SP con los valores Beverages como categoría y 15 como porcentaje.
CALL sp_actualizar_demanda_x_porcentaje_categoria(15, 'Beverages') $$
-- d) Volver a listar los productos como en (a), y validar los resultados.
SELECT p.ProductoNombre, p.CategoriaID, p.UnidadesPedidas FROM productos AS p
INNER JOIN categorias AS c ON c.CategoriaID = p.CategoriaID WHERE c.CategoriaNombre = 'Beverages' $$
-- Nota: corregir enunciado "como en (b)"

-- 3) Actualización de Empleados
-- a) Crear un SP que cree una tabla con los nombres, apellidos y teléfono de contacto de todos los empleados
-- que hayan sido contratados con fecha anterior a una fecha dada.
DROP PROCEDURE IF EXISTS sp_crear_tabla_empleado_x_fecha_contrato $$
CREATE PROCEDURE sp_crear_tabla_empleado_x_fecha_contrato(IN fecha DATE)
BEGIN
	DROP TABLE IF EXISTS empleado_tmp;
    CREATE TABLE empleado_tmp (
		EmpleadoID INT NOT NULL AUTO_INCREMENT,
		Nombre VARCHAR(20) NOT NULL,
		Apellido VARCHAR(10) NOT NULL,
		FechaContratacion DATETIME,
		PRIMARY KEY (EmpleadoID));
	INSERT INTO empleado_tmp SELECT EmpleadoID, Nombre, Apellido, FechaContratacion FROM empleados WHERE FechaContratacion <= fecha;
END $$
-- b) Ejecutar el SP para generar una tabla de empleados con fecha de contratación anterior a 01/01/1994.
CALL sp_crear_tabla_empleado_x_fecha_contrato('1994-01-01') $$
-- c) Consultar la tabla generada y validar los resultados.
SELECT * FROM empleado_tmp $$