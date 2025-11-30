--PROCEDIMIENTOS ALMACENADOS
CREATE PROCEDURE ObtenerNombre @cliente_id nchar(5) AS
SELECT ContactName 
FROM Customers WHERE CustomerID =@cliente_id 
GO


--parametros por referencia
CREATE PROCEDURE num_productos @productos int OUTPUT AS
SELECT *FROM Products 
Select @productos = @@ROWCOUNT
RETURN (0)
GO



DECLARE @productos int
EXEC num_productos @productos OUTPUT 
SELECT [Total de productos] = @productos



DROP PROCEDURE num_productos 

EXEC ObtenerNombre 'ALFKI'
EXEC ObtenerNombre @cliente_id='ALFKI'