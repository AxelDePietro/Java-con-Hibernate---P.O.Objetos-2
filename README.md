Trabajo practico para Orientacion a objetos 2, sobre sistema de ticketera.

JAVA 21 

requiere librerias de hibernate, link para descargarlas:  
https://drive.google.com/drive/folders/1oc1dU4R1WI3CHWDHRgv43nu8w0D9xoSH?usp=drive_link

base de datos SQL - mySQLserver:

        -- MySQL Workbench Forward Engineering
        
        SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
        SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
        SET @OLD_SQL_MODE=@@SQL_MODE,           SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
        
        -- -----------------------------------------------------
        -- Schema mydb
        -- -----------------------------------------------------
        -- -----------------------------------------------------
        -- Schema bd-ticketera-hibernate
        -- -----------------------------------------------------
        
        -- -----------------------------------------------------
        -- Schema bd-ticketera-hibernate
        -- -----------------------------------------------------
        CREATE SCHEMA IF NOT EXISTS `bd-ticketera-hibernate` DEFAULT CHARACTER SET utf8mb3 ;
        USE `bd-ticketera-hibernate` ;
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`usuario`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`usuario` (
          `idUsuario` INT NOT NULL AUTO_INCREMENT,
          `nombre` VARCHAR(45) NOT NULL,
          `apellido` VARCHAR(45) NOT NULL,
          `dni` INT NOT NULL,
          PRIMARY KEY (`idUsuario`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`empleado`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`empleado` (
          `usuario_idUsuario` INT NOT NULL,
          `rol` VARCHAR(45) NOT NULL,
          `legajo` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`usuario_idUsuario`),
          INDEX `fk_empleado_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
          CONSTRAINT `fk_empleado_usuario1`
            FOREIGN KEY (`usuario_idUsuario`)
            REFERENCES `bd-ticketera-hibernate`.`usuario` (`idUsuario`)
            ON DELETE CASCADE)
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`categoria`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`categoria` (
          `idCategoria` INT NOT NULL AUTO_INCREMENT,
          `tipo` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`idCategoria`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`cliente`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`cliente` (
          `usuario_idUsuario` INT NOT NULL,
          `nroCliente` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`usuario_idUsuario`),
          INDEX `fk_cliente_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
          CONSTRAINT `fk_cliente_usuario1`
            FOREIGN KEY (`usuario_idUsuario`)
            REFERENCES `bd-ticketera-hibernate`.`usuario` (`idUsuario`)
            ON DELETE CASCADE)
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`estado`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`estado` (
          `idEstado` INT NOT NULL AUTO_INCREMENT,
          `tipo` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`idEstado`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`prioridad`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`prioridad` (
          `idPrioridad` INT NOT NULL AUTO_INCREMENT,
          `tipo` VARCHAR(45) NOT NULL,
          PRIMARY KEY (`idPrioridad`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`ticket`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`ticket` (
          `idTicket` INT NOT NULL AUTO_INCREMENT,
          `titulo` VARCHAR(45) NOT NULL,
          `descripcion` VARCHAR(45) NOT NULL,
          `fechaCreacion` DATE NOT NULL,
          `fechaCierre` DATE NULL DEFAULT NULL,
          `cliente_usuario_idUsuario` INT NOT NULL,
          `categoria_idCategoria` INT NOT NULL,
          `prioridad_idPrioridad` INT NOT NULL,
          `estado_idEstado` INT NOT NULL,
          PRIMARY KEY (`idTicket`),
          INDEX `fk_ticket_cliente1_idx` (`cliente_usuario_idUsuario` ASC) VISIBLE,
          INDEX `fk_ticket_categoria1_idx` (`categoria_idCategoria` ASC) VISIBLE,
          INDEX `fk_ticket_prioridad1_idx` (`prioridad_idPrioridad` ASC) VISIBLE,
          INDEX `fk_ticket_estado1_idx` (`estado_idEstado` ASC) VISIBLE,
          CONSTRAINT `fk_ticket_categoria1`
            FOREIGN KEY (`categoria_idCategoria`)
            REFERENCES `bd-ticketera-hibernate`.`categoria` (`idCategoria`),
          CONSTRAINT `fk_ticket_cliente1`
            FOREIGN KEY (`cliente_usuario_idUsuario`)
            REFERENCES `bd-ticketera-hibernate`.`cliente` (`usuario_idUsuario`),
          CONSTRAINT `fk_ticket_estado1`
            FOREIGN KEY (`estado_idEstado`)
            REFERENCES `bd-ticketera-hibernate`.`estado` (`idEstado`),
          CONSTRAINT `fk_ticket_prioridad1`
            FOREIGN KEY (`prioridad_idPrioridad`)
            REFERENCES `bd-ticketera-hibernate`.`prioridad` (`idPrioridad`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`actualizacion`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`actualizacion` (
          `idActualizacion` INT NOT NULL AUTO_INCREMENT,
          `contenido` VARCHAR(45) NOT NULL,
          `fechaActualizacion` DATE NOT NULL,
          `empleado_usuario_idUsuario` INT NOT NULL,
          `ticket_idTicket` INT NOT NULL,
          PRIMARY KEY (`idActualizacion`),
          INDEX `fk_actualizacion_empleado1_idx` (`empleado_usuario_idUsuario` ASC) VISIBLE,
          INDEX `fk_actualizacion_ticket1_idx` (`ticket_idTicket` ASC) VISIBLE,
          CONSTRAINT `fk_actualizacion_empleado1`
            FOREIGN KEY (`empleado_usuario_idUsuario`)
            REFERENCES `bd-ticketera-hibernate`.`empleado` (`usuario_idUsuario`),
          CONSTRAINT `fk_actualizacion_ticket1`
            FOREIGN KEY (`ticket_idTicket`)
            REFERENCES `bd-ticketera-hibernate`.`ticket` (`idTicket`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        -- -----------------------------------------------------
        -- Table `bd-ticketera-hibernate`.`contacto`
        -- -----------------------------------------------------
        CREATE TABLE IF NOT EXISTS `bd-ticketera-hibernate`.`contacto` (
          `idContacto` INT NOT NULL AUTO_INCREMENT,
          `numero` INT NOT NULL,
          `email` VARCHAR(45) NULL DEFAULT NULL,
          `usuario_idUsuario` INT NOT NULL,
          PRIMARY KEY (`idContacto`),
          INDEX `fk_contacto_usuario_idx` (`usuario_idUsuario` ASC) VISIBLE,
          CONSTRAINT `fk_contacto_usuario`
            FOREIGN KEY (`usuario_idUsuario`)
            REFERENCES `bd-ticketera-hibernate`.`usuario` (`idUsuario`))
        ENGINE = InnoDB
        DEFAULT CHARACTER SET = utf8mb3;
        
        
        SET SQL_MODE=@OLD_SQL_MODE;
        SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
        SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
