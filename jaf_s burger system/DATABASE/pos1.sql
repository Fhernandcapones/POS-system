-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 14, 2019 at 09:53 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos1`
--

-- --------------------------------------------------------

--
-- Table structure for table `insertedintocart`
--

CREATE TABLE `insertedintocart` (
  `id` int(11) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `qty` double NOT NULL,
  `price` float NOT NULL,
  `total_product` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `id` varchar(50) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `qty` varchar(50) NOT NULL,
  `Date` varchar(50) NOT NULL,
  `Stock_In_Out` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`id`, `Product_name`, `Category`, `qty`, `Date`, `Stock_In_Out`) VALUES
('1004', 'Chiken(Yellow)', 'SIOPAO', '10', '2019,02,11', 'Stock In'),
('1011', 'Sphagetti Pasta', '1kl = 22', '100', '2019,02,11', 'Stock In'),
('1010', 'Baguette (Beef w/ Chicken)', 'none', '100', '2019,02,11', 'Stock In'),
('1009', 'Pizza Roll (Ham with Cheese)', 'none', '100', '2019,02,11', 'Stock In'),
('1005', 'Ham & Cheese - Yellow', 'Garlic Bread', '8', '2019,02,11', 'Stock Out'),
('1010', 'Baguette (Beef w/ Chicken)', 'none', '20', '2019,02,11', 'Stock Out'),
('1011', 'Sphagetti Pasta', '1kl = 22', '20', '2019,02,11', 'Stock Out'),
('1014', 'Carbonata Sauce', 'Carbonata', '10', '2019,02,11', 'Stock In'),
('1005', 'Ham & Cheese - Yellow', 'Garlic Bread', '10', '2019,02,12', 'Stock In'),
('1005', 'Ham & Cheese - Yellow', 'Garlic Bread', '10', '2019,02,12', 'Stock Out'),
('1007', 'Tuna (White)', 'Empanada', '100', '2019,02,15', 'Stock In'),
('1006', 'Double Cheese - White', 'Garlic Bread', '100', '2019,02,15', 'Stock In'),
('1006', 'Double Cheese - White', 'Garlic Bread', '100.555', '2019,02,15', 'Stock In'),
('1006', 'Double Cheese - White', 'Garlic Bread', '100', '2019,02,15', 'Stock Out'),
('1006', 'Double Cheese - White', 'Garlic Bread', '.555', '2019,02,15', 'Stock Out'),
('1005', 'Ham & Cheese - Yellow', 'Garlic Bread', '200.0', '2019,12,14', 'Stock In'),
('1005', 'Ham & Cheese - Yellow', 'Garlic Bread', '2.0', '2019,12,14', 'Stock Out'),
('1004', 'Chiken(Yellow)', 'SIOPAO', '12.0', '2019,12,14', 'Stock In'),
('1002', 'Asado P(No Color)', 'SIOPAO', '12.0', '2019,12,14', 'Stock In'),
('1001', 'Toasted P (Yellow Dough)', 'SIOPAO', '12.0', '2019,12,14', 'Stock In'),
('1013', 'Carbonata Pasta', 'Carbonata', '123.0', '2019,12,14', 'Stock In');

-- --------------------------------------------------------

--
-- Table structure for table `inv_products`
--

CREATE TABLE `inv_products` (
  `id` int(11) NOT NULL,
  `Product_name` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Portion` varchar(100) NOT NULL,
  `Serving` varchar(100) NOT NULL,
  `Price` varchar(10) NOT NULL,
  `qty` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inv_products`
--

INSERT INTO `inv_products` (`id`, `Product_name`, `Category`, `Portion`, `Serving`, `Price`, `qty`) VALUES
(1001, 'Toasted P (Yellow Dough)', 'SIOPAO', '1pk = 15pcs', 'none', '20.0', 11),
(1002, 'Asado P(No Color)', 'SIOPAO', '1pk = 15pcs', 'none', '20.32', 11),
(1003, 'Bola- bola P(green)', 'SIOPAO', '1pk = 15pcs', 'none', '19.0', 0),
(1004, 'Chiken(Yellow)', 'SIOPAO', '1pk = 15pcs', 'none', '19.0', 12),
(1005, 'Ham & Cheese - Yellow', 'Garlic Bread', '1pk = 15pcs', 'none', '19.0', 196),
(1006, 'Double Cheese - White', 'Garlic Bread', '1pk = 15pcs', 'none', '19.0', 99),
(1007, 'Tuna (White)', 'Empanada', '1pk = 18pcs', 'none', '19.0', 99),
(1008, 'Chiken (Yellow)', 'Empanada', '1pk = 18pcs', 'none', '19.0', 0),
(1009, 'Pizza Roll (Ham with Cheese)', 'none', '1pk = 18pcs', 'none', '20.0', 61),
(1010, 'Baguette (Beef w/ Chicken)', 'none', '20/30/50/100', 'none', '29.0', 65),
(1011, 'Sphagetti Pasta', '1kl = 22', '20/30/50/100', 'with Meatballs', '40.0', 64),
(1012, 'Sphagetti Sauce', 'Sphagetti', 'none', 'pair', '18.0', 0),
(1013, 'Carbonata Pasta', 'Carbonata', '1kl = 22', 'none', '50', 123),
(1014, 'Carbonata Sauce', 'Carbonata', 'none', 'pair', '13.0', 0),
(1015, 'Palabok Bihon', 'Palabok', '1kl = 13', 'none', '40.0', 0),
(1016, 'Palabok  Sauce', 'Palabok', '1kl = 13', 'none', '0.0', 0);

-- --------------------------------------------------------

--
-- Table structure for table `salesreport`
--

CREATE TABLE `salesreport` (
  `pcode` varchar(100) NOT NULL,
  `pname` varchar(100) NOT NULL,
  `date` varchar(100) NOT NULL,
  `qty` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `totalp` float(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `salesreport`
--

INSERT INTO `salesreport` (`pcode`, `pname`, `date`, `qty`, `price`, `totalp`) VALUES
('1004', 'Chiken(Yellow)', '2019-02,11', '1', '19.0', 19),
('1005', 'Ham & Cheese - Yellow', '2019-02,11', '2', '19.0', 38),
('1004', 'Chiken(Yellow)', '2019-02,11', '2', '19.0', 38),
('1011', 'Sphagetti Pasta', '2019-02,11', '2', '40.0', 80),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-02,11', '10', '20.0', 200),
('1005', 'Ham & Cheese - Yellow', '2019-02,11', '10', '19.0', 190),
('1004', 'Chiken(Yellow)', '2019-02,11', '2', '19.0', 38),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-02,11', '2', '20.0', 40),
('1010', 'Baguette (Beef w/ Chicken)', '2019-02,11', '2', '29.0', 58),
('1014', 'Carbonata Sauce', '2019-02,11', '10', '13.0', 130),
('1004', 'Chiken(Yellow)', '2019-02,12', '3', '19.0', 57),
('1005', 'Ham & Cheese - Yellow', '2019-02,12', '3', '19.0', 57),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-02,12', '3', '20.0', 60),
('1004', 'Chiken(Yellow)', '2019-02,12', '2', '19.0', 38),
('1005', 'Ham & Cheese - Yellow', '2019-02,12', '10', '19.0', 190),
('1010', 'Baguette (Beef w/ Chicken)', '2019-02,12', '10', '29.0', 290),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-02,12', '10', '20.0', 200),
('1011', 'Sphagetti Pasta', '2019-02,12', '10', '40.0', 400),
('1010', 'Baguette (Beef w/ Chicken)', '2019-02,13', '2', '29.0', 58),
('1011', 'Sphagetti Pasta', '2019-02,13', '2', '40.0', 80),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-02,13', '2', '20.0', 40),
('1005', 'Ham & Cheese - Yellow', '2019-02,13', '2', '19.0', 38),
('1005', 'Ham & Cheese - Yellow', '2019-02,14', '35', '19.0', 665),
('1005', 'Ham & Cheese - Yellow', '2019-12,14', '1', '19.0', 19),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-12,14', '1', '20.0', 20),
('1011', 'Sphagetti Pasta', '2019-12,14', '1', '40.0', 40),
('1010', 'Baguette (Beef w/ Chicken)', '2019-12,14', '1', '29.0', 29),
('1007', 'Tuna (White)', '2019-12,14', '1', '19.0', 19),
('1005', 'Ham & Cheese - Yellow', '2019-12,14', '1', '19.0', 19),
('1001', 'Toasted P (Yellow Dough)', '2019-12,14', '1', '20.0', 20),
('1011', 'Sphagetti Pasta', '2019-12,14', '1', '40.0', 40),
('1009', 'Pizza Roll (Ham with Cheese)', '2019-12,14', '11', '20.0', 220),
('1006', 'Double Cheese - White', '2019-12,14', '1', '19.0', 19),
('1002', 'Asado P(No Color)', '2019-12,14', '1', '20.32', 20);

-- --------------------------------------------------------

--
-- Table structure for table `usertype_table`
--

CREATE TABLE `usertype_table` (
  `id` int(11) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `middlename` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `age` int(100) NOT NULL,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `usertype` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertype_table`
