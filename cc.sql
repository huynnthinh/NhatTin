-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.5.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for 41_vonhattin_21138211
CREATE DATABASE IF NOT EXISTS `41_vonhattin_21138211` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `41_vonhattin_21138211`;

-- Dumping structure for table 41_vonhattin_21138211.cuahang
CREATE TABLE IF NOT EXISTS `cuahang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 41_vonhattin_21138211.cuahang: ~2 rows (approximately)
INSERT INTO `cuahang` (`id`, `ten`) VALUES
	(1, 'Bookshop'),
	(2, 'Coffeeshop');

-- Dumping structure for table 41_vonhattin_21138211.donhang
CREATE TABLE IF NOT EXISTS `donhang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `ma_don_hang` varchar(255) NOT NULL,
  `ngay_dat_hang` date NOT NULL,
  `tenkh` varchar(50) NOT NULL,
  `tensp` varchar(255) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `madh` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKis95r6snm1y830you5smmpegt` (`madh`),
  CONSTRAINT `FKis95r6snm1y830you5smmpegt` FOREIGN KEY (`madh`) REFERENCES `cuahang` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table 41_vonhattin_21138211.donhang: ~5 rows (approximately)
INSERT INTO `donhang` (`id`, `email`, `ma_don_hang`, `ngay_dat_hang`, `tenkh`, `tensp`, `trang_thai`, `madh`) VALUES
	(1, 'thailo@gmail.com', 'A00', '2024-12-11', 'Thai', '1234', b'1', 1),
	(2, 'thinhbo@gmail.com', 'A00', '2025-01-01', 'Thinh', 'Sach tan trai', b'1', 2),
	(8, 'haky@gmail.com', '20241220165816', '2024-12-17', 'Ky', 'vãi lz luôn đầu cắt moi', b'1', 1),
	(10, 'thinh183tt@gmail.com', '20241220171518', '2024-12-24', 'thịnh', 'gáo nước mưa', b'0', 1),
	(11, 'thinhdev2003@gmail.com', '20241221052407', '2024-12-02', 'Thinh', 'matcha', b'1', 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
