-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2019 at 04:30 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e02`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `name` varchar(30) NOT NULL,
  `customerId` varchar(30) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`name`, `customerId`, `phoneNumber`) VALUES
(' Zabir', 'c1', '01711838485 '),
('Saki', 'c2', '01920278767'),
('Ashraful', 'c3', '01934207337'),
('Porosh', 'c4', '01521428851');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(15,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('e00001', 'Ashraful', 'Manager', 100000.00),
('e2', 'Akash', 'SalesMan', 15000.00),
('e3', 'Rocky', 'Cashier', 9000.00),
('e4', 'Biddut', 'Security', 9000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c1', '1234', 2),
('c2', '1234', 2),
('c3', '1234', 2),
('c4', '1234', 2),
('e00001', '1234', 0),
('e2', '15350115', 1),
('e3', '11690287', 1),
('e4', '18971269', 1);

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `MovieID` varchar(6) NOT NULL,
  `MovieName` varchar(30) NOT NULL,
  `duration` varchar(30) NOT NULL,
  `price` double(8,2) NOT NULL,
  `Time` varchar(30) NOT NULL,
  `DATE` varchar(30) NOT NULL,
  `SIT_FILLEDUP` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`MovieID`, `MovieName`, `duration`, `price`, `Time`, `DATE`, `SIT_FILLEDUP`) VALUES
('m1', 'EndGame', '2hr', 450.00, '11:00AM', '1/5/19', '10'),
('m2', 'JOKER', '2:30hr', 450.00, '2:00AM', '2/5/19', '2'),
('m3', 'AmmaJan', '2hr', 700.00, '2:00AM', '1/5/19', '2'),
('m4', 'Batman', '2:20hr', 500.00, '4:00AM', '3/5/19', '1'),
('m5', 'MathaNoshto', '2hr', 350.00, '11:00AM', '4/5/19', '8');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerId`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`MovieID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
