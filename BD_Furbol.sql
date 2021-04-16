-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: BD_Furbol
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Competicion`
--

DROP TABLE IF EXISTS `Competicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Competicion` (
  `idCompeticion` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `temporada` int DEFAULT NULL,
  PRIMARY KEY (`idCompeticion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Competicion`
--

LOCK TABLES `Competicion` WRITE;
/*!40000 ALTER TABLE `Competicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Competicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Competicion_has_Equipo`
--

DROP TABLE IF EXISTS `Competicion_has_Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Competicion_has_Equipo` (
  `Competicion_idCompeticion` int NOT NULL,
  `Equipo_idEquipo` int NOT NULL,
  PRIMARY KEY (`Competicion_idCompeticion`,`Equipo_idEquipo`),
  KEY `fk_Competicion_has_Equipo_Equipo1_idx` (`Equipo_idEquipo`),
  KEY `fk_Competicion_has_Equipo_Competicion1_idx` (`Competicion_idCompeticion`),
  CONSTRAINT `fk_Competicion_has_Equipo_Competicion1` FOREIGN KEY (`Competicion_idCompeticion`) REFERENCES `Competicion` (`idCompeticion`),
  CONSTRAINT `fk_Competicion_has_Equipo_Equipo1` FOREIGN KEY (`Equipo_idEquipo`) REFERENCES `Equipo` (`idEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Competicion_has_Equipo`
--

LOCK TABLES `Competicion_has_Equipo` WRITE;
/*!40000 ALTER TABLE `Competicion_has_Equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Competicion_has_Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Equipo`
--

DROP TABLE IF EXISTS `Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Equipo` (
  `idEquipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `goles_favor` int DEFAULT '0',
  `goles_contra` int DEFAULT '0',
  `victorias` int DEFAULT '0',
  `empates` int DEFAULT '0',
  `derrotas` int DEFAULT '0',
  `puntuacion` int GENERATED ALWAYS AS (((`victorias` * 3) + `empates`)) VIRTUAL,
  `partidos` int GENERATED ALWAYS AS (((`victorias` + `empates`) + `derrotas`)) VIRTUAL,
  PRIMARY KEY (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Equipo`
--

LOCK TABLES `Equipo` WRITE;
/*!40000 ALTER TABLE `Equipo` DISABLE KEYS */;
INSERT INTO `Equipo` (`idEquipo`, `nombre`, `goles_favor`, `goles_contra`, `victorias`, `empates`, `derrotas`) VALUES (1,'Atletico de Madrid',0,0,0,0,0),(2,'Getafe',0,0,0,0,0),(3,'Valencia',0,0,0,0,0),(4,'Racing de Santander',0,0,0,0,0),(5,'Oviedo',0,0,0,0,0),(6,'Andorra FC',0,0,0,0,0),(7,'Er Betis',0,0,0,0,0);
/*!40000 ALTER TABLE `Equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Jugador`
--

DROP TABLE IF EXISTS `Jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Jugador` (
  `idJugador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `goles` int DEFAULT '0',
  `posicion` char(1) DEFAULT NULL,
  `idEquipo` int NOT NULL,
  PRIMARY KEY (`idJugador`),
  KEY `idEquipo` (`idEquipo`),
  CONSTRAINT `Jugador_ibfk_1` FOREIGN KEY (`idEquipo`) REFERENCES `Equipo` (`idEquipo`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Jugador`
--

LOCK TABLES `Jugador` WRITE;
/*!40000 ALTER TABLE `Jugador` DISABLE KEYS */;
INSERT INTO `Jugador` VALUES (1,'Joao','Felix',0,'F',1),(2,'Koke','Resurrección',0,'M',1),(3,'Mario','Hermoso',0,'D',1),(4,'Jan','Oblak',0,'P',1),(5,'Carles','Aleña',0,'M',2),(6,'Marc','Cucurella',0,'D',2),(7,'Ángel','Rodríguez',0,'F',2),(8,'Rubén','Yáñez',0,'P',2),(9,'Lee','Kang-in',0,'F',3),(10,'Mouctar','Diakhaby',0,'D',3),(11,'Carlos','Soler',0,'M',3),(12,'Jasper','Cillessen',0,'P',3),(13,'Iván','Crespo',0,'P',4),(14,'Cedric','Omoigui',0,'F',4),(15,'Alberto','Villapalos',0,'D',4),(16,'Álvaro','Cejudo',0,'M',4),(17,'Javier','Mier',0,'M',5),(18,'Alejandro','Arribas',0,'D',5),(19,'Joan','Femenías',0,'P',5),(20,'Marco','Sangalli',0,'F',5),(21,'Guillermo','Díaz',0,'F',6),(22,'Rubén','Doglas',0,'M',6),(23,'Samuel','de Luque',0,'D',6),(24,'Manuel','Fernández',0,'P',6),(25,'Claudio','Bravo',0,'P',7),(26,'Emerson','Royal',0,'D',7),(27,'Sergio','Canales',0,'M',7),(28,'Diego','Lainez',0,'F',7);
/*!40000 ALTER TABLE `Jugador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido`
--

DROP TABLE IF EXISTS `Partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Partido` (
  `idPartido` int NOT NULL,
  `idEquipoVisitante` int NOT NULL,
  `idEquipoLocal` int NOT NULL,
  `goles_local` int DEFAULT '0',
  `goles_visitante` int DEFAULT '0',
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`idPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido`
--

LOCK TABLES `Partido` WRITE;
/*!40000 ALTER TABLE `Partido` DISABLE KEYS */;
/*!40000 ALTER TABLE `Partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partido_has_Equipo`
--

DROP TABLE IF EXISTS `Partido_has_Equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Partido_has_Equipo` (
  `Partido_idPartido` int NOT NULL,
  `Equipo_idEquipo` int NOT NULL,
  PRIMARY KEY (`Partido_idPartido`,`Equipo_idEquipo`),
  KEY `fk_Partido_has_Equipo_Equipo1_idx` (`Equipo_idEquipo`),
  KEY `fk_Partido_has_Equipo_Partido1_idx` (`Partido_idPartido`),
  CONSTRAINT `fk_Partido_has_Equipo_Equipo1` FOREIGN KEY (`Equipo_idEquipo`) REFERENCES `Equipo` (`idEquipo`),
  CONSTRAINT `fk_Partido_has_Equipo_Partido1` FOREIGN KEY (`Partido_idPartido`) REFERENCES `Partido` (`idPartido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partido_has_Equipo`
--

LOCK TABLES `Partido_has_Equipo` WRITE;
/*!40000 ALTER TABLE `Partido_has_Equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Partido_has_Equipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-17  0:11:06
