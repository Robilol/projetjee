-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: jee
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

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
-- Table structure for table `clic`
--

DROP TABLE IF EXISTS `clic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_id` int(11) DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clic`
--

LOCK TABLES `clic` WRITE;
/*!40000 ALTER TABLE `clic` DISABLE KEYS */;
INSERT INTO `clic` VALUES (2,43,'2018-07-01'),(3,43,'2018-07-01'),(4,43,'2018-07-01'),(5,43,'2018-07-01'),(6,43,'2018-07-01'),(7,43,'2018-07-01'),(8,43,'2018-07-01'),(9,43,'2018-07-01'),(10,43,'2018-07-01'),(11,43,'2018-07-02'),(12,43,'2018-07-02'),(13,43,'2018-07-02'),(14,43,'2018-07-05'),(15,43,'2018-07-05'),(16,43,'2018-07-05'),(17,43,'2018-07-05'),(18,43,'2018-07-05'),(19,43,'2018-07-05'),(20,43,'2018-07-05'),(21,43,'2018-07-08'),(22,43,'2018-07-08'),(23,43,'2018-07-08'),(24,43,'2018-07-08'),(25,43,'2018-07-08'),(26,43,'2018-07-08'),(27,43,'2018-07-08'),(28,43,'2018-07-08'),(29,43,'2018-07-08'),(30,43,'2018-07-08'),(31,43,'2018-07-08'),(32,43,'2018-07-08'),(33,43,'2018-07-08'),(34,43,'2018-07-08'),(35,43,'2018-07-08'),(36,43,'2018-07-08'),(37,43,'2018-07-09'),(38,43,'2018-07-09'),(39,43,'2018-07-09'),(40,43,'2018-07-09'),(41,43,'2018-07-09'),(42,43,'2018-07-10'),(43,43,'2018-07-10'),(44,43,'2018-07-10'),(45,43,'2018-07-10'),(46,43,'2018-07-10'),(47,43,'2018-07-10'),(48,43,'2018-07-10'),(49,43,'2018-07-10'),(50,43,'2018-07-10'),(51,43,'2018-07-10'),(52,44,'2018-07-16'),(53,46,'2018-07-16'),(54,47,'2018-07-16'),(55,49,'2018-07-16'),(56,49,'2018-07-16'),(57,49,'2018-07-16'),(58,49,'2018-07-16'),(59,49,'2018-07-16');
/*!40000 ALTER TABLE `clic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `url`
--

DROP TABLE IF EXISTS `url`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `url` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `url_original` text NOT NULL,
  `url_short` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `captcha` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(100) DEFAULT NULL,
  `date_start` varchar(30) DEFAULT NULL,
  `date_end` varchar(30) DEFAULT NULL,
  `clics_counter` int(11) DEFAULT '0',
  `max_clics` int(11) DEFAULT NULL,
  `date_creation` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `url`
--

