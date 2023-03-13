-- Caso de estudio: AdventureWorks I (Resolución)
-- Base de datos: AdventureWorks

-- WHERE
-- 1. Mostrar el nombre, precio y color de los accesorios para asientos de las bicicletas cuyo precio sea mayor a 100 pesos
-- Tablas: Product
-- Campos: Name, ListPrice, Color
SELECT Name, ListPrice AS Precio, Color FROM Product
WHERE ListPrice > 100;

-- OPERADORES & JOINS
-- 1. Mostrar los empleados que tienen más de 90 horas de vacaciones
-- Tablas: Employee
-- Campos: VacationHours
SELECT SUM(VacationHours) AS VacationHours FROM Employee
GROUP BY title
HAVING VacationHours > 90;

-- 2. Mostrar el nombre, precio y precio con iva (21%) de los productos con precio distinto de cero
-- Tablas: Product
-- Campos: Name, ListPrice
SELECT Name, ListPrice AS Precio, (ListPrice*1.21) AS PrecioConIva FROM Product
WHERE ListPrice != 0;

-- 3. Mostrar precio y nombre de los productos 776, 777, 778
-- Tablas: Product
-- Campos: ProductID, Name, ListPrice
SELECT ProductID, Name, ListPrice FROM Product
WHERE ProductID BETWEEN 776 AND 778;


-- ORDER BY
-- 1. Mostrar las personas ordenadas primero por su apellido y luego por su nombre
-- Tablas: Contact
-- Campos: Firstname, Lastname
SELECT Firstname, Lastname FROM Contact
ORDER BY LastName, FirstName;


-- FUNCIONES DE AGREGACIÓN
-- 1. Mostrar la cantidad y el total vendido por productos
-- Tablas: SalesOrderDetail
-- Campos: LineTotal
SELECT SalesOrderID, COUNT(SalesOrderID) AS Cantidad, SUM(LineTotal) AS Total FROM SalesOrderDetail
GROUP BY ProductID;

-- GROUP BY
-- 1. Mostrar el código de subcategoría y el precio del producto más barato de cada una de ellas
-- Tablas: Product
-- Campos: ProductSubcategoryID, ListPrice
SELECT ProductSubcategoryID, ListPrice FROM Product
GROUP BY ProductSubcategoryID
ORDER BY ListPrice DESC
LIMIT 1;

-- HAVING
-- 1. Mostrar todas las facturas realizadas y el total facturado de cada una de ellas ordenado por número de factura pero sólo de aquellas órdenes que superen un total de $10.000
-- Tablas: SalesOrderDetail
-- Campos: SalesOrderID, LineTotal
SELECT SalesOrderID, SUM(LineTotal) AS Total FROM SalesOrderDetail
GROUP BY SalesOrderID
HAVING Total > 10000
ORDER BY SalesOrderID;

-- JOINS
-- 1. Mostrar los empleados que también son vendedores
-- Tablas: Employee, SalesPerson
-- Campos: EmployeeID
SELECT EmployeeID FROM Employee e
INNER JOIN SalesPerson s ON s.SalesPersonID = e.ManagerID;

-- 2. Mostrar los empleados ordenados alfabéticamente por apellido y por nombre
-- Tablas: Employee, Contact
-- Campos: BusinessEntityID, LastName, FirstName
SELECT LastName, FirstName FROM Employee e
INNER JOIN Contact c ON c.ContactID = e.ContactID
ORDER BY LastName, FirstName;