/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 10.4.18-MariaDB : Database - productservice
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`productservice` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `productservice`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `category` */

insert  into `category`(`categoryid`,`categoryname`) values (1,'Electronic'),(2,'Cosmetic');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT,
  `productdesc` varchar(255) DEFAULT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `storeid` int(11) NOT NULL,
  `categoryid` int(11) NOT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`productid`),
  KEY `FK9v9pxncccv2bwg4dgni5s9tbn` (`storeid`),
  KEY `FK4ort9abhumpx4t2mlngljr1vi` (`categoryid`),
  CONSTRAINT `FK4ort9abhumpx4t2mlngljr1vi` FOREIGN KEY (`categoryid`) REFERENCES `category` (`categoryid`),
  CONSTRAINT `FK9v9pxncccv2bwg4dgni5s9tbn` FOREIGN KEY (`storeid`) REFERENCES `store` (`storeid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `product` */

insert  into `product`(`productid`,`productdesc`,`productname`,`qty`,`storeid`,`categoryid`,`price`) values (1,'Iphone 13 Pro Max 512 GB Garansi Ibox','Iphone 13 Pro Max',10,1,1,38000000),(3,'Iphone 13 Pro Max 512 GB Garansi Inter','Iphone 13 Pro Max',10,1,1,35000000);

/*Table structure for table `store` */

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `storeid` int(11) NOT NULL AUTO_INCREMENT,
  `storeaddress` varchar(255) DEFAULT NULL,
  `storename` varchar(255) DEFAULT NULL,
  `storeowner` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`storeid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `store` */

insert  into `store`(`storeid`,`storeaddress`,`storename`,`storeowner`) values (1,'Jakarta','Taufan Gadget Store','Taufan Samudra'),(2,'Jakarta','Tashya Cosmetic Shop','Tashya Amaraesty');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
