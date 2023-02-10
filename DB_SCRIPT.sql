-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tadalafit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tadalafit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tadalafit` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `tadalafit` ;

-- -----------------------------------------------------
-- Table `tadalafit`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadalafit`.`administrador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `user` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tadalafit`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadalafit`.`aluno` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `sexo` VARCHAR(45) NULL DEFAULT NULL,
  `cpf` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(15) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `data_nascimento` VARCHAR(10) NULL DEFAULT NULL,
  `altura` FLOAT NULL DEFAULT NULL,
  `peso` DOUBLE NULL DEFAULT NULL,
  `bf` DOUBLE NULL DEFAULT NULL,
  `comorbidade` VARCHAR(45) NULL DEFAULT NULL,
  `matricula_prof_encarregado` INT NULL DEFAULT NULL,
  `treino_a` JSON NULL DEFAULT NULL,
  `treino_b` JSON NULL DEFAULT NULL,
  `treino_c` JSON NULL DEFAULT NULL,
  `treino_d` JSON NULL DEFAULT NULL,
  `treino_e` JSON NULL DEFAULT NULL,
  `situacao` VARCHAR(45) NULL DEFAULT NULL,
  `dt_pagamento` VARCHAR(35) NULL DEFAULT date_format(curdate(),_utf8mb4'%d/%m/%Y %H:%i:%S'),
  `foto` LONGBLOB NULL DEFAULT NULL,
  `evolucao` JSON NULL DEFAULT NULL,
  `dt_evolucao` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
AUTO_INCREMENT = 123146
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `tadalafit`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tadalafit`.`professor` (
  `matricula` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `cref` VARCHAR(45) NULL DEFAULT NULL,
  `usuario` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  `foto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
