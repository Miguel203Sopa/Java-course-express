--Consultas de Manipulacion de datos
CREATE DATABASE Guia_4DB
USE Guia_4DB

CREATE TABLE Categoria(
	CodigoCategoria int NOT NULL,
	NombreCategoria varchar(50)
	CONSTRAINT pk_categoria PRIMARY KEY (CodigoCategoria)
);

CREATE TABLE Producto (
	CodigoProducto int NOT NULL,
	NombreProducto varchar(50),
	PrecioUnitario decimal(18,2),
	CodigoCategoria int
	CONSTRAINT pk_producto PRIMARY KEY (CodigoProducto)
	CONSTRAINT fk_categoria FOREIGN KEY (CodigoCategoria)
	REFERENCES Categoria(CodigoCategoria)

);

--INSERT Permite agregar o poner uno o varios registros
INSERT INTO Categoria VALUES(1,'Bebidas')

--Podemos especificar los valores de la tabla donde insertaremos los valores
INSERT INTO Categoria(CodigoCategoria,NombreCategoria) VALUES (2,'Carnes Rojas')
INSERT INTO Categoria(NombreCategoria,CodigoCategoria) VALUES ('Harinas',3)

--varios inserts
INSERT INTO Categoria VALUES 
(4,'Vegetales'),
(5,'Frutas'),
(6,'Mariscos')

INSERT INTO Producto VALUES
(1, 'Soda Coca Cola', 1.25,1), --ultimo dato indica la categoria
(2, 'Carne bistec',3.50,2),
(3, 'Camarones pequeños',1.15,6),
(4, 'Harina blanca',0.75,3),
(5, 'Te verde',1.0,1),
(6, 'Lomo de aguja',4.50,2),
(7, 'Soda de naranja',1.25,1),
(8, 'Chiles verdes',0.25,4),
(9, 'Tomates',0.2,4),
(10, 'Manzana verde',0.25,5)

--SELECT - INTO con esto puedes crear una tabla con datos de otras

SELECT * FROM Producto

SELECT * INTO [Producto CategoriaBebidas]
FROM Producto
WHERE CodigoCategoria=1 
--se copian las filas bajo la condicion


SELECT * FROM [Producto CategoriaBebidas]

--INSERT INTO - SELECT
/*La consulta SELECT de la instrucción INSERT se puede utilizar para agregar valores a una tabla de la base de
datos. */

CREATE TABLE [Producto CategoriaVegetales]
(CodigoProducto int NOT NULL, NombreProducto
varchar(50),
PrecioUnitario decimal(18,2),
CodigoCategoria int
CONSTRAINT pk_producto1 PRIMARY KEY (CodigoProducto)
CONSTRAINT fk_categoria1 FOREIGN KEY (CodigoCategoria)
REFERENCES Categoria(CodigoCategoria)
) 

SELECT * FROM [Producto CategoriaVegetales] 

INSERT INTO [Producto CategoriaVegetales]
SELECT CodigoProducto,NombreProducto,PrecioUnitario,CodigoCategoria
FROM Producto
WHERE CodigoCategoria=4 

SELECT * FROM [Producto CategoriaVegetales]

/*
Nota: a diferencia con la sentencia SELECT - INTO, es que aquí debe de crearse la tabla previamente Sentencia
UPDATE 
*/

--UPDATE pemite modificar datos usando la palabra clave SET y en conjunto
--con WHERE funcion

UPDATE [Producto CategoriaBebidas] SET PrecioUnitario=1.50 --esto cambia toda la columna

UPDATE [Producto CategoriaBebidas] SET PrecioUnitario=1.25-- esto solo cambia donde se cumple la condicion
WHERE CodigoProducto=1 UPDATE [Producto CategoriaBebidas] SET PrecioUnitario=1.75
WHERE CodigoProducto=1 AND CodigoCategoria=1 --lo mismo pero con varias condicionesSELECT * FROM [Producto CategoriaBebidas] --DELETE borra datos de la tabla solo los datos, no la tablaDELETE FROM [Producto CategoriaBebidas]SELECT * FROM [Producto CategoriaBebidas]--podemos especificar que datos borrarDELETE FROM Producto WHERE CodigoCategoria=4SELECT * FROM Categoria--si queremos borrar datos afectados por llaves foraneas podemos eliminar las llavesALTER TABLE ProductoDROP CONSTRAINT fk_categoria--reescribimos las condiciones para que puedan borrarse y editarse sin ningun problemaALTER TABLE Producto
ADD CONSTRAINT fk_categoria
FOREIGN KEY (CodigoCategoria) REFERENCES Categoria (CodigoCategoria)
ON DELETE CASCADE --esto permite borrar datos considerando las llaves foraneas
ON UPDATE CASCADE --esta permite actualizar datos considerando las llaves foraneasDELETE FROM Categoria WHERE CodigoCategoria =6 --hoy se funcionaSELECT * FROM Categoria SELECT * FROM Producto--seleccionar mas de una tabla muestra ambas--tambien se pueden agregar las consideraciones en la tablaCREATE TABLE [Producto CategoriaFrutas]
(CodigoProducto int NOT NULL, NombreProducto
varchar(50),
PrecioUnitario decimal(18,2),
CodigoCategoria int
CONSTRAINT pk_producto2 PRIMARY KEY (CodigoProducto)
CONSTRAINT fk_categoria2 FOREIGN KEY (CodigoCategoria)
REFERENCES Categoria(CodigoCategoria)ON DELETE CASCADE --permite borrar datos de llaves foraneas
ON UPDATE CASCADE --permite editar datos de llaves foraneas
)