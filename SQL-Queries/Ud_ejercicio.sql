CREATE DATABASE zona_fit_db
USE zona_fit_db

CREATE TABLE Cliente (
	id integer PRIMARY KEY IDENTITY(1,1) NOT NULL,
	nombre varchar(45) NOT NULL,
	apellido varchar(45) NOT NULL,
	membresia integer UNIQUE NOT NULL	 
);


--IDENTITY auto incrementa valores 
--IDENTITY( [VALOR INICIAL], [INCREMENTO CADA QUE HACES UN REGISTRO] )
SELECT * FROM Cliente 
INSERT INTO Cliente VALUES ('Josue','Flores',12);
INSERT INTO Cliente VALUES ('Paola','Castillo',934);


DROP TABLE Cliente
DELETE  FROM Cliente


--RECUERDA ESTO PARA ACCEDER A MANAGER SQLServerManager16.msc
