CREATE DATABASE  IF NOT EXISTS `hotelmanagerDB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotelmanagerDB`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: test.motopoliza.com    Database: hotelmanagerDB
-- ------------------------------------------------------
-- Server version	5.5.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idclientes` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(10) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `1apellido` varchar(45) DEFAULT NULL,
  `2apellido` varchar(45) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  `telefono` int(9) DEFAULT NULL,
  PRIMARY KEY (`idclientes`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'83214','asdasd','asdasd','asdasd','asdasd',0,454545),(2,'21840','Editado','editada','asdasd','asdasd',1,454545),(3,'72321','asdasd','asdasd','asdasd','asdasd',1,454545),(4,'75542','Editado','editada','asdasd','asdasd',1,454545),(5,'45212','asdasd','direccion','asdasd','asdasd',0,454545),(6,'24741','asdasd','direccion','asdasd','asdasd',1,454545),(7,'53802','asdasd','direccion','asdasd','asdasd',1,454545),(8,'84521','asdasd','direccion','asdasd','asdasd',1,454545),(9,'10956','asdasd','direccion','asdasd','asdasd',1,454545),(10,'49996','asdasd','direccion','asdasd','asdasd',1,454545),(11,'9059','asdasd','direccion','asdasd','asdasd',1,454545),(12,'27282','asdasd','direccion','asdasd','asdasd',1,454545),(13,'32341','asdasd','testcommand','asdasd','asdasd',1,78285),(14,'9221','asdasd','testcommand','asdasd','asdasd',0,53765),(15,'43121','asdasd','asdasd','asdasd','asdasd',0,454545),(16,'30','Editado','editada','asdasd','asdasd',1,454545),(17,'68415','asdasd','asdasd','asdasd','asdasd',1,454545),(18,'43631','Editado','editada','asdasd','asdasd',1,454545),(19,'1316','asdasd','direccion','asdasd','asdasd',0,454545),(20,'70648','asdasd','direccion','asdasd','asdasd',1,454545),(21,'28834','asdasd','direccion','asdasd','asdasd',1,454545),(22,'14906','asdasd','direccion','asdasd','asdasd',1,454545),(23,'59316','asdasd','direccion','asdasd','asdasd',1,454545),(24,'9370','asdasd','direccion','asdasd','asdasd',1,454545),(25,'88615','asdasd','direccion','asdasd','asdasd',1,454545),(26,'95300','asdasd','direccion','asdasd','asdasd',1,454545),(27,'23268','asdasd','testcommand','asdasd','asdasd',1,713),(28,'38300','asdasd','testcommand','asdasd','asdasd',0,20935),(29,'55555','a','a','a','a',1,11),(30,'94335','asdasd','asdasd','asdasd','asdasd',0,454545),(31,'90614','Editado','editada','asdasd','asdasd',1,454545),(32,'7479','asdasd','asdasd','asdasd','asdasd',1,454545),(33,'9438','Editado','editada','asdasd','asdasd',1,454545),(34,'17932','asdasd','direccion','asdasd','asdasd',0,454545),(35,'59840','asdasd','direccion','asdasd','asdasd',1,454545),(36,'64209','asdasd','direccion','asdasd','asdasd',1,454545),(37,'33126','asdasd','direccion','asdasd','asdasd',1,454545),(38,'65938','asdasd','direccion','asdasd','asdasd',1,454545),(39,'38183','asdasd','direccion','asdasd','asdasd',1,454545),(40,'98467','asdasd','direccion','asdasd','asdasd',1,454545),(41,'10217','asdasd','direccion','asdasd','asdasd',1,454545),(42,'30462','asdasd','testcommand','asdasd','asdasd',1,53123),(43,'8660','asdasd','testcommand','asdasd','asdasd',0,99262),(44,'64184','asdasd','asdasd','asdasd','asdasd',0,454545),(45,'14224','Editado','editada','asdasd','asdasd',1,454545),(46,'2515','asdasd','asdasd','asdasd','asdasd',1,454545),(47,'5151','asdasd','asdasd','asdasd','asdasd',0,454545),(48,'16223','Editado','editada','asdasd','asdasd',1,454545),(49,'47717','asdasd','asdasd','asdasd','asdasd',1,454545),(50,'87716','asdasd','asdasd','asdasd','asdasd',0,454545),(51,'16904','Editado','editada','asdasd','asdasd',1,454545),(52,'90219','asdasd','asdasd','asdasd','asdasd',1,454545),(53,'77035','asdasd','asdasd','asdasd','asdasd',0,454545),(54,'18463','Editado','editada','asdasd','asdasd',1,454545),(55,'67249','asdasd','asdasd','asdasd','asdasd',1,454545),(56,'94453','asdasd','asdasd','asdasd','asdasd',0,454545),(57,'55504','Editado','editada','asdasd','asdasd',1,454545),(58,'93320','asdasd','asdasd','asdasd','asdasd',1,454545),(59,'66954','asdasd','asdasd','asdasd','asdasd',0,454545),(60,'73883','Editado','editada','asdasd','asdasd',1,454545),(61,'27462','asdasd','asdasd','asdasd','asdasd',1,454545),(62,'63374','asdasd','asdasd','asdasd','asdasd',0,454545),(63,'58886','Editado','editada','asdasd','asdasd',1,454545),(64,'86264','asdasd','asdasd','asdasd','asdasd',1,454545),(65,'96607','asdasd','asdasd','asdasd','asdasd',0,454545),(66,'71600','Editado','editada','asdasd','asdasd',1,454545),(67,'12189','asdasd','asdasd','asdasd','asdasd',1,454545),(68,'21357','Editado','editada','asdasd','asdasd',1,454545),(69,'74367','asdasd','direccion','asdasd','asdasd',0,454545),(70,'62577','asdasd','direccion','asdasd','asdasd',1,454545),(71,'56291','asdasd','direccion','asdasd','asdasd',1,454545),(72,'22242','asdasd','direccion','asdasd','asdasd',1,454545),(73,'24541','asdasd','direccion','asdasd','asdasd',1,454545),(74,'10470','asdasd','direccion','asdasd','asdasd',1,454545),(75,'31666','asdasd','direccion','asdasd','asdasd',1,454545),(76,'91700','asdasd','direccion','asdasd','asdasd',1,454545),(77,'80957','asdasd','testcommand','asdasd','asdasd',1,31651),(78,'72142','asdasd','testcommand','asdasd','asdasd',0,73528),(79,'36729','asdasd','asdasd','asdasd','asdasd',0,454545),(80,'74690','Editado','editada','asdasd','asdasd',1,454545),(81,'66214','asdasd','asdasd','asdasd','asdasd',1,454545),(82,'1019','Editado','editada','asdasd','asdasd',1,454545),(83,'32649','asdasd','direccion','asdasd','asdasd',0,454545),(84,'17508','asdasd','direccion','asdasd','asdasd',1,454545),(85,'21223','asdasd','direccion','asdasd','asdasd',1,454545),(86,'36252','asdasd','direccion','asdasd','asdasd',1,454545),(87,'60183','asdasd','direccion','asdasd','asdasd',1,454545),(88,'91956','asdasd','direccion','asdasd','asdasd',1,454545),(89,'43155','asdasd','direccion','asdasd','asdasd',1,454545),(90,'56360','asdasd','direccion','asdasd','asdasd',1,454545),(91,'3485','asdasd','testcommand','asdasd','asdasd',1,68321),(92,'49706','asdasd','testcommand','asdasd','asdasd',0,15383),(93,'16296','asdasd','asdasd','asdasd','asdasd',0,454545),(94,'87014','Editado','editada','asdasd','asdasd',1,454545),(95,'59681','asdasd','asdasd','asdasd','asdasd',1,454545),(96,'13101','Editado','editada','asdasd','asdasd',1,454545),(97,'60316','asdasd','direccion','asdasd','asdasd',0,454545),(98,'59339','asdasd','direccion','asdasd','asdasd',1,454545),(99,'15061','asdasd','direccion','asdasd','asdasd',1,454545),(100,'19596','asdasd','direccion','asdasd','asdasd',1,454545),(101,'10067','asdasd','direccion','asdasd','asdasd',1,454545),(102,'26410','asdasd','direccion','asdasd','asdasd',1,454545),(103,'91106','asdasd','direccion','asdasd','asdasd',1,454545),(104,'70099','asdasd','direccion','asdasd','asdasd',1,454545),(105,'9088','asdasd','testcommand','asdasd','asdasd',1,54920),(106,'2735','asdasd','testcommand','asdasd','asdasd',0,95421),(107,'11335','asdasd','asdasd','asdasd','asdasd',0,454545),(108,'95445','Editado','editada','asdasd','asdasd',1,454545),(109,'73977','asdasd','asdasd','asdasd','asdasd',1,454545),(110,'69329','asdasd','asdasd','asdasd','asdasd',0,454545),(111,'81738','Editado','editada','asdasd','asdasd',1,454545),(112,'19294','asdasd','asdasd','asdasd','asdasd',1,454545),(113,'37669','Editado','editada','asdasd','asdasd',1,454545),(114,'48960','asdasd','direccion','asdasd','asdasd',0,454545),(115,'39723','asdasd','direccion','asdasd','asdasd',1,454545),(116,'89961','asdasd','direccion','asdasd','asdasd',1,454545),(117,'45186','asdasd','direccion','asdasd','asdasd',1,454545),(118,'21463','asdasd','direccion','asdasd','asdasd',1,454545),(119,'73243','asdasd','direccion','asdasd','asdasd',1,454545),(120,'37622','asdasd','direccion','asdasd','asdasd',1,454545),(121,'38114','asdasd','direccion','asdasd','asdasd',1,454545),(122,'40050','asdasd','testcommand','asdasd','asdasd',1,81946),(123,'71200','asdasd','testcommand','asdasd','asdasd',0,77192),(124,'77072','asdasd','asdasd','asdasd','asdasd',0,454545),(125,'71069','Editado','editada','asdasd','asdasd',1,454545),(126,'85698','asdasd','asdasd','asdasd','asdasd',1,454545),(127,'60745','Editado','editada','asdasd','asdasd',1,454545),(128,'72969','asdasd','direccion','asdasd','asdasd',0,454545),(129,'49380','asdasd','direccion','asdasd','asdasd',1,454545),(130,'80509','asdasd','direccion','asdasd','asdasd',1,454545),(131,'86496','asdasd','direccion','asdasd','asdasd',1,454545),(132,'75019','asdasd','direccion','asdasd','asdasd',1,454545),(133,'92839','asdasd','direccion','asdasd','asdasd',1,454545),(134,'98698','asdasd','direccion','asdasd','asdasd',1,454545),(135,'29806','asdasd','direccion','asdasd','asdasd',1,454545),(136,'3782','asdasd','testcommand','asdasd','asdasd',1,76312),(137,'87921','asdasd','testcommand','asdasd','asdasd',0,62156),(138,'4280','asdasd','asdasd','asdasd','asdasd',0,454545),(139,'80015','Editado','editada','asdasd','asdasd',1,454545),(140,'84693','asdasd','asdasd','asdasd','asdasd',1,454545),(141,'93456','asdasd','asdasd','asdasd','asdasd',0,454545),(142,'72598','Editado','editada','asdasd','asdasd',1,454545),(143,'43681','asdasd','asdasd','asdasd','asdasd',1,454545),(144,'27116','Editado','editada','asdasd','asdasd',1,454545),(145,'30989','asdasd','direccion','asdasd','asdasd',0,454545),(146,'8882','asdasd','direccion','asdasd','asdasd',1,454545),(147,'38905','asdasd','direccion','asdasd','asdasd',1,454545),(148,'27664','asdasd','direccion','asdasd','asdasd',1,454545),(149,'43547','asdasd','direccion','asdasd','asdasd',1,454545),(150,'90750','asdasd','direccion','asdasd','asdasd',1,454545),(151,'18360','asdasd','direccion','asdasd','asdasd',1,454545),(152,'47598','asdasd','direccion','asdasd','asdasd',1,454545),(153,'25968','asdasd','testcommand','asdasd','asdasd',1,27422),(154,'69451','asdasd','testcommand','asdasd','asdasd',0,64807),(155,'29212','asdasd','direccion','asdasd','asdasd',1,454545),(156,'91183','asdasd','direccion','asdasd','asdasd',1,454545),(157,'64126','asdasd','direccion','asdasd','asdasd',1,454545),(158,'92935','asdasd','direccion','asdasd','asdasd',1,454545),(159,'32674','asdasd','direccion','asdasd','asdasd',1,454545),(160,'59246','asdasd','testcommand','asdasd','asdasd',1,49996),(161,'78373','asdasd','testcommand','asdasd','asdasd',0,31728),(162,'52122','asdasd','asdasd','asdasd','asdasd',0,454545),(163,'72636','Editado','editada','asdasd','asdasd',1,454545),(164,'26733','asdasd','asdasd','asdasd','asdasd',1,454545),(165,'93006','asdasd','direccion','asdasd','asdasd',1,454545),(166,'96489','asdasd','direccion','asdasd','asdasd',1,454545),(167,'21131','Editado','editada','asdasd','asdasd',1,454545),(168,'12663','asdasd','direccion','asdasd','asdasd',0,454545),(169,'17043','asdasd','direccion','asdasd','asdasd',1,454545),(170,'32524','asdasd','direccion','asdasd','asdasd',1,454545),(171,'64893','asdasd','asdasd','asdasd','asdasd',0,454545),(172,'55369','Editado','editada','asdasd','asdasd',1,454545),(173,'61791','asdasd','asdasd','asdasd','asdasd',1,454545),(174,'86119','Editado','editada','asdasd','asdasd',1,454545),(175,'13038','asdasd','direccion','asdasd','asdasd',0,454545),(176,'91999','asdasd','direccion','asdasd','asdasd',1,454545),(177,'46284','asdasd','direccion','asdasd','asdasd',1,454545),(178,'18929','asdasd','direccion','asdasd','asdasd',1,454545),(179,'83599','asdasd','direccion','asdasd','asdasd',1,454545),(180,'76109','asdasd','direccion','asdasd','asdasd',1,454545),(181,'58226','asdasd','direccion','asdasd','asdasd',1,454545),(182,'95825','asdasd','direccion','asdasd','asdasd',1,454545),(183,'12297','asdasd','testcommand','asdasd','asdasd',1,12225),(184,'91938','asdasd','testcommand','asdasd','asdasd',0,14885),(185,'67787','asdasd','asdasd','asdasd','asdasd',0,454545),(186,'9809','Editado','editada','asdasd','asdasd',1,454545),(187,'3060','asdasd','asdasd','asdasd','asdasd',1,454545),(188,'79064','asdasd','asdasd','asdasd','asdasd',0,454545),(189,'44165','Editado','editada','asdasd','asdasd',1,454545),(190,'4629','asdasd','asdasd','asdasd','asdasd',1,454545),(191,'58207','asdasd','asdasd','asdasd','asdasd',0,454545),(192,'91782','Editado','editada','asdasd','asdasd',1,454545),(193,'25843','asdasd','asdasd','asdasd','asdasd',1,454545),(194,'53453','asdasd','asdasd','asdasd','asdasd',0,454545),(195,'33402','Editado','editada','asdasd','asdasd',1,454545),(196,'45560','asdasd','asdasd','asdasd','asdasd',1,454545),(197,'86551','Editado','editada','asdasd','asdasd',1,454545),(198,'17662','asdasd','direccion','asdasd','asdasd',0,454545),(199,'70619','asdasd','direccion','asdasd','asdasd',1,454545),(200,'37180','asdasd','direccion','asdasd','asdasd',1,454545),(201,'22404','asdasd','direccion','asdasd','asdasd',1,454545),(202,'51930','asdasd','direccion','asdasd','asdasd',1,454545),(203,'18507','asdasd','direccion','asdasd','asdasd',1,454545),(204,'96898','asdasd','direccion','asdasd','asdasd',1,454545),(205,'22725','asdasd','direccion','asdasd','asdasd',1,454545),(206,'75778','Editado','editada','asdasd','asdasd',1,454545),(207,'91749','asdasd','direccion','asdasd','asdasd',0,454545),(208,'20947','asdasd','direccion','asdasd','asdasd',1,454545),(209,'77796','asdasd','direccion','asdasd','asdasd',1,454545),(210,'10113','asdasd','direccion','asdasd','asdasd',1,454545),(211,'61606','asdasd','testcommand','asdasd','asdasd',1,19185),(212,'5203','asdasd','direccion','asdasd','asdasd',1,454545),(213,'32975','asdasd','testcommand','asdasd','asdasd',0,86932),(214,'33319','asdasd','direccion','asdasd','asdasd',1,454545),(215,'80664','asdasd','direccion','asdasd','asdasd',1,454545),(216,'98243','asdasd','direccion','asdasd','asdasd',1,454545),(217,'70539','asdasd','direccion','asdasd','asdasd',1,454545),(218,'10658','asdasd','direccion','asdasd','asdasd',1,454545),(219,'9012','asdasd','direccion','asdasd','asdasd',1,454545),(220,'28559','asdasd','testcommand','asdasd','asdasd',1,22174),(221,'52262','asdasd','direccion','asdasd','asdasd',1,454545),(222,'65318','asdasd','testcommand','asdasd','asdasd',0,48583),(223,'54877','asdasd','direccion','asdasd','asdasd',1,454545),(224,'59000','asdasd','testcommand','asdasd','asdasd',1,99565),(225,'87155','asdasd','testcommand','asdasd','asdasd',0,42069),(226,'35104','asdasd','asdasd','asdasd','asdasd',0,454545),(227,'44221','asdasd','asdasd','asdasd','asdasd',1,454545);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departamentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `NOMBRE` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_departamentos_0` (`NOMBRE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,1,'2',1);
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DTYPE` varchar(31) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `NOMBRE` varchar(255) DEFAULT NULL,
  `PRIMERAPELLIDO` varchar(255) DEFAULT NULL,
  `SEGUNDOAPELLIDO` varchar(255) DEFAULT NULL,
  `TIPO` int(11) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  `DEPARTAMENTO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_empleados_0` (`DNI`),
  KEY `FK_empleados_DEPARTAMENTO_ID` (`DEPARTAMENTO_ID`),
  CONSTRAINT `FK_empleados_DEPARTAMENTO_ID` FOREIGN KEY (`DEPARTAMENTO_ID`) REFERENCES `departamentos` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'EmpleadoTotal','23',1,'32','32','32',0,1,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `tareas`
--

DROP TABLE IF EXISTS `tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tareas` (
  `ID` int(11) NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `VERSION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UNQ_tareas_0` (`NOMBRE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tareas`
--

LOCK TABLES `tareas` WRITE;
/*!40000 ALTER TABLE `tareas` DISABLE KEYS */;
/*!40000 ALTER TABLE `tareas` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `empleadoparcial`
--

DROP TABLE IF EXISTS `empleadoparcial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleadoparcial` (
  `ID` int(11) NOT NULL,
  `HORAS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_EMPLEADOPARCIAL_ID` FOREIGN KEY (`ID`) REFERENCES `empleados` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadoparcial`
--

LOCK TABLES `empleadoparcial` WRITE;
/*!40000 ALTER TABLE `empleadoparcial` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleadoparcial` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `empleados_tareas`
--

DROP TABLE IF EXISTS `empleados_tareas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados_tareas` (
  `listaEmpleados_ID` int(11) NOT NULL,
  `tarea_ID` int(11) NOT NULL,
  PRIMARY KEY (`listaEmpleados_ID`,`tarea_ID`),
  KEY `FK_empleados_tareas_tarea_ID` (`tarea_ID`),
  CONSTRAINT `FK_empleados_tareas_listaEmpleados_ID` FOREIGN KEY (`listaEmpleados_ID`) REFERENCES `empleados` (`ID`),
  CONSTRAINT `FK_empleados_tareas_tarea_ID` FOREIGN KEY (`tarea_ID`) REFERENCES `tareas` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados_tareas`
--

LOCK TABLES `empleados_tareas` WRITE;
/*!40000 ALTER TABLE `empleados_tareas` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleados_tareas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadototal`
--

DROP TABLE IF EXISTS `empleadototal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleadototal` (
  `ID` int(11) NOT NULL,
  `PLAZAAPARCAMIENTO` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_EMPLEADOTOTAL_ID` FOREIGN KEY (`ID`) REFERENCES `empleados` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadototal`
--

LOCK TABLES `empleadototal` WRITE;
/*!40000 ALTER TABLE `empleadototal` DISABLE KEYS */;
INSERT INTO `empleadototal` VALUES (1,0);
/*!40000 ALTER TABLE `empleadototal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitaciones` (
  `numhabitacion` int(11) NOT NULL,
  `tipohabitacion` enum('HABITACION_NORMAL','HABITACION_SUITE') DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `activo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`numhabitacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
INSERT INTO `habitaciones` VALUES (237,'HABITACION_NORMAL',0.5278815341454143,1),(420,'HABITACION_NORMAL',0.32045840188469554,1),(831,'HABITACION_NORMAL',0.5093057967563425,1),(2447,'HABITACION_NORMAL',0.6970282027529164,1),(2682,'HABITACION_NORMAL',0.8037158428529425,1),(3057,'HABITACION_NORMAL',0.09070807498772737,1),(3534,'HABITACION_NORMAL',0.5425324734837984,1),(3889,'HABITACION_NORMAL',0.45948576129939267,1),(3897,'HABITACION_NORMAL',0,1),(4044,'HABITACION_NORMAL',0.8465936576811399,0),(4781,'HABITACION_NORMAL',0.8145294922520976,0),(5098,'HABITACION_NORMAL',0.6431031151120687,1),(5477,'HABITACION_NORMAL',0,1),(5734,'HABITACION_NORMAL',0.8775209234716057,1),(6189,'HABITACION_NORMAL',0.5618698640074201,0),(6224,'HABITACION_NORMAL',0.7399749301341818,0),(6373,'HABITACION_NORMAL',0.8808940634538303,1),(7289,'HABITACION_NORMAL',0.1443341629406899,1),(7698,'HABITACION_NORMAL',0.6729361851381953,1),(7772,'HABITACION_NORMAL',0.2151150174937635,1),(8118,'HABITACION_NORMAL',0.7512894666938567,0),(8384,'HABITACION_NORMAL',0.28710104049869156,1),(8451,'HABITACION_NORMAL',0.6937756029927292,1),(8556,'HABITACION_NORMAL',0.6736310402532317,0),(9116,'HABITACION_NORMAL',0,1),(9738,'HABITACION_NORMAL',0.7991987923866425,1),(10766,'HABITACION_NORMAL',0.2786908587279199,1),(11255,'HABITACION_NORMAL',0.7597745505138076,1),(11904,'HABITACION_NORMAL',0.622402804618673,1),(12255,'HABITACION_NORMAL',0.3461518082419399,1),(12661,'HABITACION_NORMAL',0.992742400548037,1),(13045,'HABITACION_NORMAL',0,1),(13257,'HABITACION_NORMAL',0.6438261995939449,0),(14197,'HABITACION_NORMAL',0.3858756741423841,1),(15271,'HABITACION_NORMAL',0.16818229744093782,0),(16031,'HABITACION_NORMAL',0.6917679072263601,0),(16173,'HABITACION_NORMAL',0.8809154139859457,1),(17857,'HABITACION_NORMAL',0.8357150560531197,1),(18144,'HABITACION_NORMAL',0.8281316171372081,1),(18243,'HABITACION_NORMAL',0.34375474828029395,1),(18524,'HABITACION_NORMAL',0,1),(18553,'HABITACION_NORMAL',0.6755607136096878,1),(18786,'HABITACION_NORMAL',0.49207333751893545,1),(19350,'HABITACION_NORMAL',0.5991466429789847,0),(19900,'HABITACION_NORMAL',0.14798636524218622,0),(20026,'HABITACION_NORMAL',0.935006934620336,0),(20124,'HABITACION_NORMAL',0,1),(20242,'HABITACION_NORMAL',0.8541235977114572,1),(20685,'HABITACION_NORMAL',0.6284194967358089,1),(22787,'HABITACION_NORMAL',0,1),(23043,'HABITACION_NORMAL',0.002203346810760509,1),(24169,'HABITACION_NORMAL',0,1),(24660,'HABITACION_NORMAL',0.18887372824638948,1),(24858,'HABITACION_NORMAL',0.2501849059347695,1),(25526,'HABITACION_NORMAL',0.04830118369266134,1),(25616,'HABITACION_NORMAL',0.708676963699761,0),(27151,'HABITACION_NORMAL',0.33392100590861784,1),(27518,'HABITACION_NORMAL',0.7466331238235595,1),(27528,'HABITACION_NORMAL',0.020091331890885744,0),(27735,'HABITACION_NORMAL',0.28024252524097326,1),(29274,'HABITACION_NORMAL',0.21586267832133932,0),(29391,'HABITACION_NORMAL',0.9734890414021309,0),(29458,'HABITACION_NORMAL',0,1),(29773,'HABITACION_NORMAL',0.1942832312647731,1),(31046,'HABITACION_NORMAL',0,1),(31368,'HABITACION_NORMAL',0.24883646277388638,1),(31783,'HABITACION_NORMAL',0.07964524949040108,1),(32565,'HABITACION_NORMAL',0.08878358135380915,1),(32658,'HABITACION_NORMAL',0.8737597691525777,0),(33369,'HABITACION_NORMAL',0.7084911378813428,1),(34081,'HABITACION_NORMAL',0,1),(36202,'HABITACION_NORMAL',0,1),(36488,'HABITACION_NORMAL',0.5266900097204521,1),(36693,'HABITACION_NORMAL',0.3143893304330475,1),(37291,'HABITACION_NORMAL',0.3821128556352227,0),(37859,'HABITACION_NORMAL',0.10060495559214233,1),(38698,'HABITACION_NORMAL',0.25806307591934585,1),(39321,'HABITACION_NORMAL',0.6095726221253134,1),(39613,'HABITACION_NORMAL',0.11927845587814045,0),(39666,'HABITACION_NORMAL',0.651992490884068,1),(40092,'HABITACION_NORMAL',0.880394466753893,1),(41186,'HABITACION_NORMAL',0.30630410427729016,1),(43124,'HABITACION_NORMAL',0,1),(43805,'HABITACION_NORMAL',0.7053574581438662,1),(44130,'HABITACION_NORMAL',0.2192553318880074,0),(44455,'HABITACION_NORMAL',0.5692963545231468,0),(44793,'HABITACION_NORMAL',0.21101564255464578,1),(45301,'HABITACION_NORMAL',0.5153374126555622,1),(46101,'HABITACION_NORMAL',0,1),(46683,'HABITACION_NORMAL',0,1),(46943,'HABITACION_NORMAL',0.8919942286940838,1),(47082,'HABITACION_NORMAL',0,1),(47108,'HABITACION_NORMAL',0.11084389161135833,1),(47594,'HABITACION_NORMAL',0.8487787445027591,1),(47985,'HABITACION_NORMAL',0.23468648390222446,0),(48155,'HABITACION_NORMAL',0.8730246850782472,1),(48436,'HABITACION_NORMAL',0.25474893229755524,1),(48520,'HABITACION_NORMAL',0,1),(48676,'HABITACION_NORMAL',0.6216449323956715,1),(48696,'HABITACION_NORMAL',0,1),(48709,'HABITACION_NORMAL',0.7032249550199241,1),(48765,'HABITACION_NORMAL',0.13101130809108563,1),(48872,'HABITACION_NORMAL',0.6840753820889937,1),(49011,'HABITACION_NORMAL',0.3214729200808202,1),(49363,'HABITACION_NORMAL',0,1),(49365,'HABITACION_NORMAL',0.13519691945645218,1),(49440,'HABITACION_NORMAL',0.5685361386649821,0),(49847,'HABITACION_NORMAL',0.09979251259963684,0),(50460,'HABITACION_NORMAL',0.923472242682124,1),(50528,'HABITACION_NORMAL',0.7364943953244567,1),(51941,'HABITACION_NORMAL',0,1),(52656,'HABITACION_NORMAL',0.8823277160402923,1),(52958,'HABITACION_NORMAL',0.19605930394811633,0),(53116,'HABITACION_NORMAL',0.9043216081069702,1),(53530,'HABITACION_NORMAL',0.4499281037109445,1),(53559,'HABITACION_NORMAL',0.2988441532101124,1),(53580,'HABITACION_NORMAL',0.0650733166957268,1),(55087,'HABITACION_NORMAL',0.6026530764354194,1),(55739,'HABITACION_NORMAL',0.2912314740753532,1),(55764,'HABITACION_NORMAL',0.32754288975434065,1),(55995,'HABITACION_NORMAL',0.8050933779667204,1),(56346,'HABITACION_NORMAL',0,1),(56449,'HABITACION_NORMAL',0,1),(57135,'HABITACION_NORMAL',0.5889514254268857,0),(57967,'HABITACION_NORMAL',0.6276503461534387,1),(58132,'HABITACION_NORMAL',0.6567814776561067,1),(58439,'HABITACION_NORMAL',0,1),(58946,'HABITACION_NORMAL',0,1),(58969,'HABITACION_NORMAL',0.44218552904740327,1),(59071,'HABITACION_NORMAL',0.6748818165937412,0),(59488,'HABITACION_NORMAL',0.8734328923451934,1),(59522,'HABITACION_NORMAL',0.6943211006029782,0),(60228,'HABITACION_NORMAL',0.4270422531238405,1),(60258,'HABITACION_NORMAL',0.4578712138045137,0),(60962,'HABITACION_NORMAL',0.6537784790820357,1),(61540,'HABITACION_NORMAL',0.7606970375107761,1),(61807,'HABITACION_NORMAL',0.014820310117461877,1),(62051,'HABITACION_NORMAL',0.6682141111895915,1),(62239,'HABITACION_NORMAL',0.8364703423811529,1),(62759,'HABITACION_NORMAL',0,1),(62942,'HABITACION_NORMAL',0.9672199018755104,0),(63363,'HABITACION_NORMAL',0.4656023876756714,1),(64327,'HABITACION_NORMAL',0.4945281479512035,1),(64440,'HABITACION_NORMAL',0,1),(65191,'HABITACION_NORMAL',0.0621635047066188,0),(66935,'HABITACION_NORMAL',0,1),(67076,'HABITACION_NORMAL',0.9370729672011394,1),(67323,'HABITACION_NORMAL',0.7702293520095664,1),(67516,'HABITACION_NORMAL',0.37252018443315926,1),(67753,'HABITACION_NORMAL',0.43846126095091875,1),(68327,'HABITACION_NORMAL',0.00870776878230306,1),(68395,'HABITACION_NORMAL',0.8050308942559143,1),(69422,'HABITACION_NORMAL',0,1),(70441,'HABITACION_NORMAL',0.6785573043055677,0),(70515,'HABITACION_NORMAL',0,1),(71940,'HABITACION_NORMAL',0.06721327814328915,0),(72674,'HABITACION_NORMAL',0,1),(72748,'HABITACION_NORMAL',0.05968736911101258,0),(73062,'HABITACION_NORMAL',0.4863621179355587,1),(73682,'HABITACION_NORMAL',0.5030079806172207,1),(74094,'HABITACION_NORMAL',0,1),(74633,'HABITACION_NORMAL',0.16300864109203805,0),(74718,'HABITACION_NORMAL',0.5835563517125663,0),(75100,'HABITACION_NORMAL',0.85938301608125,1),(75376,'HABITACION_NORMAL',0.3369865048842575,1),(75568,'HABITACION_NORMAL',0.11311035536414327,1),(75825,'HABITACION_NORMAL',0.9880252296771573,1),(76400,'HABITACION_NORMAL',0.5147829613539486,0),(76729,'HABITACION_NORMAL',0.6817154193938038,1),(76741,'HABITACION_NORMAL',0.3452919169586608,1),(76954,'HABITACION_NORMAL',0.40442434201994126,1),(77939,'HABITACION_NORMAL',0.7608975917958553,1),(78809,'HABITACION_NORMAL',0.9145030607163598,1),(79739,'HABITACION_NORMAL',0.9651995877014373,1),(79871,'HABITACION_NORMAL',0.10909342923649923,1),(80400,'HABITACION_NORMAL',0.40617730094417037,0),(80462,'HABITACION_NORMAL',0.2557808465208826,1),(80745,'HABITACION_NORMAL',0.33873613342896014,1),(81234,'HABITACION_NORMAL',0.67986569874804,1),(82064,'HABITACION_NORMAL',0.18836671246313297,1),(82519,'HABITACION_NORMAL',0,1),(82890,'HABITACION_NORMAL',0.9587589934358848,0),(83729,'HABITACION_NORMAL',0.6687249528052602,1),(84502,'HABITACION_NORMAL',0.8680613188505741,1),(84958,'HABITACION_NORMAL',0.5628964300286993,1),(86719,'HABITACION_NORMAL',0.6886285917680788,1),(86816,'HABITACION_NORMAL',0,1),(87126,'HABITACION_NORMAL',0.406412987237906,1),(87131,'HABITACION_NORMAL',0.635434105948718,0),(87543,'HABITACION_NORMAL',0.09100830823226636,1),(87648,'HABITACION_NORMAL',0.12516881753071096,1),(87950,'HABITACION_NORMAL',0.6697436389683189,1),(88608,'HABITACION_NORMAL',0.03852737220991842,1),(88688,'HABITACION_NORMAL',0.18172017160300302,1),(88789,'HABITACION_NORMAL',0.22728211707182655,1),(89103,'HABITACION_NORMAL',0.1903792663186621,0),(89164,'HABITACION_NORMAL',0.31976731150506876,1),(89735,'HABITACION_NORMAL',0.49101959449366384,1),(89970,'HABITACION_NORMAL',0.39349525396369667,1),(90218,'HABITACION_NORMAL',0.759384862750733,1),(90567,'HABITACION_NORMAL',0.7900926153091987,0),(90657,'HABITACION_NORMAL',0,1),(91218,'HABITACION_NORMAL',0.8776076532735445,1),(91418,'HABITACION_NORMAL',0.1694972978814997,1),(92998,'HABITACION_NORMAL',0,1),(93043,'HABITACION_NORMAL',0.3603498861246768,1),(93090,'HABITACION_NORMAL',0.6593315286806596,1),(93286,'HABITACION_NORMAL',0.9221653382100338,1),(93779,'HABITACION_NORMAL',0.06467734481696796,0),(95399,'HABITACION_NORMAL',0,1),(96814,'HABITACION_NORMAL',0.6780078509454035,0),(96823,'HABITACION_NORMAL',0.03299109443910275,0),(97399,'HABITACION_NORMAL',0.9644195553954529,1),(97769,'HABITACION_NORMAL',0.17737223159214266,1),(98555,'HABITACION_NORMAL',0.1575617013649281,0),(98694,'HABITACION_NORMAL',0.03937593065300271,0),(99247,'HABITACION_NORMAL',0.9310841817969366,1),(99303,'HABITACION_NORMAL',0.6442553716950541,0);
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `idreservas` int(11) NOT NULL AUTO_INCREMENT,
  `clientes_idclientes` int(11) NOT NULL,
  `habitaciones_numhabitacion` int(11) NOT NULL,
  `fecha_reserva` datetime NOT NULL,
  `fecha_entrada` datetime DEFAULT NULL,
  `fecha_salida` datetime DEFAULT NULL,
  PRIMARY KEY (`clientes_idclientes`,`fecha_reserva`),
  UNIQUE KEY `idreservas_UNIQUE` (`idreservas`),
  KEY `fk_reservas_clientes_idx` (`clientes_idclientes`),
  KEY `fk_reservas_habitaciones1_idx` (`habitaciones_numhabitacion`),
  CONSTRAINT `fk_reservas_clientes` FOREIGN KEY (`clientes_idclientes`) REFERENCES `clientes` (`idclientes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_habitaciones1` FOREIGN KEY (`habitaciones_numhabitacion`) REFERENCES `habitaciones` (`numhabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,8,67516,'2014-01-24 19:42:24','2014-01-24 00:00:00','2014-01-24 00:00:00'),(2,9,9738,'2014-01-24 19:42:25','2014-01-24 00:00:00','2014-01-24 00:00:00'),(3,10,91418,'2014-01-24 00:00:00',NULL,NULL),(5,12,88688,'2014-01-24 19:42:26','2014-01-24 00:00:00','2014-01-24 00:00:00'),(6,22,11904,'2014-01-25 00:43:28','2014-01-25 00:00:00','2014-01-25 00:00:00'),(7,23,68327,'2014-01-25 00:43:29','2014-01-25 00:00:00','2014-01-25 00:00:00'),(8,24,48676,'2014-01-25 00:00:00',NULL,NULL),(10,26,48436,'2014-01-25 00:43:31','2014-01-25 00:00:00','2014-01-25 00:00:00'),(11,37,80745,'2014-01-25 14:30:17','2014-01-25 00:00:00','2014-01-25 00:00:00'),(12,38,8451,'2014-01-25 14:30:18','2014-01-25 00:00:00','2014-01-25 00:00:00'),(13,39,41186,'2014-01-25 00:00:00',NULL,NULL),(15,41,12661,'2014-01-25 14:30:21','2014-01-25 00:00:00','2014-01-25 00:00:00'),(16,72,14197,'2014-01-28 18:20:19','2014-01-28 00:00:00','2014-01-28 00:00:00'),(17,73,76741,'2014-01-28 18:20:20','2014-01-28 00:00:00','2014-01-28 00:00:00'),(18,74,62239,'2014-01-28 00:00:00',NULL,NULL),(20,76,47108,'2014-01-28 18:20:22','2014-01-28 00:00:00','2014-01-28 00:00:00'),(21,86,97769,'2014-01-28 18:21:48','2014-01-28 00:00:00','2014-01-28 00:00:00'),(22,87,93286,'2014-01-28 18:21:49','2014-01-28 00:00:00','2014-01-28 00:00:00'),(23,88,75100,'2014-01-28 00:00:00',NULL,NULL),(25,90,53116,'2014-01-28 18:21:51','2014-01-28 00:00:00','2014-01-28 00:00:00'),(26,100,2682,'2014-01-28 18:23:20','2014-01-28 00:00:00','2014-01-28 00:00:00'),(27,101,84502,'2014-01-28 18:23:21','2014-01-28 00:00:00','2014-01-28 00:00:00'),(28,102,61540,'2014-01-28 00:00:00',NULL,NULL),(30,104,46943,'2014-01-28 18:23:23','2014-01-28 00:00:00','2014-01-28 00:00:00'),(31,117,67076,'2014-01-28 18:49:55','2014-01-28 00:00:00','2014-01-28 00:00:00'),(32,118,36488,'2014-01-28 18:49:56','2014-01-28 00:00:00','2014-01-28 00:00:00'),(33,119,90218,'2014-01-28 00:00:00',NULL,NULL),(35,121,97399,'2014-01-28 18:49:58','2014-01-28 00:00:00','2014-01-28 00:00:00'),(36,131,63363,'2014-01-28 18:54:07','2014-01-28 00:00:00','2014-01-28 00:00:00'),(37,132,57967,'2014-01-28 18:54:09','2014-01-28 00:00:00','2014-01-28 00:00:00'),(38,133,89164,'2014-01-28 00:00:00',NULL,NULL),(40,135,20685,'2014-01-28 18:54:11','2014-01-28 00:00:00','2014-01-28 00:00:00'),(41,148,68395,'2014-01-28 19:30:42','2014-01-28 00:00:00','2014-01-28 00:00:00'),(42,149,79871,'2014-01-28 19:30:43','2014-01-28 00:00:00','2014-01-28 00:00:00'),(43,150,73062,'2014-01-28 00:00:00',NULL,NULL),(45,152,27518,'2014-01-28 19:30:45','2014-01-28 00:00:00','2014-01-28 00:00:00'),(46,155,3534,'2014-01-28 19:30:53','2014-01-28 00:00:00','2014-01-28 00:00:00'),(47,156,55739,'2014-01-28 19:30:54','2014-01-28 00:00:00','2014-01-28 00:00:00'),(48,157,78809,'2014-01-28 00:00:00',NULL,NULL),(50,159,49365,'2014-01-28 19:30:57','2014-01-28 00:00:00','2014-01-28 00:00:00'),(51,178,52656,'2014-01-28 19:31:22','2014-01-28 00:00:00','2014-01-28 00:00:00'),(52,179,39666,'2014-01-28 19:31:23','2014-01-28 00:00:00','2014-01-28 00:00:00'),(53,180,55764,'2014-01-28 00:00:00',NULL,NULL),(55,182,17857,'2014-01-28 19:31:25','2014-01-28 00:00:00','2014-01-28 00:00:00'),(56,201,10766,'2014-01-28 19:35:32','2014-01-28 00:00:00','2014-01-28 00:00:00'),(57,202,91218,'2014-01-28 19:35:33','2014-01-28 00:00:00','2014-01-28 00:00:00'),(58,203,3889,'2014-01-28 00:00:00',NULL,NULL),(60,205,23043,'2014-01-28 19:35:35','2014-01-28 00:00:00','2014-01-28 00:00:00'),(61,210,33369,'2014-01-28 19:35:37','2014-01-28 00:00:00','2014-01-28 00:00:00'),(62,212,47594,'2014-01-28 19:35:37','2014-01-28 00:00:00','2014-01-28 00:00:00'),(63,214,37859,'2014-01-28 00:00:00',NULL,NULL),(65,216,86719,'2014-01-28 19:35:39','2014-01-28 00:00:00','2014-01-28 00:00:00'),(66,217,24858,'2014-01-28 19:35:40','2014-01-28 00:00:00','2014-01-28 00:00:00'),(67,218,58132,'2014-01-28 19:35:41','2014-01-28 00:00:00','2014-01-28 00:00:00'),(68,219,75568,'2014-01-28 00:00:00',NULL,NULL),(70,223,48709,'2014-01-28 19:35:43','2014-01-28 00:00:00','2014-01-28 00:00:00');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',0);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-29 18:35:20
