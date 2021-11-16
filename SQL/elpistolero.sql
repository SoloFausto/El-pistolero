-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 16, 2021 at 02:17 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `elpistolero`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `all`
-- (See below for the actual view)
--
CREATE TABLE `all` (
);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `username` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `passw` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `veceslog` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`username`, `email`, `passw`, `nombre`, `veceslog`) VALUES
('admin', 'admin@admin.com', 'admin', 'admin', 0);

-- --------------------------------------------------------

--
-- Structure for view `all`
--
DROP TABLE IF EXISTS `all`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `all`  AS SELECT `usuario`.`username` AS `username`, `usuario`.`email` AS `email`, `usuario`.`passw` AS `passw`, `usuario`.`nombre` AS `nombre`, `usuario`.`numUsuario` AS `numUsuario` FROM `usuario` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