--

INSERT INTO `usertype_table` (`id`, `firstname`, `middlename`, `lastname`, `address`, `age`, `user`, `pass`, `gender`, `usertype`) VALUES
(15, 'fhernand', 'verra', 'capones', 'zvxzvxzv', 19, 'fhernand', 'capones123', 'Male', 'Admin'),
(16, 'jerome', 'mondejar', 'garciano', 'no permanent address', 19, 'jerome', 'garcianno', 'Male', 'Casher'),
(17, 'Angelie', 'dgs', 'arreglado', 'jjjjjgjjud', 13, 'arreglado', '123', 'Female', 'Casher');

-- --------------------------------------------------------

--
-- Table structure for table `viewlogs`
--

CREATE TABLE `viewlogs` (
  `Date` varchar(11) NOT NULL,
  `Time` varchar(100) NOT NULL,
  `Details` varchar(200) NOT NULL,
  `userTypes` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viewlogs`
--

INSERT INTO `viewlogs` (`Date`, `Time`, `Details`, `userTypes`) VALUES
('02-11,2019', '09:36:05 PM', 'Login', 'arneganuhay'),
('02-11,2019', '09:36:57 PM', 'Stock In : ID: 1004 Product Name:Chiken(Yellow)QTY:10', 'arneganuhay'),
('02-11,2019', '09:38:14 PM', 'Sales : ID: 1004 Product Name: Chiken(Yellow) QTY: 1 Price: 19.0 Total Price: 19', 'arneganuhay'),
('02-11,2019', '09:39:03 PM', 'has update:! -Product Name: Carbonata Pasta Category: Carbonata Portion: 1kl = 22 Serving : none Price: 50 QTY: 0.0', 'arneganuhay'),
('02-11,2019', '09:40:18 PM', 'Logout', 'arneganuhay'),
('02-11,2019', '09:40:23 PM', 'Login', 'ar'),
('02-11,2019', '09:40:36 PM', 'Logout', 'ar'),
('02-11,2019', '09:40:44 PM', 'Login', 'arneganuhay'),
('02-11,2019', '09:42:27 PM', 'Stock In : ID: 1011 Product Name:Sphagetti PastaQTY:100', 'arneganuhay'),
('02-11,2019', '09:42:34 PM', 'Stock In : ID: 1010 Product Name:Baguette (Beef w/ Chicken)QTY:100', 'arneganuhay'),
('02-11,2019', '09:42:39 PM', 'Stock In : ID: 1009 Product Name:Pizza Roll (Ham with Cheese)QTY:100', 'arneganuhay'),
('02-11,2019', '09:43:37 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 2 Price: 19.0 Total Price: 38', 'arneganuhay'),
('02-11,2019', '09:43:37 PM', 'Sales : ID: 1004 Product Name: Chiken(Yellow) QTY: 2 Price: 19.0 Total Price: 38', 'arneganuhay'),
('02-11,2019', '09:43:37 PM', 'Sales : ID: 1011 Product Name: Sphagetti Pasta QTY: 2 Price: 40.0 Total Price: 80', 'arneganuhay'),
('02-11,2019', '09:45:07 PM', 'Stock Out : ID: 1005 Product Name:Ham & Cheese - YellowQTY:68.0', 'arneganuhay'),
('02-11,2019', '09:45:15 PM', 'Stock Out : ID: 1010 Product Name:Baguette (Beef w/ Chicken)QTY:100.0', 'arneganuhay'),
('02-11,2019', '09:45:21 PM', 'Stock Out : ID: 1011 Product Name:Sphagetti PastaQTY:98.0', 'arneganuhay'),
('02-11,2019', '09:46:39 PM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 10 Price: 20.0 Total Price: 200', 'arneganuhay'),
('02-11,2019', '09:46:39 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 10 Price: 19.0 Total Price: 190', 'arneganuhay'),
('02-11,2019', '09:46:39 PM', 'Sales : ID: 1004 Product Name: Chiken(Yellow) QTY: 2 Price: 19.0 Total Price: 38', 'arneganuhay'),
('02-11,2019', '09:47:43 PM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 2 Price: 20.0 Total Price: 40', 'arneganuhay'),
('02-11,2019', '09:47:43 PM', 'Sales : ID: 1010 Product Name: Baguette (Beef w/ Chicken) QTY: 2 Price: 29.0 Total Price: 58', 'arneganuhay'),
('02-11,2019', '09:50:01 PM', 'Stock In : ID: 1014 Product Name:Carbonata SauceQTY:10', 'arneganuhay'),
('02-11,2019', '09:51:03 PM', 'Sales : ID: 1014 Product Name: Carbonata Sauce QTY: 10 Price: 13.0 Total Price: 130', 'arneganuhay'),
('02-11,2019', '09:57:21 PM', 'has update:! -Product Name: Asado P(No Color) Category: SIOPAO Portion: 1pk = 15pcs Serving : none Price: 20.32 QTY: 0.0', 'arneganuhay'),
('02-11,2019', '09:59:53 PM', 'Logout', 'arneganuhay'),
('02-12,2019', '09:04:21 AM', 'Login', 'ar'),
('02-12,2019', '09:07:14 AM', 'Sales : ID: 1004 Product Name: Chiken(Yellow) QTY: 3 Price: 19.0 Total Price: 57', 'ar'),
('02-12,2019', '09:07:14 AM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 3 Price: 19.0 Total Price: 57', 'ar'),
('02-12,2019', '09:07:14 AM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 3 Price: 20.0 Total Price: 60', 'ar'),
('02-12,2019', '09:07:21 AM', 'Logout', 'ar'),
('02-12,2019', '09:07:29 AM', 'Login', 'arneganuhay'),
('02-12,2019', '09:08:29 AM', 'Stock In : ID: 1005 Product Name:Ham & Cheese - YellowQTY:10', 'arneganuhay'),
('02-12,2019', '09:08:43 AM', 'Stock Out : ID: 1005 Product Name:Ham & Cheese - YellowQTY:57.0', 'arneganuhay'),
('02-12,2019', '09:10:25 AM', 'Logout', 'arneganuhay'),
('02-12,2019', '09:10:32 AM', 'Login', 'ar'),
('02-12,2019', '09:11:07 AM', 'Logout', 'ar'),
('02-12,2019', '09:16:16 AM', 'Login', 'arneganuhay'),
('02-12,2019', '09:21:34 AM', 'Sales : ID: 1004 Product Name: Chiken(Yellow) QTY: 2 Price: 19.0 Total Price: 38', 'arneganuhay'),
('02-12,2019', '09:21:34 AM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 10 Price: 19.0 Total Price: 190', 'arneganuhay'),
('02-12,2019', '09:21:34 AM', 'Sales : ID: 1010 Product Name: Baguette (Beef w/ Chicken) QTY: 10 Price: 29.0 Total Price: 290', 'arneganuhay'),
('02-12,2019', '09:21:34 AM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 10 Price: 20.0 Total Price: 200', 'arneganuhay'),
('02-12,2019', '09:21:34 AM', 'Sales : ID: 1011 Product Name: Sphagetti Pasta QTY: 10 Price: 40.0 Total Price: 400', 'arneganuhay'),
('02-12,2019', '09:33:54 AM', 'Logout', 'arneganuhay'),
('02-13,2019', '01:09:27 PM', 'Login', 'arneganuhay'),
('02-13,2019', '01:28:26 PM', 'Logout', 'arneganuhay'),
('02-13,2019', '08:41:33 PM', 'Login', 'arneganuhay'),
('02-13,2019', '08:43:36 PM', 'Sales : ID: 1010 Product Name: Baguette (Beef w/ Chicken) QTY: 2 Price: 29.0 Total Price: 58', 'arneganuhay'),
('02-13,2019', '08:43:36 PM', 'Sales : ID: 1011 Product Name: Sphagetti Pasta QTY: 2 Price: 40.0 Total Price: 80', 'arneganuhay'),
('02-13,2019', '08:43:36 PM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 2 Price: 20.0 Total Price: 40', 'arneganuhay'),
('02-13,2019', '08:43:36 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 2 Price: 19.0 Total Price: 38', 'arneganuhay'),
('02-13,2019', '08:49:31 PM', 'Logout', 'arneganuhay'),
('02-13,2019', '09:51:30 PM', 'Login', 'arneganuhay'),
('02-13,2019', '10:38:51 PM', 'Logout', 'arneganuhay'),
('02-14,2019', '07:28:54 PM', 'Login', 'arneganuhay'),
('02-14,2019', '07:32:34 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 35 Price: 19.0 Total Price: 665', 'arneganuhay'),
('02-14,2019', '08:12:54 PM', 'Logout', 'arneganuhay'),
('02-15,2019', '12:12:11 PM', 'Login', 'arneganuhay'),
('02-15,2019', '12:14:18 PM', 'Stock In : ID: 1007 Product Name:Tuna (White)QTY:100', 'arneganuhay'),
('02-15,2019', '12:14:33 PM', 'Stock In : ID: 1006 Product Name:Double Cheese - WhiteQTY:100', 'arneganuhay'),
('02-15,2019', '12:14:44 PM', 'Stock In : ID: 1006 Product Name:Double Cheese - WhiteQTY:100.555', 'arneganuhay'),
('02-15,2019', '12:15:12 PM', 'Stock Out : ID: 1006 Product Name:Double Cheese - WhiteQTY:200.555', 'arneganuhay'),
('02-15,2019', '12:15:22 PM', 'Stock Out : ID: 1006 Product Name:Double Cheese - WhiteQTY:100.555', 'arneganuhay'),
('02-15,2019', '12:24:02 PM', 'Logout', 'arneganuhay'),
('12-13,2019', '11:33:21 AM', 'Login', 'arneganuhay'),
('12-14,2019', '04:27:54 PM', 'Stock In : ID: 1005 Product Name:Ham & Cheese - YellowQTY:200', ''),
('12-14,2019', '04:28:02 PM', 'has been deleted :! -Product Name: Ube Category: SIOPAO Portion: 1pk = 15pcs Serving : none Price: 14.0 QTY: 0.0', ''),
('12-14,2019', '04:28:36 PM', 'Stock Out : ID: 1005 Product Name:Ham & Cheese - YellowQTY:2', ''),
('12-14,2019', '04:29:05 PM', 'Stock In : ID: 1004 Product Name:Chiken(Yellow)QTY:12', ''),
('12-14,2019', '04:29:12 PM', 'Stock In : ID: 1002 Product Name:Asado P(No Color)QTY:12', ''),
('12-14,2019', '04:34:37 PM', 'Logout', ''),
('12-14,2019', '04:34:59 PM', 'Login', 'fhernand'),
('12-14,2019', '04:35:30 PM', 'Stock In : ID: 1001 Product Name:Toasted P (Yellow Dough)QTY:12', 'fhernand'),
('12-14,2019', '04:36:32 PM', 'Logout', 'fhernand'),
('12-14,2019', '04:36:46 PM', 'Login', 'fhernand'),
('12-14,2019', '04:37:06 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 1 Price: 19.0 Total Price: 19', 'fhernand'),
('12-14,2019', '04:37:06 PM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 1 Price: 20.0 Total Price: 20', 'fhernand'),
('12-14,2019', '04:37:06 PM', 'Sales : ID: 1011 Product Name: Sphagetti Pasta QTY: 1 Price: 40.0 Total Price: 40', 'fhernand'),
('12-14,2019', '04:37:06 PM', 'Sales : ID: 1010 Product Name: Baguette (Beef w/ Chicken) QTY: 1 Price: 29.0 Total Price: 29', 'fhernand'),
('12-14,2019', '04:37:35 PM', 'Logout', 'fhernand'),
('12-14,2019', '04:37:45 PM', 'Login', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1007 Product Name: Tuna (White) QTY: 1 Price: 19.0 Total Price: 19', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1005 Product Name: Ham & Cheese - Yellow QTY: 1 Price: 19.0 Total Price: 19', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1001 Product Name: Toasted P (Yellow Dough) QTY: 1 Price: 20.0 Total Price: 20', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1011 Product Name: Sphagetti Pasta QTY: 1 Price: 40.0 Total Price: 40', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1009 Product Name: Pizza Roll (Ham with Cheese) QTY: 11 Price: 20.0 Total Price: 220', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1006 Product Name: Double Cheese - White QTY: 1 Price: 19.0 Total Price: 19', 'fhernand'),
('12-14,2019', '04:39:21 PM', 'Sales : ID: 1002 Product Name: Asado P(No Color) QTY: 1 Price: 20.32 Total Price: 20.32', 'fhernand'),
('12-14,2019', '04:39:54 PM', 'Logout', 'fhernand'),
('12-14,2019', '04:42:25 PM', 'Login', 'jerome'),
('12-14,2019', '04:43:35 PM', 'Logout', ''),
('12-14,2019', '04:43:52 PM', 'Login', 'fhernand'),
('12-14,2019', '04:47:42 PM', 'Login', 'fhernand'),
('12-14,2019', '04:47:59 PM', 'Stock In : ID: 1013 Product Name:Carbonata PastaQTY:123', 'fhernand');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inv_products`
--
ALTER TABLE `inv_products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usertype_table`
--
ALTER TABLE `usertype_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inv_products`
--
ALTER TABLE `inv_products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1017;

--
-- AUTO_INCREMENT for table `usertype_table`
--
ALTER TABLE `usertype_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
