
/*Comandos:*/

--SELECT [Lista_de_campos] 
--FROM [nombre_tabla]
/*
[ WHERE condicion_individual]
[ GROUP BY campos_a_agrupar ]
[ HAVING condicion_grupo ]
[ ORDER BY campo_a_ordenar [ ASC | DESC ] ] 
ASC:ascendente
DESC:descendente
*/

--USE Northwind

--SELECT selecciona tablas, campos y filas
SELECT * FROM Products--todos los campos de tabla productos
SELECT ProductID, ProductName,UnitPrice FROM Products --los campos especificados de tabla productos

--WHERE Selecciona solo filas que cumplan con una condicion especificada
SELECT ProductID, ProductName, UnitPrice
FROM Products	
WHERE UnitPrice > 15

--se pueden poner mas condiciones usando OR y AND o hasta BETWEEN
SELECT ProductID, ProductName, UnitPrice 
FROM Products  
WHERE UnitPrice >=15 AND UnitPrice <= 50

--esto es lo mismo que lo anterior pero usando la palabra especial BETWEEN
SELECT ProductID, ProductName, UnitPrice 
FROM Products  
WHERE UnitPrice BETWEEN 15 AND 50

--La palabra especial NOT invierte la condicion en este caso te dara los valores
--menores a 15
SELECT ProductID, ProductName, UnitPrice 
FROM Products 
WHERE NOT UnitPrice > 15;

--LIKE funciona para preguntar si algo es igual a algo como un "=="
/*
Comodines
_:Cualquier caracter  _0913 que termine,  0031_ que empiece
%:Cualquier cadena de cero o mas caracteres
[]:Cualquier caracter individual del intervalo [a-z][A-Z][a-Z]
NOT LIKE, basicamente que sea diferente de, pero con cadenas
*/

SELECT EmployeeID, LastName from Employees
WHERE LastName LIKE 'D%' --que tenga la letra D

SELECT EmployeeID, LastName, Title FROM Employees
WHERE Title LIKE '%SALES%' --Que tenga la palabra SALES

SELECT OrderID FROM [Order Details]
WHERE OrderID LIKE '_0248'

SELECT OrderID FROM [Order Details]
WHERE OrderID LIKE '10[1-5]45'
--Lo que esta entre parentesis es una condicion
--para un solo caracter
--en este caso un numero entre 1 y 5

SELECT ProductID,ProductName,UnitPrice 
FROM Products
ORDER BY ProductID ASC

SELECT ProductID,ProductName,UnitPrice 
FROM Products
ORDER BY ProductID DESC

SELECT DISTINCT OrderID FROM [Order Details]
--DISTINCT Selecciona todos los registros no repetidos almacenados 
--en el campo OrderID de la tabla ORDER DETAILS

--TOP N especifica que solo se mostrara el primer conjunto de filas del resultado
--de la consulta
--El conjunto de filas puede ser un numero o un porcentaje de las filas
-- (TOP nPERCENT)

--TOP n WITH TIES: Esta clausula permite incluir en la seleccion, todos los 
--registros que tengan el mismo valor del campo por el que se ordena

SELECT TOP 5 OrderID, ProductID, Quantity
FROM [Order Details] 
--muestra los primeros 5 registros

SELECT TOP 2 WITH TIES OrderID, ProductID, Quantity
FROM [Order Details] 
--muestra los primeros 5 registros
--llama los primeros 2 registros pero si existen uno o mas registros
--con el mismo dato almacenado los llama tambien

SELECT TOP 10 PERCENT  OrderID, ProductID, Quantity
FROM [Order Details] 
--Llama al 10% de los datos

--Renombrar columnas

SELECT CategoryName AS CateName FROM Categories
--por medio de AS  puedes renombrar columnas
-- NombreOriginal AS NombreNuevo

SELECT OrderId, OrderDate, ShippedDate, ShippedDate +5 AS RetrasoEnvio
FROM Orders  
--esto muestra los valores de 3 columnas con la condicion de que haya 
--un retraso de 5 dias y que se muestren en una columna llamada RetrsaoEnvio

