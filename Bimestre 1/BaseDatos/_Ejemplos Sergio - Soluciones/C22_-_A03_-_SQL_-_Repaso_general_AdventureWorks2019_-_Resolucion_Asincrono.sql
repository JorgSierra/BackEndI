-- Actividad: Repaso General - AdventureWorks
-- Base de datos:  AdventureWorks
-- Base de datos: muestra_basica_extra.sql
SET sql_mode = 'ONLY_FULL_GROUP_BY'; -- Esto permitirá detectar errores en la declaración de campos propios en las consultas agrupadas.

-- WHERE --------------------------------------------------------------------------------------
-- 1. Mostrar las personas que la segunda letra de su apellido es una s.
-- Tablas: person
-- Campos: LastName
SELECT LastName FROM person 
WHERE LastName LIKE '_s%';

-- 2. Mostrar el nombre concatenado con el apellido de las personas cuyo apellido tengan terminación (ez).
-- Tablas: person
-- Campos: FirstName, LastName
SELECT CONCAT(FirstName, ' ', LastName) AS Persona FROM person
WHERE LastName LIKE '%ez';

-- 3. Mostrar los nombres de los productos que terminen en un número.
-- Tablas: product
-- Campos: Name
SELECT Name FROM product 
WHERE Name AND Name LIKE '%0' AND Name LIKE '%1'
AND Name LIKE '%2' AND Name LIKE '%3'
AND Name LIKE '%4' AND Name LIKE '%5'
AND Name LIKE '%6' AND Name LIKE '%7'
AND Name LIKE '%8' AND Name LIKE '%9';
-- Solución alternativa con REGEXP
SELECT Name FROM product WHERE Name REGEXP '[0-9].';

-- 4. Mostrar las personas cuyo nombre tenga una "c" como primer carácter, cualquier otro como segundo carácter, 
-- ni d, e, f, g como tercer carácter, cualquiera entre j y r o entre s y w como cuarto carácter y el resto sin restricciones.
-- Tablas: person
-- Campos: FirstName
SELECT FirstName FROM person 
WHERE FirstName LIKE 'c_%' 
AND FirstName NOT LIKE '__d%' 
AND FirstName NOT LIKE '__e%' 
AND FirstName NOT LIKE '__f%' 
AND FirstName NOT LIKE '__g%';


-- BETWEEN ------------------------------------------------------------------------------------
-- 1. Mostrar todos los productos cuyo precio de lista esté entre 240 y 305.
-- Tablas: product
-- Campos: ListPrice
SELECT * FROM product 
WHERE ListPrice BETWEEN 240 AND 305;

-- 2. Mostrar todos los empleados que nacieron entre 1977 y 1981.
-- Tablas: employee
-- Campos: BirthDate
SELECT * FROM employee 
WHERE YEAR(BirthDate) BETWEEN 1977 AND 1981;

-- OPERADORES ---------------------------------------------------------------------------------
-- 1. Mostrar el código, fecha de ingreso y horas de vacaciones de los empleados que ingresaron a partir del año 2010.
-- Tablas: employee
-- Campos: BusinessEntityID, HireDate, VacationHours
SELECT BusinessEntityID, HireDate, VacationHours FROM employee 
WHERE YEAR(HireDate) >= 2010;

-- 2. Mostrar el nombre, número de producto, precio de lista y el precio de lista incrementado en un 10% de los productos
-- cuya fecha de fin de venta sea anterior al día de hoy.
-- Tablas: product
-- Campos: Name, ProductNumber, ListPrice, SellEndDate
SELECT Name, ProductNumber, ListPrice, (ListPrice + ((ListPrice/100) * 10)) AS precioIncrementado, SellEndDate FROM product 
WHERE SellEndDate < NOW();


-- CONSULTAS CON "NULL" -----------------------------------------------------------------------
-- 1. Mostrar los representantes de ventas (vendedores) que no tienen definido el número de territorio.
-- Tablas: salesperson
-- Campos: TerritoryID, BusinessEntityID
SELECT TerritoryID, BusinessEntityID FROM salesperson 
WHERE TerritoryID IS NULL;

-- 2. Mostrar el peso de todos los artículos. Si el peso no estuviese definido, reemplazar por cero.
-- Tablas: product
-- Campos: Weight
SELECT COALESCE(Weight, '0') AS Peso FROM product;

-- FUNCIONES DE AGREGACION --------------------------------------------------------------------
-- 1. Mostrar solamente la fecha de nacimiento del empleado más joven.
-- Tablas: employee
-- Campos: BirthDate
SELECT MAX(BirthDate) AS FechaNacimiento FROM employee; 

