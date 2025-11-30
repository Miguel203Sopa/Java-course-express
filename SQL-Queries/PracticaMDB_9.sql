/*TRIGGERS

SINTAXIS: 

CREATE TRIGGER nombre_trigger
	ON { nombre_tabla_o_vista }
	{
	{ FOR | AFTER | INSTEAD OF }
	{
	instruccion_modificacion1,
	instruccion_modificacion2,
	instruccion_modificacion3
	}
	AS
	Instrucción_sql0 ,
	Instruccion_sq1 ,
	Instruccion_sql2 ,
	…
	Instrucción_sqlN
	} 
*/

--AFTER o FOR --Se recomienda usar AFTER 
--se activa o ejecuta luego de las instrucciones T-SQL siempre y cuando
--se hayan ejecutado correctamente

--INSTEAD OF  , Esta instruccion es lo contrario se ejecuta primero
--las instrucciones del trigger y despues las de la accion original

CREATE TRIGGER TR_CUENTAS
ON CUENTAS
AFTER UPDATE
AS
BEGIN
-- SET NOCOUNT ON impide que se generen mensajes de texto
-- con cada instrucción
SET NOCOUNT ON;
INSERT INTO HCO_SALDOS
(IDCUENTA, SALDO, FXSALDO)
SELECT IDCUENTA, SALDO, getdate()
FROM INSERTED
END
GO


CREATE TRIGGER miTrigger_for 
ON dbo.Categories
FOR INSERT,UPDATE,DELETE 
AS PRINT '----Se actualizaron los datos de las tablas----'
GO
--Este se ejecuta cuando en la tabla categorias se inserta
--,actualiza o se borra algun registro

CREATE TRIGGER miTrigger_after 
ON dbo.Categories 
AFTER INSERT 
AS PRINT '----Se Agrego un nuevo registro a la tabla'
GO
--se ejecuta cuando se agrega un registro


--Tablas deleted e inserted
/*
CREATE TRIGGER trInsActVentas
ON Ventas
FOR INSERT, UPDATE AS
IF (SELECT COUNT(*) FROM tblTiendas, inserted
WHERE Tiendas.stor_id=inserted.stor_id)=0
BEGIN
PRINT 'No existe en la tabla Tiendas el stor_id'
PRINT 'que usted registró'
ROLLBACK TRANSACTION
END
*//*
 La siguiente instrucción impide que se ejecuten
sentencias DROP TABLE y ALTER TABLE en la
base de datos.
*/
CREATE TRIGGER TR_SEGURIDAD ON
DATABASE FOR DROP_TABLE,
ALTER_TABLE AS
BEGIN
RAISERROR ('No está permitido borrar ni
modificar tablas !' , 16, 1)
ROLLBACK TRANSACTION
END
go

/*
	Podemos activar y desactivar Triggers a través de las
siguientes instrucciones.
*/

-- Desactiva el trigger TR_CUENTAS
DISABLE TRIGGER TR_CUENTAS ON CUENTAS
GO
-- Activa el trigger TR_CUENTAS
ENABLE TRIGGER TR_CUENTAS ON CUENTAS
GO

-- Desactiva todos los trigger de la tabla CUENTAS 
ALTER TABLE CUENTAS DISABLE TRIGGER ALL
GO
-- Activa todos los trigger de la tabla CUENTAS
ALTER TABLE CUENTAS ENABLE TRIGGER ALL