USE DB_Generic_1 

CREATE TABLE CLIENTES(
codigoid int,
Cod_Descuento varchar(6) UNIQUE CHECK (Cod_Descuento !='123456' or Cod_Descuento = 'abcdef'),
nombre varchar(30) NOT NULL,
edad integer NOT NULL

);

/*para borrar una tabla:

DROP TABLE CLIENTES
DROP TABLE Contactos
*/

CREATE TABLE VENTA(
fechaventa date
);

CREATE TABLE Producto
(Codigo integer CHECK (Codigo > 0),
 nombre_producto varchar (30),
 precio_producto float);

 CREATE TABLE Contactos (
 codigo int,
 Telefono varchar(8)
 );

 ALTER TABLE Contactos ADD estado VARCHAR(8) /*Agrega una columna*/

 ALTER TABLE Contactos DROP COLUMN estado /*Quita una columna*/

 ALTER TABLE Contactos ADD CONSTRAINT exd_check CHECK (codigo> 1); /*Añade a una restriccion*/
 
 ALTER TABLE VENTA
ADD CONSTRAINT default_fecha
DEFAULT getdate() FOR fechaventa ;

