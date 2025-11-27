CREATE DATABASE HotelDB
USE HotelDB

CREATE TABLE Hotel(
	CodigoHotel char(6),
	Nombre varchar(30),
	Direccion varchar(60),
	SitioWeb varchar(60)
);

CREATE TABLE Habitacion(
	CodigoHabitacion char(6),
	CodigoHotel char(6),
	Tipo varchar(30),
	Precio double
);

CREATE TABLE Huesped (
CodigoHuesped char(6),
Nombre varchar(30),
Email varchar (30),
Direccion varchar(50),
Telefono varchar(8)
);
