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
-- Table structure for table `movieinfo`
--

DROP TABLE IF EXISTS `movieinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movieinfo` (
  `movieInfo_id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(100) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `MOVIES_movie_id` bigint DEFAULT NULL,
  `USER_user_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`movieInfo_id`),
  KEY `FK_movieinfo_USER_user_name` (`USER_user_name`),
  KEY `FK_movieinfo_MOVIES_movie_id` (`MOVIES_movie_id`),
  CONSTRAINT `FK_movieinfo_MOVIES_movie_id` FOREIGN KEY (`MOVIES_movie_id`) REFERENCES `movie` (`movie_id`),
  CONSTRAINT `FK_movieinfo_USER_user_name` FOREIGN KEY (`USER_user_name`) REFERENCES `users` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieinfo`
--

LOCK TABLES `movieinfo` WRITE;
/*!40000 ALTER TABLE `movieinfo` DISABLE KEYS */;
INSERT INTO `movieinfo` VALUES (1,'god film',5,1,'admin'),(2,'hello',NULL,NULL,NULL);
/*!40000 ALTER TABLE `movieinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `movie_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(2500) DEFAULT NULL,
  `title` varchar(25) DEFAULT NULL,
  `images` text,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'To protect his family from a powerful drug lord, skilled thief Mehdi and his expert team of robbers are pulled into a violent and deadly turf war.','Ganglands','ganglands.jpg'),(2,'As her father nears the end of his life, filmmaker Kirsten Johnson stages his death in inventive and comical ways to help them both face the inevitable.','Dick Johnson Is Dead','dick_johnson.jpeg'),(3,'Feuds, flirtations and toilet talk go down among the incarcerated women at the Orleans Justice Center in New Orleans on this gritty reality series.','Jailbirds New Orleans','new_orleans.jpg'),(4,'After crossing paths at a party, a Cape Town teen sets out to prove whether a private-school swimming star is her sister who was abducted at birth.','Blood & Water','blood_water.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
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
INSERT INTO `users` VALUES ('admin','$2a$10$IFxe33v3fQS041nsUDZjfOFNuJzDP6RQGdPZ04q7lXnAl96JKK94C','$2a$10$IFxe33v3fQS041nsUDZjfO'),('user','$2a$10$omZpxCJXgZr2CEtRc8kVv..e/186St5Y03zwH6QG6HHuS5L0qXL8q','$2a$10$omZpxCJXgZr2CEtRc8kVv.'),('user_admin','$2a$10$34i/0YBe4YSPUyjZ7../UOuMCU8zH6eGjL98nz9sFnoe.WlXrzD.y','$2a$10$34i/0YBe4YSPUyjZ7../UO');
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

-- Dump completed on 2021-12-04 12:17:28
