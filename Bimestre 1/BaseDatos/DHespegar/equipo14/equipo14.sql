-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema DHespegar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema DHespegar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `DHespegar` DEFAULT CHARACTER SET utf8 ;
USE `DHespegar` ;

-- -----------------------------------------------------
-- Table `DHespegar`.`pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`pais` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`ciudad` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `pais_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ciudad_pais1_idx` (`pais_id` ASC) VISIBLE,
  CONSTRAINT `fk_ciudad_pais1`
    FOREIGN KEY (`pais_id`)
    REFERENCES `DHespegar`.`pais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  `apellido` VARCHAR(25) NOT NULL,
  `pasaporte` CHAR(15) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `ciudad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cliente_ciudad1_idx` (`ciudad_id` ASC) VISIBLE,
  UNIQUE INDEX `pasaporte_UNIQUE` (`pasaporte` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_ciudad1`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `DHespegar`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`agencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`agencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`sucursal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(50) NOT NULL,
  `ciudad_id` INT NOT NULL,
  `agencia_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_sucursal_ciudad1_idx` (`ciudad_id` ASC) VISIBLE,
  INDEX `fk_sucursal_agencia1_idx` (`agencia_id` ASC) VISIBLE,
  CONSTRAINT `fk_sucursal_ciudad1`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `DHespegar`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sucursal_agencia1`
    FOREIGN KEY (`agencia_id`)
    REFERENCES `DHespegar`.`agencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`hotel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(50) NOT NULL,
  `cantidadHabitaciones` MEDIUMINT NOT NULL,
  `ciudad_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_hotel_ciudad1_idx` (`ciudad_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_ciudad1`
    FOREIGN KEY (`ciudad_id`)
    REFERENCES `DHespegar`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`telefono` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `telefono` CHAR(20) NOT NULL,
  `cliente_id` INT NULL,
  `sucursal_id` INT NULL,
  `hotel_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefono_cliente_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_telefono_sucursal1_idx` (`sucursal_id` ASC) VISIBLE,
  INDEX `fk_telefono_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_telefono_cliente`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `DHespegar`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefono_sucursal1`
    FOREIGN KEY (`sucursal_id`)
    REFERENCES `DHespegar`.`sucursal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefono_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `DHespegar`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`reserva` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigoReserva` CHAR(6) NOT NULL,
  `fechaRegistro` DATETIME NOT NULL,
  `cliente_id` INT NOT NULL,
  `sucursal_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_reserva_cliente1_idx` (`cliente_id` ASC) VISIBLE,
  INDEX `fk_reserva_sucursal1_idx` (`sucursal_id` ASC) VISIBLE,
  UNIQUE INDEX `codigoReserva_UNIQUE` (`codigoReserva` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `DHespegar`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_sucursal1`
    FOREIGN KEY (`sucursal_id`)
    REFERENCES `DHespegar`.`sucursal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`tipoVuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`tipoVuelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipoVuelo` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`vuelo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(30) NOT NULL,
  `pasaje` CHAR(25) NOT NULL,
  `numeroVuelo` CHAR(6) NOT NULL,
  `fechaPartida` DATETIME NOT NULL,
  `fechaLlegada` DATETIME NOT NULL,
  `plazasTurista` SMALLINT NOT NULL,
  `plazasPrimera` SMALLINT NOT NULL,
  `ciudadOrigen` INT NOT NULL,
  `ciudadDestino` INT NOT NULL,
  `tipoVuelo_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vuelo_ciudad1_idx` (`ciudadOrigen` ASC) VISIBLE,
  INDEX `fk_vuelo_ciudad2_idx` (`ciudadDestino` ASC) VISIBLE,
  INDEX `fk_vuelo_tipoVuelo1_idx` (`tipoVuelo_id` ASC) VISIBLE,
  UNIQUE INDEX `pasaje_UNIQUE` (`pasaje` ASC) VISIBLE,
  CONSTRAINT `fk_vuelo_ciudad1`
    FOREIGN KEY (`ciudadOrigen`)
    REFERENCES `DHespegar`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vuelo_ciudad2`
    FOREIGN KEY (`ciudadDestino`)
    REFERENCES `DHespegar`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vuelo_tipoVuelo1`
    FOREIGN KEY (`tipoVuelo_id`)
    REFERENCES `DHespegar`.`tipoVuelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`reserva_x_vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`reserva_x_vuelo` (
  `reserva_id` INT NOT NULL,
  `vuelo_id` INT NOT NULL,
  PRIMARY KEY (`reserva_id`, `vuelo_id`),
  INDEX `fk_reserva_has_vuelo_vuelo1_idx` (`vuelo_id` ASC) VISIBLE,
  INDEX `fk_reserva_has_vuelo_reserva1_idx` (`reserva_id` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_has_vuelo_reserva1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `DHespegar`.`reserva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_has_vuelo_vuelo1`
    FOREIGN KEY (`vuelo_id`)
    REFERENCES `DHespegar`.`vuelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`hotel_x_reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`hotel_x_reserva` (
  `hotel_id` INT NOT NULL,
  `reserva_id` INT NOT NULL,
  `checkIn` DATETIME NOT NULL,
  `checkOut` DATETIME NOT NULL,
  `tipoHospedaje` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`hotel_id`, `reserva_id`),
  INDEX `fk_hotel_has_reserva_reserva1_idx` (`reserva_id` ASC) VISIBLE,
  INDEX `fk_hotel_has_reserva_hotel1_idx` (`hotel_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel_has_reserva_hotel1`
    FOREIGN KEY (`hotel_id`)
    REFERENCES `DHespegar`.`hotel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_hotel_has_reserva_reserva1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `DHespegar`.`reserva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DHespegar`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DHespegar`.`pago` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valorFinal` FLOAT(12,2) NOT NULL,
  `tipoPago` VARCHAR(45) NOT NULL,
  `cantidadCuotas` TINYINT NOT NULL,
  `reserva_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pago_reserva1_idx` (`reserva_id` ASC) VISIBLE,
  CONSTRAINT `fk_pago_reserva1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `DHespegar`.`reserva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
