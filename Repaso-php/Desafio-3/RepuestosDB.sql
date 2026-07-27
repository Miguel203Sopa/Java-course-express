CREATE DATABASE ultra_repuestos;
USE ultra_repuestos;


CREATE TABLE inventario_repuestos (
 codigo INT PRIMARY KEY,
 nombre_repuesto VARCHAR(150) NOT NULL,
 descripcion VARCHAR(355),
 marca VARCHAR(90),
 modelo_compatible VARCHAR(200),
 cantidad_stock INT NOT NULL DEFAULT 0,
 precio_unitario DECIMAL(10,2) NOT NULL,
 precio_total DECIMAL(12,2),
 proveedor VARCHAR(200),
 ubicacion VARCHAR(90),
 fecha_ingreso DATE,
 fotografia_url VARCHAR(355));

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50),
    password VARCHAR(255),
    nombre VARCHAR(100)
);

CREATE TABLE bodegas (
    idbodega INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion TEXT,
    responsable VARCHAR(100),
    departamento VARCHAR(100),
    municipio VARCHAR(100),
    direccion TEXT,
    estado VARCHAR(50)
);

CREATE TABLE inventario_bodega (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_producto INT,
    idbodega INT,
    cantidad INT,
    FOREIGN KEY (codigo_producto) REFERENCES inventario_repuestos(codigo),
    FOREIGN KEY (idbodega) REFERENCES bodegas(idbodega)
);

CREATE TABLE movimientos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idusuario INT,
    idproducto INT,
    nombreproducto VARCHAR(150),
    bodega_salida INT,
    bodega_entrada INT,
    responsable VARCHAR(100),
    cantidad INT,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO usuarios (usuario, password, nombre)
VALUES (
    'admin',
    '$2y$10$CiYwmwGoYdgxgS7ywsAP.ewaNoyLqyxUGxjAo25w.pEByAIg4wo0G',
    'Administrador'
);
INSERT INTO bodegas (nombre, descripcion, responsable, departamento, municipio, direccion, estado)
VALUES ('Almacen La Union', 'Bodega principal', 'Admin', 'La Union', 'La Union', 'Central', 'Activa');