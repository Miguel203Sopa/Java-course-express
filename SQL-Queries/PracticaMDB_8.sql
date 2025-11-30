
--CONVERT(Type of value, Value to convert )

CREATE PROCEDURE sp_Insertar_Categorias
@ID INT, 
@NombreCategoria VARCHAR(15)
AS
IF (SELECT COUNT(*) FROM Categories
	WHERE CategoryID=@ID OR CategoryName=@NombreCategoria)=0
	INSERT INTO Categories(CategoryName)
	VALUES (@NombreCategoria)
ELSE
	PRINT 'ERROR la categoria ya existe'
GO
-------------------------------------------------------------------------
CREATE PROCEDURE sp_Hay_Clientes
@ciudad varchar(15)
AS
SELECT
CASE ( SELECT COUNT(*) FROM Customers WHERE City=@ciudad)
WHEN 0 THEN 'No hay clientes de la ciudad de '+@ciudad
END 
GO
--------------------------------------------------------------------------
CREATE PROCEDURE Proc_Total 
AS
	SELECT OrderID,
	SUM(CONVERT (money,(UnitPrice*Quantity*(1-Discount)/100))*100)
	AS Total
	FROM [Order Details]
	GROUP BY OrderID
GO
---------------------------------------------------------------------------
CREATE PROCEDURE Mostrar_10_pedidos 
AS
DECLARE @contador int
DECLARE @num int 
SET @contador = 0

--obteniendo el primer valor del campo OrderID de la tabla Orders 
SET @num =(SELECT TOP 1 OrderID FROM Orders ORDER BY OrderID)

--Evalua si el contador es menor que 10, si la condicion se cumple realiza el SELECT
WHILE @Contador<10
BEGIN 
	SELECT OrderID,OrderDate FROM Orders WHERE OrderID=@num+@contador 
	--se incrementa
	SET @contador = @contador+1 
END
GO
---------------------------------------------------------------------------
CREATE PROCEDURE Actualizar_Precio 
AS
	WHILE (SELECT AVG(UnitPrice) FROM Products)<300
	BEGIN
		UPDATE Products 
		SET UnitPrice = UnitPrice*2
		SELECT MAX(UnitPrice) AS [Precio Maximo] FROM Products 
		IF (SELECT MAX(UnitPrice) FROM Products)<500
			BREAK
			--sale del bucle mas interno 
			--dentro del bucle WHILE
		ELSE
			CONTINUE
	END
	GO
---------------------------------------------------------------------------
CREATE PROCEDURE Mostrar_Clientes
	AS
		DECLARE @nombre NVARCHAR(40)
		DECLARE @cursor CURSOR
--se declara el cursor @cursor el cual se utilizara para recorrer cada resultado
-- de la consulta SELECT 

--Se Asigna el primer dato el cursor
		SET @cursor = CURSOR FOR 
		SELECT CompanyName FROM Customers
		OPEN @cursor
		FETCH NEXT
		FROM @cursor INTO @nombre 
		WHILE @@FETCH_STATUS = 0
		BEGIN
			PRINT 'El nombre del cliente es: '+ @nombre
			--se mueve al siguiente registro
			FETCH NEXT FROM @cursor INTO @nombre 
		END
		--EESTE COMANDO HACE DESAPARECER EL PUNTERO SOBRE EL REGISTRO ACTUAL
		CLOSE @cursor
		DEALLOCATE @cursor
		GO
---------------------------------------------------------------------------
ALTER PROCEDURE Proc_Total
@cod_orden int
AS
		SELECT OrderID,
		SUM(CONVERT(money,(UnitPrice*Quantity*(1-Discount)/100))*100)
	AS Total
	FROM [Order Details]
	WHERE OrderID=@cod_orden 
	GROUP BY OrderID 
GO

ALTER PROCEDURE Proc_Total
@cod_orden int
AS
	DECLARE @total INT --Declaracion de variables locales
	SELECT @total=COUNT(orderid)
		FROM[Order Details] 
		WHERE OrderID=@cod_orden 
		IF (@total>=1)
		BEGIN
		SELECT OD.OrderID,
		SUM(CONVERT(money,(OD.UnitPrice*Quantity*(1-Discount)/100))*100) AS Total
		FROM [Order Details] OD WHERE OrderID=@cod_orden GROUP BY OD.OrderID
		END ELSE
		BEGIN 
		PRINT 'La orden no existe y el codigo es: '+CONVERT(varchar(10),@cod_orden)
		END 
		GO

	--Primer procedimiento
	EXEC sp_Insertar_Categorias 1,'Alimentos'
	EXEC sp_Insertar_Categorias 9,'Alimentos'
	EXEC sp_Insertar_Categorias 10,'Alimentos'
	
	--Segundo procedimiento
	EXEC sp_Hay_Clientes 'Washington'
	EXEC sp_Hay_Clientes 'New York'

	--Tercer procedimiento LO MISMO QUE EL SEGUNDO PERO CON PARAMETRO
	EXEC Proc_Total 10242

	--Cuarto procedimiento 
	EXEC Mostrar_10_pedidos

	--Quinto procedimiento 
	SELECT UnitPrice FROM Products ORDER BY UnitPrice DESC
	EXECUTE Actualizar_Precio--EXECUTE = EXEC

	--Cursores:
	--Sexto procedimiento 



	SELECT * FROM Categories

