-- MySQL dump 10.13  Distrib 8.0.23, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: semester-project
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `movie_info`
--

DROP TABLE IF EXISTS `movie_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_info` (
  `movie_info_id` int NOT NULL AUTO_INCREMENT,
  `fk_user_name` varchar(45) DEFAULT NULL,
  `fk_movie_id` varchar(45) DEFAULT NULL,
  `comment` varchar(45) DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`movie_info_id`),
  KEY `fk_movie_info_users1_idx` (`fk_user_name`),
  KEY `fk_movie_info_movies1_idx` (`fk_movie_id`),
  CONSTRAINT `fk_movie_info_movies1` FOREIGN KEY (`fk_movie_id`) REFERENCES `mydb`.`movies` (`movie_id`),
  CONSTRAINT `fk_movie_info_users1` FOREIGN KEY (`fk_user_name`) REFERENCES `users` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_info`
--

LOCK TABLES `movie_info` WRITE;
/*!40000 ALTER TABLE `movie_info` DISABLE KEYS */;
INSERT INTO `movie_info` VALUES (1,'Admin',NULL,'this is a really good movie',NULL),(2,NULL,NULL,'this is a really bad movie',NULL);
/*!40000 ALTER TABLE `movie_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movie_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (4,'far til fire','I denne klassiske familiekomedie bliver en enlig far fyret fra sit job for at være ude af trit med tiden, så hans fire børn giver ham en moderne makeover.'),(5,'toy story','A group of living toys, who assume lifelessness around humans, are preparing to move into a new house with their owner Andy Davis, his sister Molly and their single mother. The toys become uneasy when Andy has his birthday party a week early; to calm them, Sheriff Woody, Andy\'s favorite toy and their leader, sends Sarge and his green army men to spy on the gift opening with a baby monitor. The other toys (which include Mr. Potato Head, Slinky Dog, Rex the tyrannosaur, Hamm the piggy bank, and Bo Peep the porcelain doll) are relieved when Andy receives nothing that could replace them. Andy then receives a last-minute surprise gift – a Buzz Lightyear action figure who believes he is a real space ranger. Buzz impresses the other toys with his various features and becomes Andy\'s new favorite, making Woody jealous.');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RENAMEME`
--

DROP TABLE IF EXISTS `RENAMEME`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RENAMEME` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DUMMYSTR1` varchar(255) DEFAULT NULL,
  `DUMMYSTR2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RENAMEME`
--

LOCK TABLES `RENAMEME` WRITE;
/*!40000 ALTER TABLE `RENAMEME` DISABLE KEYS */;
/*!40000 ALTER TABLE `RENAMEME` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('admin'),('user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `role_name` varchar(20) NOT NULL,
  `user_name` varchar(25) NOT NULL,
  PRIMARY KEY (`role_name`,`user_name`),
  KEY `FK_user_roles_user_name` (`user_name`),
  CONSTRAINT `FK_user_roles_role_name` FOREIGN KEY (`role_name`) REFERENCES `roles` (`role_name`),
  CONSTRAINT `FK_user_roles_user_name` FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES ('admin','admin'),('user','user'),('admin','user_admin'),('user','user_admin');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_name` varchar(25) NOT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  `user_salt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','$2a$10$aOYTHiI8j2z2wHXNd6sQkun/SOb9iosuBTkAAw8b8kf9mz10EhthG','$2a$10$aOYTHiI8j2z2wHXNd6sQku'),('user','$2a$10$j/8IETiRH2ixLaKiSJAP1urIVkcU3iTJ4xQkGhrGf4x2WBwDBk9Xi','$2a$10$j/8IETiRH2ixLaKiSJAP1u'),('user_admin','$2a$10$T9OzlU2gCPP0Svjh7luuA./tNtX1yrZL10LUnFGZFT3m4twe.zdu2','$2a$10$T9OzlU2gCPP0Svjh7luuA.');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29 11:40:04
