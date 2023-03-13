-- MUESTRA DEL USO DE STORED PROCEDURE - Intermedio
-- Base de datos: muestra_basica

DELIMITER $$

SHOW PROCEDURE STATUS WHERE db = 'muestra_joins' $$

-- Procedimiento almacenado con un parámetro de entrada y otro de salida
DROP PROCEDURE IF EXISTS sp_obtenerClientePorId $$
CREATE PROCEDURE sp_obtenerClientePorId(IN pId INT, OUT pApellido VARCHAR(30))
BEGIN	
     SELECT concat(apellido, " ", nombre) INTO pApellido FROM cliente WHERE id = pId;
END $$
CALL sp_obtenerClientePorId(4, @x) $$
SELECT @x $$



-- Procedimiento almacenado con un solo parámetro de entrada-salida
DROP PROCEDURE IF EXISTS sp_obtenerClientePorDNI $$
CREATE PROCEDURE sp_obtenerClientePorDNI(INOUT pDNI CHAR(60))
BEGIN	
	SELECT CONCAT(apellido, ", ", nombre) INTO pDNI FROM cliente WHERE documento_nro = pDNI;
END $$

SET @dato = '35125400' $$
SELECT @dato $$ -- Contiene el valor asignado = '35125400'
CALL sp_obtenerClientePorDNI(@dato) $$
SELECT @dato $$



-- Experimentando SP
DROP PROCEDURE IF EXISTS sp_consultarCliente $$
CREATE PROCEDURE sp_consultarCliente(IN opcion CHAR(10), IN pID INT, IN pApellido CHAR(10))
BEGIN 
	-- Estructura de selección múltiple
    CASE opcion
		WHEN 'select' THEN
			SELECT * FROM cliente WHERE id = pID;
		WHEN 'update' THEN
			-- Estructura de selección simple: verifica que el apellido no sea NULL
            IF (pApellido != '' AND pApellido IS NOT NULL) THEN
				UPDATE cliente set apellido = pApellido WHERE id = pID;
			END IF;
		WHEN 'delete' THEN
			DELETE FROM cliente WHERE id = pID;
	END CASE;
END $$

CALL sp_consultarCliente('select',9,'') $$
CALL sp_consultarCliente('update',9,'Olave') $$
CALL sp_consultarCliente('delete',9,'') $$
SELECT @dato $$

-- Agregar registro para pruebas
INSERT INTO cliente VALUES ('9', 'Sanchez', 'Martin', '33554125') $$
SELECT * FROM cliente $$