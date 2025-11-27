CREATE DATABASE HotelDB
USE HotelDB

CREATE TABLE Hotel(
	CodigoHotel char(6) NOT NULL,
	Nombre varchar(30) UNIQUE,
	Direccion varchar(60),
	SitioWeb varchar(60) UNIQUE
);

CREATE TABLE Habitacion(
	CodigoHabitacion char(6) NOT NULL,
	CodigoHotel char(6),
	Tipo varchar(30),
	Precio float
	);

CREATE TABLE Huesped (
CodigoHuesped char(6)NOT NULL,
Nombre varchar(30),
Email varchar (30) UNIQUE,
Direccion varchar(50),
Telefono varchar(8)
);

CREATE TABLE Reservacion (
	CodigoReserva char(6) NOT NULL,
	CodigoHotel char(6) NOT NULL,
	CodigoHuesped char(6) NOT NULL,
	CodigoHabitacion char(6) NOT NULL,
	FechaInicio DATE ,
	FechaFin DATE
);


 ALTER TABLE Habitacion
 ADD CONSTRAINT price_check
 CHECK (Precio> 25); /*Añade a una restriccion*/

  ALTER TABLE Habitacion
 ADD CONSTRAINT type_check
 CHECK (Tipo LIKE 'Doble' or Tipo LIKE'doble' or Tipo LIKE 'Individual' or Tipo LIKE 'individiual'); /*Añade a una restriccion*/
 

  ALTER TABLE Reservacion
 ADD CONSTRAINT date_rec_check
 CHECK(FechaFin > FechaInicio);


  ALTER TABLE Reservacion
 ADD CONSTRAINT date_d_check
DEFAULT getdate() FOR FechaInicio ;

--Llaves primarias

ALTER TABLE Hotel 
ADD CONSTRAINT PK_CodigoHotel
PRIMARY KEY(CodigoHotel)
GO

ALTER TABLE Habitacion
ADD CONSTRAINT PK_CodigoHabitacion
PRIMARY KEY(CodigoHabitacion)
GO

ALTER TABLE Huesped
ADD CONSTRAINT PK_CodigoHuesped
PRIMARY KEY(CodigoHuesped)
GO

ALTER TABLE Reservacion
ADD CONSTRAINT PK_CodigoReserva
PRIMARY KEY(CodigoReserva)
GO


--llaves Foraneas 

ALTER TABLE Reservacion
ADD CONSTRAINT FK_CodigoHotel
FOREIGN KEY(CodigoHotel)
REFERENCES Hotel(CodigoHotel)
GO

ALTER TABLE Reservacion
ADD CONSTRAINT FK_CodigoHuesped
FOREIGN KEY(CodigoHuesped)
REFERENCES Huesped(CodigoHuesped)
GO

ALTER TABLE Reservacion
ADD CONSTRAINT FK_CodigoHabitacion
FOREIGN KEY(CodigoHabitacion)
REFERENCES Habitacion(CodigoHabitacion)
GO







