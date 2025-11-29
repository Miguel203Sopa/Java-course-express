/*Practica.5 Guia-6*/

--A igual lado izquierdo
--B igual lado derecho


--JOINS
--INNER JOIN 
/*Se utiliza para mostrar datos coincidentes entre 2 tablas
	SELECT <lista_campos>
	FROM <TablaA A>
	INNER JOIN <TablaB B>
	ON A.Key=B.Key
*/

SELECT OrderID, P.ProductID, ProductName 
FROM Products P
INNER JOIN [Order Details] OD
ON P.ProductID =OD.ProductID

--la primera linea extrae los campos que se mostraran
SELECT LastName, Employees.EmployeeID,OrderDate FROM Orders  
--la segunda hace el inner join usando como base la tabla que tiene como
--llave primaria el campo especificado
INNER JOIN Employees 
--despues se unen ambas tablas por el campo especificado 
ON Orders.EmployeeID=Employees.EmployeeID
--se ordenan por ID
ORDER BY Employees.EmployeeID

/*Nota: al campo EmployeeID se le coloca el nombre de la tabla de donde queremos sacar los resultados, ya
que el nombre de este campo aparece tanto en la tabla Orders y Employees, y si no se utiliza así da error de
nombre ambiguo.     */


--LEFT JOIN Muestra los registros de la tabla izquierda mas los registros 
--coincidentes en la tabla derecha

/*SELECT <lista_campos>
FROM <TablaA A> 
LEFT JOIN <TablaB B>
ON A.Key=B.Key*/

--A igual lado izquierdo
--B igual lado derecho

SELECT OrderID, E.EmployeeID, Lastname
FROM Employees E 
LEFT JOIN Orders O 
ON E.EmployeeID=O.EmployeeID


--LEFT JOIN (IS NULL)
/*
SELECT <lista_campos>
FROM <TablaA A>
LEFT JOIN <TablaB B>
ON A.Key=B.Key
WHERE B.Key IS NULL
*/

SELECT OrderID, E.EmployeeID,Lastname
FROM Employees E
LEFT JOIN Orders O
ON E.EmployeeID=O.EmployeeID
WHERE O.EmployeeID IS NULL


--RIGHT JOIN
/*
SELECT <lista_campos>
FROM <TablaA A>
RIGHT JOIN <TablaB B>
ON A.Key=B.Key
*/

SELECT ProductName, CompanyName, ContactName 
FROM Products P
RIGHT JOIN Suppliers S
ON P.SupplierID=S.SupplierID 

--RIGHT JOIN  (IS NULL)
/*
SELECT <lista_campos>
FROM <TablaA A>
RIGHT JOIN <TablaB B>
ON A.Key=B.Key
WHERE A.Key IS NULL
*/

SELECT ProductName, CompanyName, ContactName
FROM Products P
RIGHT JOIN Suppliers S
ON P.SupplierID=S.SupplierID
WHERE P.SupplierID IS NULL

--FULL JOIN Muestra los registros de ambas tablas en una tanto los datos coincidentes
--como los no coincidentes

/*SELECT <lista_campos>
FROM <TablaA A>
FULL JOIN <TablaB B>
ON A.Key=B.Key*/

SELECT ProductName,CompanyName,ContactName 
FROM Products P 
FULL JOIN Suppliers S
ON P.SupplierID=S.SupplierID;

--FULL JOIN (IS NULL) Muestra todos los datos menos los coincidentes
--entre ambas tablas

/*
SELECT <lista_campos>
FROM <TablaA A>
FULL JOIN <TablaB B>
ON A.Key=B.Key
WHERE A.Key IS NULL OR B.Key IS
NULL
*/

SELECT ProductName, CompanyName, ContactName 
FROM Products P
FULL JOIN Suppliers S
ON P.SupplierID=S.SupplierID
WHERE P.SupplierID IS NULL OR S.SupplierID IS NULL

--CROSS JOIN es una combinacion cruzada que no tenga una clusula WHERE
--genera el producto cartesiano de las tablas involucradas en la combinacion 
--El tamaño del conjunto de resultados de un producto cartesiano es igual al número de filas de la primera
--tabla multiplicado por el número de filas de la segunda tabla.
SELECT ProductName,CompanyName,ContactName 
FROM Products P
CROSS JOIN Suppliers S