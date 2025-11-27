USE master
GO
CREATE DATABASE Example_DBP2
USE Example_DBP2

--Tabla Autor 
CREATE TABLE Autor (
CodigoAutor char(5) NOT NULL,
PrimerNombre varchar(25) NOT NULL,
PrimerApellido varchar(30),
FechaNacimiento date,
Nacionalidad varchar(35)
);

--Tabla Libro
CREATE TABLE Libro 
(CodigoLibro char(10) NOT NULL,
Titulo varchar(max),
ISBN varchar(20) NOT NULL,
AñoEdicion char(4),
CodigoEditorial char(5)
);
/*DROP TABLE Libro*/

--Tabla Editorial
CREATE TABLE Editorial(
CodigoEditorial char(5) NOT NULL,
Nombre varchar(45),
Pais varchar(50)
);

--Tabla Detalle_AutorLibro
CREATE TABLE Detalle_AutorLibro(
	CodigoAutor char(5),
	CodigoLibro char(10),
	Fecha date 
);

--Alteraciones:

ALTER TABLE Detalle_AutorLibro
ADD CONSTRAINT DF_fecha
DEFAULT getdate() FOR Fecha;

ALTER TABLE Libro
ADD CONSTRAINT CK_añoedicion
CHECK (AñoEdicion > 2010);

ALTER TABLE Libro 
ADD CONSTRAINT U_isbn
UNIQUE(ISBN)

--Llaves Primarias 

ALTER TABLE Autor 
ADD CONSTRAINT PK_CodigoAutor
PRIMARY KEY(CodigoAutor)
GO

ALTER TABLE Libro
ADD CONSTRAINT PK_CodigoLibro
PRIMARY KEY (CodigoLibro)
GO

ALTER TABLE EDITORIAL 
ADD CONSTRAINT PK_CodigoEditorial
PRIMARY KEY (CodigoEditorial)

GO

--llaves Foraneas 

ALTER TABLE Detalle_AutorLibro
ADD CONSTRAINT FK_CodigoAutor
FOREIGN KEY(CodigoAutor)
REFERENCES Autor(CodigoAutor)
GO

ALTER TABLE Detalle_AutorLibro
ADD CONSTRAINT FK_CodigoLibro
FOREIGN KEY(CodigoLibro)
REFERENCES LIBRO(CodigoLibro)
GO

ALTER TABLE Libro
ADD CONSTRAINT FK_LibroEditorial
FOREIGN KEY (CodigoEditorial)
REFERENCES Editorial(CodigoEditorial)
GO


