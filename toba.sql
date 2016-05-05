-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 04, 2016 at 04:33 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `toba`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Id` int(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `balance` double NOT NULL,
  `type` enum('Checking','Savings') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Id`, `username`, `balance`, `type`) VALUES
(1, 'jsmith@toba.com', 200, 'Checking'),
(2, 'wesly', 0, 'Checking'),
(3, 'jsmith@toba.com', 180, 'Savings'),
(4, 'wesly', 320, 'Savings'),
(201, 'faraz57740', 25, 'Checking'),
(251, 'faraz57740', 25, 'Savings');

-- --------------------------------------------------------

--
-- Table structure for table `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN_TABLE', '350');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL,
  `account` int(11) NOT NULL,
  `amount` double NOT NULL,
  `type` varchar(30) NOT NULL,
  `time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `account`, `amount`, `type`, `time`) VALUES
(1, 3, 20, 'Credit', '26/04/2016'),
(2, 1, 200, 'Credit', '26/04/2016'),
(3, 1, 200, 'Credit', '26/04/2016'),
(4, 3, 40, 'Debit', '26/04/2016'),
(5, 3, 200, 'Credit', '26/04/2016'),
(51, 0, 20, 'Credit', '30/04/2016'),
(101, 3, 40, 'Debit', '30/04/2016'),
(151, 3, 40, 'Debit', '30/04/2016');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `username` varchar(40) NOT NULL,
  `password` longtext NOT NULL,
  `salt` longtext NOT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(40) NOT NULL,
  `address` varchar(60) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `city` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `zipcode` varchar(40) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `salt`, `firstname`, `lastname`, `address`, `phoneNumber`, `city`, `state`, `email`, `zipcode`, `date`) VALUES
(1, 'jsmith@toba.com', '6357d5dc66fdaf8dcce128b1564a2628f3aed991989a5e29c365f9c86e33ffd5', '15E2xbB27bhZlJ20YyTsH6D9DreazZmA+KqI7Mp5vuo=', 'jsmith', 'smith', 'ASDD', 'ASD', 'ASD', 'ASD', 'ASD', '', '01/05/2016'),
(6, 'wesly', '3de46a461fb5307e6aa0977173fd9dd713c9376d663af74785008c2787079321', 'HL7JP3wmbTKnVcHTFnsPhMYhWdZum2QmCXbydFE8v5U=', 'ad', 'as', 'asd', 'ad', 'asd', 'as', 'ad', '', '01/05/2016'),
(51, 'jhgjh', '3de46a461fb5307e6aa0977173fd9dd713c9376d663af74785008c2787079321', 'HL7JP3wmbTKnVcHTFnsPhMYhWdZum2QmCXbydFE8v5U=', 'dasf', 'jhg', 'kjh', 'kjh', 'k', 'kj', 'kjh', 'jh', '01/04/2016'),
(301, 'faraz57740', 'welcome2', 'HL7JP3wmbTKnVcHTFnsPhMYhWdZum2QmCXbydFE8v5U=', 'ahmad', 'faraz', 'houseno 8', '03218447889', 'punjab', 'lahore', 'ahmad@gmail.com', '57740', '01/04/2016');

-- --------------------------------------------------------

--
-- Table structure for table `userpass`
--

CREATE TABLE `userpass` (
  `Username` varchar(15) NOT NULL,
  `Password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userpass`
--

INSERT INTO `userpass` (`Username`, `Password`) VALUES
('andrea', 'sesame'),
('anne', 'sesame'),
('joel', 'sesame');

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE `userrole` (
  `Username` varchar(15) NOT NULL,
  `Rolename` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`Username`, `Rolename`) VALUES
('andrea', 'service'),
('joel', 'programmer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userpass`
--
ALTER TABLE `userpass`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`Username`,`Rolename`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=252;
--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=152;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=302;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
