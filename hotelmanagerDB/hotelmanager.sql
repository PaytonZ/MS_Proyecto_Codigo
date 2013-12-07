SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `hotelmanagerDB` ;
CREATE SCHEMA IF NOT EXISTS `hotelmanagerDB` DEFAULT CHARACTER SET utf8 ;
USE `hotelmanagerDB` ;

-- -----------------------------------------------------
-- Table `clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `clientes` ;

CREATE TABLE IF NOT EXISTS `clientes` (
  `idclientes` INT NOT NULL AUTO_INCREMENT,
  `DNI` VARCHAR(10) NULL,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `1apellido` VARCHAR(45) NULL,
  `2apellido` VARCHAR(45) NULL,
  `activo` TINYINT(1) NULL DEFAULT true,
  `telefono` INT(9) NULL,
  PRIMARY KEY (`idclientes`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `habitaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `habitaciones` ;

CREATE TABLE IF NOT EXISTS `habitaciones` (
  `numhabitacion` INT NOT NULL,
  `tipohabitacion` ENUM('NORMAL','SUITE') NULL,
  `precio` DOUBLE NULL,
  PRIMARY KEY (`numhabitacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `reservas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `reservas` ;

CREATE TABLE IF NOT EXISTS `reservas` (
  `idreservas` INT NOT NULL AUTO_INCREMENT,
  `clientes_idclientes` INT NOT NULL,
  `habitaciones_numhabitacion` INT NOT NULL,
  `fecha_reserva` DATETIME NOT NULL,
  `fecha_entrada` DATETIME NULL,
  `fecha_salida` DATETIME NULL,
  INDEX `fk_reservas_clientes_idx` (`clientes_idclientes` ASC),
  INDEX `fk_reservas_habitaciones1_idx` (`habitaciones_numhabitacion` ASC),
  UNIQUE INDEX `idreservas_UNIQUE` (`idreservas` ASC),
  PRIMARY KEY (`clientes_idclientes`, `fecha_reserva`),
  CONSTRAINT `fk_reservas_clientes`
    FOREIGN KEY (`clientes_idclientes`)
    REFERENCES `clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_habitaciones1`
    FOREIGN KEY (`habitaciones_numhabitacion`)
    REFERENCES `habitaciones` (`numhabitacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleados` ;

CREATE TABLE IF NOT EXISTS `empleados` (
  `idempleados` INT NOT NULL AUTO_INCREMENT,
  `DNI` VARCHAR(10) NULL,
  `telefono` INT(9) UNSIGNED NULL,
  `direccion` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `activo` TINYINT(1) NULL,
  `tipoempleado` ENUM('PARCIAL','COMPLETO') NULL,
  PRIMARY KEY (`idempleados`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `departamentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `departamentos` ;

CREATE TABLE IF NOT EXISTS `departamentos` (
  `iddepartamentos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`iddepartamentos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tareas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tareas` ;

CREATE TABLE IF NOT EXISTS `tareas` (
  `idtareas` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `descripcion` TEXT NULL,
  PRIMARY KEY (`idtareas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empleadosporDepartamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `empleadosporDepartamento` ;

CREATE TABLE IF NOT EXISTS `empleadosporDepartamento` (
  `empleados_idempleados` INT NOT NULL,
  `departamentos_iddepartamentos` INT NOT NULL,
  PRIMARY KEY (`empleados_idempleados`, `departamentos_iddepartamentos`),
  INDEX `fk_empleadosporDepartamento_empleados1_idx` (`empleados_idempleados` ASC),
  INDEX `fk_empleadosporDepartamento_departamentos1_idx` (`departamentos_iddepartamentos` ASC),
  CONSTRAINT `fk_empleadosporDepartamento_empleados1`
    FOREIGN KEY (`empleados_idempleados`)
    REFERENCES `empleados` (`idempleados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleadosporDepartamento_departamentos1`
    FOREIGN KEY (`departamentos_iddepartamentos`)
    REFERENCES `departamentos` (`iddepartamentos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tareasporEmpleado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tareasporEmpleado` ;

CREATE TABLE IF NOT EXISTS `tareasporEmpleado` (
  `tareas_idtareas` INT NOT NULL,
  `empleados_idempleados` INT NOT NULL,
  PRIMARY KEY (`tareas_idtareas`, `empleados_idempleados`),
  INDEX `fk_tareas_has_empleados_empleados1_idx` (`empleados_idempleados` ASC),
  INDEX `fk_tareas_has_empleados_tareas1_idx` (`tareas_idtareas` ASC),
  CONSTRAINT `fk_tareas_has_empleados_tareas1`
    FOREIGN KEY (`tareas_idtareas`)
    REFERENCES `tareas` (`idtareas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tareas_has_empleados_empleados1`
    FOREIGN KEY (`empleados_idempleados`)
    REFERENCES `empleados` (`idempleados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
