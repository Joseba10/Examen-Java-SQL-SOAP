-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.21-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para examen
CREATE DATABASE IF NOT EXISTS `examen` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `examen`;

-- Volcando estructura para tabla examen.busqueda
CREATE TABLE IF NOT EXISTS `busqueda` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(25) NOT NULL,
  `fecha` datetime NOT NULL,
  `busquedaHecha` varchar(25) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_busqueda_usuario` (`id_usuario`),
  CONSTRAINT `FK_busqueda_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla examen.busqueda: ~0 rows (aproximadamente)
DELETE FROM `busqueda`;
/*!40000 ALTER TABLE `busqueda` DISABLE KEYS */;
INSERT INTO `busqueda` (`id`, `id_usuario`, `fecha`, `busquedaHecha`) VALUES
	(8, 2, '2018-05-18 12:06:12', '2'),
	(9, 2, '2018-05-18 12:06:59', '2'),
	(10, 2, '2018-05-18 12:08:11', '2'),
	(11, 2, '2018-05-18 12:08:31', '2'),
	(12, 2, '2018-05-18 12:08:59', '2'),
	(13, 2, '2018-05-18 12:10:56', '5'),
	(14, 2, '2018-05-18 13:05:49', '1'),
	(15, 2, '2018-05-18 13:05:58', ''),
	(16, 2, '2018-05-18 13:06:02', '1'),
	(17, 2, '2018-05-18 13:07:40', '1'),
	(18, 2, '2018-05-18 13:11:17', '1'),
	(19, 2, '2018-05-18 13:12:59', '1'),
	(20, 2, '2018-05-18 13:13:17', '2'),
	(21, 2, '2018-05-18 13:13:19', '3'),
	(22, 2, '2018-05-18 13:13:22', '4'),
	(23, 2, '2018-05-18 13:13:25', '5'),
	(24, 2, '2018-05-18 13:13:28', ''),
	(25, 2, '2018-05-18 13:14:19', '2'),
	(26, 2, '2018-05-18 13:14:21', ''),
	(27, 2, '2018-05-18 13:14:22', ''),
	(28, 2, '2018-05-18 13:14:22', ''),
	(29, 2, '2018-05-18 13:14:44', '6'),
	(30, 2, '2018-05-18 13:15:06', 'pepe');
/*!40000 ALTER TABLE `busqueda` ENABLE KEYS */;

-- Volcando estructura para tabla examen.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(25) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(75) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Índice 2` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla examen.usuario: ~0 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `password`, `email`) VALUES
	(2, 'admin', 'admin', 'admin@admin.com');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
