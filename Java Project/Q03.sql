-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 19, 2019 at 11:19 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prisonmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `Age` int(3) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `Age`, `Gender`, `designation`, `salary`) VALUES
('e00001', 'scott', 21, 'Male', 'admin', 50000.00),
('e00002', 'Celvin', 24, 'Male', 'admin', 40000.00),
('e00003', 'Harvey', 45, 'Male', 'admin', 30000.00),
('e00004', 'Gilbert', 43, 'Male', 'security', 20000.00),
('e00005', 'Lincon', 44, 'Female', 'security', 20000.00),
('e00006', 'Maxwell', 32, 'Male', 'Cook', 10000.00),
('e00006', 'Henry', 23, 'Male', 'cook', 23000.00),
('e00007', 'rose', 28, 'Female', 'admin', 19870.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(6) NOT NULL,
  `password` int(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('e00001', 1234, 0),
('e00002', 2476, 0),
('e00003', 4625, 0),
('e00004', 7016, 1),
('e00005', 6788, 1),
('e00006', 5610, 2),
('e00007', 1712, 0);

-- --------------------------------------------------------

--
-- Table structure for table `prisoners`
--

CREATE TABLE `prisoners` (
  `PrisonerId` varchar(6) NOT NULL,
  `PrisonerName` varchar(30) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `CrimeType` varchar(20) NOT NULL,
  `Age` int(3) NOT NULL,
  `CellNumber` int(3) DEFAULT NULL,
  `EntryDate` date DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  `DaysLeft` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prisoners`
--

INSERT INTO `prisoners` (`PrisonerId`, `PrisonerName`, `Gender`, `CrimeType`, `Age`, `CellNumber`, `EntryDate`, `ReleaseDate`, `DaysLeft`) VALUES
('p00002', 'Shakib', 'Male', 'Conspiracy', 33, 55, '2019-08-20', '2021-08-20', 20000),
('p00003', 'Adib', 'Male', 'Kidnapping', 43, 71, '2019-08-20', '2023-08-20', 40000),
('p00005', 'anika', 'Female', 'robbery', 32, 44, '2019-08-19', '2026-08-19', 69999),
('p00006', 'rahim', 'Male', 'theft', 22, 33, '2019-08-19', '2028-08-19', 89999),
('p00001', 'rakib', 'Male', 'murder', 22, 21, '2019-08-17', '2021-08-17', 19997),
('p00007', 'rakib', 'Male', 'murder', 21, 22, '2019-08-20', '2025-08-20', 60000),
('p00008', 'rakin', 'Male', 'Roberry', 45, 66, '2019-08-20', '2027-08-20', 80000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
