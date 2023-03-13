-- MUESTRA DEL USO DE STORED PROCEDURE - BASIC
-- Base de datos: muestra_basica
-- En Microsoft SQL Server se usa EXEC o EXECUTE para ejecutar un SP.

SET @miVar = 'hola';
SELECT @miVar;

SET @miVar = 'medina';
SELECT * FROM cliente WHERE apellido = @miVar;

DELIMITER $$

SHOW PROCEDURE STATUS WHERE db = 'muestra_basica' $$

-- Procedimiento almacenado sin parámetros
DROP PROCEDURE IF EXISTS sp_obtenerCliente $$
CREATE PROCEDURE sp_obtenerCliente()
BEGIN	
     SELECT * FROM cliente;
END $$
CALL sp_obtenerCliente() $$


-- Procedimiento almacenado anidado sin parámetros
DROP PROCEDURE IF EXISTS sp_obtenerClienteAnidado $$
CREATE PROCEDURE sp_obtenerClienteAnidado()
BEGIN	
     CALL sp_obtenerCliente();
END $$
CALL sp_obtenerClienteAnidado() $$


-- Procedimiento almacenado con un parámetro de entrada
DROP PROCEDURE IF EXISTS sp_obtenerClientePorNombre $$
CREATE PROCEDURE sp_obtenerClientePorNombre(IN pNombre CHAR(30))
BEGIN	
     SELECT * FROM cliente WHERE nombre LIKE CONCAT('%',pNombre,'%');
END $$
CALL sp_obtenerClientePorNombre('o') $$