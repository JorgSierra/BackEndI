-- Where
-- 1. Mostrar los nombre de los productos que tengan cualquier combinación de
-- ‘mountain bike’
-- Tablas: Product
-- Campos: Name
select p.Name
from product p
where p.name like "%mountain%bike%"
or p.name like "%bike%mountain%"; 

-- 2. Mostrar las personas cuyo nombre empiece con la letra “y”
-- Tablas: Contact
-- Campos: FirstName
select FirstName
from contact
where FirstName like "y%";

-- Order by
-- 1. Mostrar cinco productos más caros y su nombre ordenado en forma alfabética
-- Tablas: Product
-- Campos: Name, ListPrice
select Name, ListPrice
from product
order by ListPrice desc, name asc
limit 5;

-- Operadores & joins
-- 1. Mostrar el nombre concatenado con el apellido de las personas cuyo apellido sea
-- johnson
-- Tablas: Contact
-- Campos: FirstName, LastName
select concat(FirstName, " ", LastName) " H o l a"
from Contact
where LastName like "johnson"; 

-- 2. Mostrar todos los productos cuyo precio sea inferior a 150$ de color rojo o cuyo
-- precio sea mayor a 500$ de color negro
-- Tablas: Product
-- Campos: ListPrice, Color
select *
from product
where ListPrice < 150 and Color = "Red"
or ListPrice > 500 and Color = "Black";


-- Funciones de agregación
-- 1. Mostrar la fecha más reciente de venta
-- Tablas: SalesOrderHeader
-- Campos: OrderDate
select OrderDate
from SalesOrderHeader
order by OrderDate desc
limit 1;

-- 2. Mostrar el precio más barato de todas las bicicletas
-- Tablas: Product
-- Campos: ListPrice, Name
select p.ListPrice, p.Name
from product p
join productsubcategory ps on ps.ProductsubcategoryID = p.ProductsubcategoryID
join productcategory pc on pc.productcategoryid = ps.productcategoryid
where pc.name = "Bikes"
order by p.ListPrice asc
limit 1;

-- 1. Mostrar los productos y la cantidad total vendida de cada uno de ellos
-- Tablas: SalesOrderDetail
-- Campos: ProductID, OrderQty
select p.name, sum(s.OrderQty) Cantidad
from salesOrderDetail s
join product p on p.productid = s.productid
group by p.productid;

-- 1. Mostrar la cantidad de facturas que vendieron más de 20 unidades.
-- Tablas: Sales.SalesOrderDetail
-- Campos: SalesOrderID, OrderQty
select s.salesorderid, sum(s.OrderQty) CantidadUnidades, count(*) CantidadProductos
from salesOrderDetail s
join product p on p.productid = s.productid
group by s.salesorderid
having CantidadUnidades > 20;


-- 1. Mostrar el código de logueo, número de territorio y sueldo básico de los
-- vendedores
-- Tablas: Employee, SalesPerson
-- Campos: LoginID, TerritoryID, Bonus, BusinessEntityID


-- 2. Mostrar los productos que sean ruedas
-- Tablas: Product, ProductSubcategory
-- Campos: Name, ProductSubcategoryID


-- 3. Mostrar los nombres de los productos que no son bicicletas
-- Tablas: Product, ProductSubcategory
-- Campos: Name, ProductSubcategoryID