LOCK TABLES `url` WRITE;
/*!40000 ALTER TABLE `url` DISABLE KEYS */;
INSERT INTO `url` VALUES (22,'0','https://www.youtube.com/','http://localhost:8282/index3fe5149b9544db59','',0,'','','',0,NULL,NULL),(23,'0','','','',0,'','','',0,NULL,NULL),(24,'0','','','',0,'','','',0,NULL,NULL),(25,'0','','','',0,'','','',0,NULL,NULL),(26,'0','https://github.com/Robilol/projetjee/issues','http://localhost:8282/3fe11e8bf3800788','',0,'','','',0,NULL,NULL),(27,'0','https://github.com/Robilol/projetjee/issues','http://localhost:8282/3fe4','',0,'','','',0,NULL,NULL),(28,'0','https://github.com/Robilol/projetjee/issues','http://localhost:8282/3fcf','',0,'','','',0,NULL,NULL),(29,'0','https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java','http://localhost:8282/3fd7','',0,'','','',0,NULL,NULL),(30,'0','https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java','http://localhost:8282/3fd5','',0,'','','',0,NULL,NULL),(31,'0','https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java','http://localhost:8282/3fd8','',0,'','','',0,NULL,NULL),(32,'0','https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java','http://localhost:8282/3fcf','',0,'','','',0,NULL,NULL),(33,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/9767','',0,'','','',0,NULL,NULL),(34,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/6f96','',0,'','','',0,NULL,NULL),(35,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/b3ad','',0,'','','',0,NULL,NULL),(36,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/1047','',0,'','','',0,NULL,NULL),(37,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/0175','',0,'','','',0,NULL,NULL),(38,'0','https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string','http://localhost:8282/99c7','',0,'','','',0,NULL,NULL),(39,'13','dateto','http://localhost:8282/l/306d','bla',1,'',NULL,NULL,5,100,'2018-07-07'),(40,'13','interval','http://localhost:8282/l/4258','tfghj',0,'','2018-07-01 00:00:00.0','2018-07-02 00:00:00.0',0,0,'2018-07-07'),(41,'13','http://guillaumepn.free.fr/','http://localhost:8282/l/1a92','ertyu',0,'',NULL,NULL,0,0,'2018-07-07'),(42,'13','testclic','http://localhost:8282/l/3c9d','',0,'',NULL,NULL,0,0,'2018-07-08'),(43,'13','http://wooly.cat/','http://localhost:8282/l/b89d','',0,'',NULL,NULL,10,0,'2018-07-08'),(44,'13','http://wooly.cat/','http://localhost:8282/l/d885','bla',0,'',NULL,NULL,1,0,'2018-07-16'),(45,'13','http://guillaumepn.free.fr/','http://localhost:8282/l/38e1','test',0,'',NULL,NULL,0,0,'2018-07-16'),(46,'13','http://guillaumepn.free.fr/','http://localhost:8282/l/04e8','test',0,'',NULL,NULL,1,0,'2018-07-16'),(47,'13','http://wooly.cat/','http://localhost:8282/l/2254','test',0,'',NULL,NULL,1,0,'2018-07-16'),(48,'13','http://guillaumepn.free.fr/','http://localhost:8282/l/cc48','azrty',0,'',NULL,NULL,0,0,'2018-07-16'),(49,'13','http://wooly.cat/','http://localhost:8282/l/321a','azertyuio',1,'',NULL,NULL,5,0,'2018-07-16'),(50,'13','http://wooly.cat/','http://localhost:8282/l/47b3','azerty',0,'',NULL,NULL,0,0,'2018-07-16'),(51,'13','http://wooly.cat/','http://localhost:8282/l/fcc2','bla',1,'',NULL,NULL,0,0,'2018-07-16');
/*!40000 ALTER TABLE `url` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(45) NOT NULL,
  `token` varchar(60) DEFAULT NULL,
  `validated` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'fdisu@jfd.fr','dsfghj','association',NULL,0),(2,'fezgrhtyj@frgt.fr','fegrhtyju','particulier',NULL,0),(3,'dsfedgr@fgr.fe','fdsg','entreprise',NULL,0),(4,'dsfg@dferg.fr','defzrgt','particulier',NULL,0),(5,'dfsg@n.fr','fdg','particulier',NULL,0),(6,'defsre@dfgr.f','sefrd','association',NULL,0),(7,'dfsg@bhv.njb','fsrdgf','association',NULL,0),(8,'dsf@dfsg.f','fegr','particulier',NULL,0),(9,'zdfesgrdht@dfs.gr','fsgrthr','entreprise',NULL,0),(10,'gui@aol.fr','test','particulier',NULL,0),(11,'gui@test.fr','test','particulier',NULL,0),(12,'guillaumepn@free.fr','test','test','XKTR7Gs4GU74FGUs',1),(13,'pimous78920@hotmail.fr','azerty','particulier','FKqGkibYODnJC8So',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-16 10:49:55
