-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: challenge
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `camiones`
--

DROP TABLE IF EXISTS `camiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `camiones` (
  `matricula` varchar(7) DEFAULT NULL,
  `carga` int(11) DEFAULT NULL,
  `tipo_mercancia` enum('G','A','P') DEFAULT NULL,
  KEY `matricula` (`matricula`),
  CONSTRAINT `camiones_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `vehiculos` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camiones`
--

LOCK TABLES `camiones` WRITE;
/*!40000 ALTER TABLE `camiones` DISABLE KEYS */;
INSERT INTO `camiones` VALUES ('2034GNM',400,'G'),('2432PDS',450,'P'),('3451SDF',1000,'G'),('4542LKJ',2000,'P');
/*!40000 ALTER TABLE `camiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coches`
--

DROP TABLE IF EXISTS `coches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coches` (
  `matricula` varchar(7) NOT NULL,
  `numero_puertas` int(11) DEFAULT NULL,
  `capacidad_maletero` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  CONSTRAINT `coches_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `vehiculos` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coches`
--

LOCK TABLES `coches` WRITE;
/*!40000 ALTER TABLE `coches` DISABLE KEYS */;
INSERT INTO `coches` VALUES ('2342FRT',5,'300'),('2412JNS',5,'300'),('3333GGF',3,'150'),('3341KND',5,'250'),('7463EBN',5,'300'),('8532CHJ',5,'250');
/*!40000 ALTER TABLE `coches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historial` (
  `id_historial` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(7) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `accion` enum('comprado','vendido','pintado') DEFAULT NULL,
  PRIMARY KEY (`id_historial`),
  KEY `matricula` (`matricula`),
  CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `vehiculos` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
INSERT INTO `historial` VALUES (1,'2412JNS','2019-05-22','comprado'),(2,'8532CHJ','2019-05-22','comprado'),(3,'3341KND','2019-05-22','comprado'),(4,'3341KND','2019-05-22','pintado'),(5,'3341KND','2019-05-22','vendido'),(6,'2034GNM','2019-05-22','comprado'),(7,'2432PDS','2019-05-22','comprado'),(8,'2412JNS','2019-05-24','pintado'),(9,'3333GGF','2019-05-24','comprado'),(10,'3333GGF','2019-05-24','vendido'),(11,'2412JNS','2019-05-24','pintado'),(12,'2342FRT','2019-05-24','comprado'),(13,'2432PDS','2019-05-24','vendido'),(14,'2034GNM','2019-05-24','vendido'),(15,'2412JNS','2019-05-24','vendido'),(16,'2034GNM','2019-05-24','comprado'),(17,'2342FRT','2019-05-24','pintado'),(18,'2412JNS','2019-05-24','comprado'),(19,'2432PDS','2019-05-24','comprado'),(20,'3333GGF','2019-05-24','comprado'),(21,'3341KND','2019-05-24','comprado'),(22,'8532CHJ','2019-05-24','pintado'),(23,'3333GGF','2019-05-24','vendido'),(24,'2432PDS','2019-05-24','vendido'),(25,'3451SDF','2019-05-24','comprado'),(26,'2412JNS','2019-05-27','vendido'),(27,'2034GNM','2019-05-27','pintado'),(28,'7463EBN','2019-05-27','comprado'),(29,'4542LKJ','2019-05-27','comprado'),(30,'2342FRT','2019-05-27','vendido'),(31,'8532CHJ','2019-05-27','vendido'),(32,'3341KND','2019-05-27','pintado'),(33,'3341KND','2019-05-27','pintado');
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `serie` (
  `id_serie` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(20) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `fecha_fabricacion` date DEFAULT NULL,
  PRIMARY KEY (`id_serie`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (1,'Ford','Fiesta','2014-10-04'),(2,'Ford','Fiesta','2010-02-12'),(3,'Renault','Magnum','2011-02-10'),(4,'Lancia','Ro','2012-02-23'),(5,'Tesla','S','2018-10-10'),(6,'Renault','Megane','2010-08-20'),(7,'MAN','TGM','2010-10-10'),(8,'Seat','Ibiza','2010-10-11'),(9,'MAN','TGM','2012-02-12');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculos` (
  `matricula` varchar(7) NOT NULL,
  `numero_bastidor` varchar(17) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `numero_asientos` int(11) DEFAULT NULL,
  `id_serie` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `disponibilidad` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`matricula`),
  UNIQUE KEY `numero_bastidor` (`numero_bastidor`),
  KEY `id_serie` (`id_serie`),
  CONSTRAINT `vehiculos_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `serie` (`id_serie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES ('2034GNM','1K2J1B8N5M3J6U5Y4','Blanco',2,3,40000,1),('2342FRT','6F7F8E9U0I8T6D3J6','Negro',5,6,20000,0),('2412JNS','2B1N4B4V3H9K8L7Y6','Azul',5,1,20000,0),('2432PDS','3B7S9E3J4B7M4H4J9','Verde',3,4,42000,0),('3333GGF','6H5J5K8D7H3G4H5G6','Azul',2,5,30000,0),('3341KND','2N4M2K4L5H6U7E9T8','Negro',5,2,22000,1),('3451SDF','5T7D6D8U4Y4T7R6T4','Azul',5,7,40000,1),('4542LKJ','3N4M5N2B4M9D8T8R7','Negro',2,9,100000,1),('7463EBN','5F8D2C5D7F3Z1Y8W9','Rojo',5,8,30000,1),('8532CHJ','1B8D9G7E6T4Y3U6B4','Azul',5,2,25000,0);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `despues_de_comprar` AFTER INSERT ON `vehiculos` FOR EACH ROW BEGIN
  
    insert into historial (matricula,fecha,accion) values(new.matricula,current_date(),"comprado");
    

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `despues_de_pintar_o_vender` AFTER UPDATE ON `vehiculos` FOR EACH ROW BEGIN
    if old.disponibilidad=new.disponibilidad then
    insert into historial (matricula,fecha,accion) values(old.matricula,current_date(),"pintado");
    
    elseif new.disponibilidad=true then
     insert into historial (matricula,fecha,accion) values(old.matricula,current_date(),"comprado");
    
    elseif new.disponibilidad=false then
     insert into historial (matricula,fecha,accion) values(old.matricula,current_date(),"vendido");
    end if;
    
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-27  9:33:54
