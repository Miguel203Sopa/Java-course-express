/*Subconsultas*/

/*
SELECT <lista de seleccion>
FROM <Alguna Tabla>
WHERE <Alguna Columna> [IN | EXISTS |ANY | ALL] (SELECT <columna>
FROM <Alguna Tabla>
[WHERE <condición>]
) 

*/
--Subconsultas de seleccion y busqueda
SELECT ProductID,ProductName,UnitPrice 
FROM Products  
WHERE ProductID IN (SELECT productID
					FROM [Order Details]
					WHERE Quantity >=100)
ORDER BY ProductName

--exists 

SELECT ProductID, ProductName, UnitPrice 
FROM Products  
WHERE EXISTS (SELECT ProductID FROM [Order Details]
			WHERE Quantity >= 100
			AND Products.ProductID=[Order Details].ProductID)
ORDER BY ProductID

SELECT ProductID, ProductName, UnitPrice 
FROM Products 
WHERE EXISTS (SELECT * FROM [Order Details] 
			WHERE Quantity>=100
			AND Products.ProductID=[Order Details].ProductID)
ORDER BY ProductID

--UPDATE
UPDATE Products SET UnitPrice=UnitPrice*1.2
WHERE CategoryID IN (SELECT CategoryID FROM Categories 
					WHERE CategoryName LIKE 'B%')

--DELETE 
DELETE Customers WHERE
CustomerID IN (SELECT CustomerID FROM Orders
				WHERE OrderDate > '2014-01-01dir')
