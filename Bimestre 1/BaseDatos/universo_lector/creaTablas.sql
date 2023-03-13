CREATE TABLE editorial(
codigo INT NOT NULL AUTO_INCREMENT,
razon_social VARCHAR(100) NOT NULL,
telefono VARCHAR(100) NOT NULL,
PRIMARY KEY (codigo)
);

CREATE TABLE autor(
codigo INT NOT NULL AUTO_INCREMENT,
apellido VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
PRIMARY KEY (codigo)
);

CREATE TABLE socio(
codigo INT NOT NULL AUTO_INCREMENT,
apellido VARCHAR(100) NOT NULL,
nombre VARCHAR(100) NOT NULL,
direccion VARCHAR(200) NOT NULL,
localidad VARCHAR(100) NOT NULL,
PRIMARY KEY (codigo)
);

CREATE TABLE prestamo(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_socio INT NOT NULL,
fecha DATETIME NOT NULL,
fecha_devolucion DATE NOT NULL,
fecha_tope DATE NOT NULL,
PRIMARY KEY (codigo),
FOREIGN KEY (codigo_socio) REFERENCES socio (codigo)
);

CREATE TABLE telefonoxsocio(
nrotelefono VARCHAR(100) NOT NULL,
codigo_socio INT NOT NULL,
codigo INT NOT NULL AUTO_INCREMENT,
PRIMARY KEY (codigo),
FOREIGN KEY (codigo_socio) REFERENCES socio (codigo)
);

CREATE TABLE libro(
codigo INT NOT NULL AUTO_INCREMENT,
titulo VARCHAR(13) NOT NULL,
anio_escritura DATE NOT NULL,
codigo_autor INT NOT NULL,
anio_edicion DATE NOT NULL,
codigo_editorial INT NOT NULL,
PRIMARY KEY (codigo),
FOREIGN KEY (codigo_autor) REFERENCES autor (codigo),
FOREIGN KEY (codigo_editorial) REFERENCES editorial (codigo)
);

CREATE TABLE volumen(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_libro INT NOT NULL,
deteriorado BOOL NOT NULL,
PRIMARY KEY (codigo),
FOREIGN KEY (codigo_libro) REFERENCES libro (codigo)
);

CREATE TABLE prestamoxvolumen(
codigo INT NOT NULL AUTO_INCREMENT,
codigo_prestamo INT NOT NULL,
codigo_volumen INT NOT NULL,
PRIMARY KEY (codigo),
FOREIGN KEY (codigo_prestamo) REFERENCES prestamo (codigo),
FOREIGN KEY (codigo_volumen) REFERENCES volumen (codigo)
);