-- 2. Mostrar el promedio de la lista de precios de productos con 2 dígitos despues de la coma. Además, agregar el signo $.
-- Tablas: product
-- Campos: ListPrice
SELECT CONCAT("$", ROUND( AVG(ListPrice), 2)) AS Promedio FROM product;


-- GROUP BY -----------------------------------------------------------------------------------
-- 1. Mostrar los productos y la suma total vendida de cada uno de ellos, ordenados ascendentemente por el total vendido.
-- Redondear el total para abajo.
-- Tablas: salesorderdetail
-- Campos: ProductID, LineTotal
SELECT ProductID, FLOOR( SUM(LineTotal)) AS CantidadVendida FROM salesorderdetail
GROUP BY ProductID
ORDER BY CantidadVendida;

-- 2. Mostrar el promedio vendido por factura.
-- Tablas: salesorderdetail
-- Campos: SalesOrderID, LineTotal
SELECT SalesOrderID, AVG(LineTotal) FROM salesorderdetail
GROUP BY SalesOrderID;

-- HAVING -------------------------------------------------------------------------------------
-- 1. Mostrar las subcategorías de los productos que tienen cuatro o más productos que cuestan menos de $150.
-- Tablas: product
-- Campos: ProductSubcategoryID, ListPrice
SELECT ProductSubcategoryID, COUNT(ProductSubcategoryID) AS CantidadProducto FROM product
WHERE ListPrice < 150
GROUP BY ProductSubcategoryID
HAVING CantidadProducto >= 4;

-- 2. Mostrar todos los códigos de subcategorías existentes junto con la cantidad de productos cuyo precio de lista
-- sea mayor a $ 70 y el precio promedio sea mayor a $700.
-- Tablas: product
-- Campos: ProductSubcategoryID, ListPrice
SELECT ProductSubcategoryID, COUNT(ProductID) AS cantidad, AVG(ListPrice) AS PrecioPromedio FROM product
WHERE ListPrice > 70
GROUP BY ProductSubcategoryID
HAVING PrecioPromedio > 700;

-- JOINS --------------------------------------------------------------------------------------
-- 1. Mostrar los precios de venta de aquellos productos donde el precio de venta sea inferior al precio de lista
-- recomendado para ese producto ordenados por nombre de producto.
-- Tablas: salesorderdetail, product
-- Campos: ProductID, Name, ListPrice, UnitPrice
SELECT p.ProductID, p.Name, p.ListPrice, sod.UnitPrice FROM product p
INNER JOIN salesorderdetail sod ON p.ProductID = sod.ProductID
WHERE sod.UnitPrice < p.ListPrice
ORDER BY p.Name;

-- 2. Mostrar todos los productos que tengan el mismo precio (precio de venta y precio de lista) y que tengan un color
-- asignado (no nulo). Se deben mostrar de a pares, código y nombre de cada uno de los dos productos y el precio de ambos.
-- Ordenar por precio de venta en forma descendente.
-- Tablas: product, salesorderdetail
-- Campos: ProductID, Name, ListPrice, UnitPrice, Color
SELECT p.ProductID, p.Name, p.ListPrice, sod.UnitPrice, Color FROM product p
INNER JOIN salesorderdetail sod ON p.ProductID = sod.ProductID
WHERE sod.UnitPrice = p.ListPrice AND Color IS NOT NULL
ORDER BY sod.UnitPrice DESC;

-- 3. Mostrar el nombre de los productos y el nombre de los proveedores cuya subcategoría es 15.
-- Tablas: product, productVendor, vendor
-- Campos: Name, ProductID, BusinessEntityID, ProductSubcategoryID
SELECT p.Name, v.Name, p.ProductID, v.BusinessEntityID, p.ProductSubcategoryID FROM product p
INNER JOIN productvendor pv ON p.ProductID = pv.ProductID
INNER JOIN vendor v ON pv.BusinessEntityID = v.BusinessEntityID
WHERE p.ProductSubcategoryID = 15;

-- 4. Mostrar todas las personas (nombre y apellido) y en el caso que sean empleados mostrar también el login id,
-- además, mostrar solo aquellos que tienen un Id de territorio 1, 4, 7 y 10.
-- Tablas: employee, person, salesperson
-- Campos: FirstName, LastName, LoginID, BusinessEntityID, TerritoryID
SELECT p.FirstName, p.LastName, e.LoginID, e.BusinessEntityID, TerritoryID FROM employee e
INNER JOIN person p ON e.BusinessEntityID = p.BusinessEntityID
INNER JOIN salesperson sp ON p.BusinessEntityID = sp.BusinessEntityID
WHERE sp.TerritoryID IN(1, 4, 7, 10);