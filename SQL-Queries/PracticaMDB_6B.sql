--VISTAS

/*SINTAXIS:
CREATE VIEW nombreVista [(columna [,n ])] [WITH {ENCRYPTION | SCHEMABINDING | VIEW_METADATA} [,n
]] AS instrucciónSelect
[WITH CHECK OPTION*/

CREATE VIEW dbo.OrderSubtotalView (OrderID,Subtotal)
AS
SELECT OD.OrderID,
SUM(CONVERT(money,(OD.UnitPrice*Quantity*(1-Discount)/100)*100))
FROM [Order Details] OD
GROUP BY OD.OrderID 
GO

--En las vistas no puedes usar:
--ORDER BY 
--INTO 

CREATE VIEW dbo.ShipStatusView
AS
SELECT OrderID,ShippedDate,ContactName 
FROM Customers c INNER JOIN Orders O  -- remember left is first and right is last 
ON C.CustomerID=O.CustomerID
WHERE RequiredDate<ShippedDate
GO

--Modificacion y Eliminacion de Vistas 
--ALTER VIEW

--Modificacion:
ALTER VIEW dbo.ShipStatusView
AS
	SELECT OrderID, ShippedDate, ContactName, CompanyName 
	FROM Customers C INNER JOIN Orders O 
	ON C.CustomerID=O.CustomerID
	WHERE RequiredDate <ShippedDate
GO


--Eliminar vistas
DROP VIEW dbo.ShipStatusView 