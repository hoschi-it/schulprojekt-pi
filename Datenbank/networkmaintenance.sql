-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 03. Mrz 2020 um 12:46
-- Server-Version: 10.1.36-MariaDB
-- PHP-Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `networkmaintenance`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `device`
--

CREATE TABLE `device` (
  `Id_Device` int(20) NOT NULL,
  `Type` varchar(100) NOT NULL,
  `Last_Maintenance` date NOT NULL,
  `Next_Maintenance` date DEFAULT NULL,
  `Id_Location` int(255) NOT NULL,
  `Employee_No` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `device`
--

INSERT INTO `device` (`Id_Device`, `Type`, `Last_Maintenance`, `Next_Maintenance`, `Id_Location`, `Employee_No`) VALUES
(1, 'Router', '2020-02-26', '2020-04-21', 2, 1),
(2, 'Router', '2020-05-13', '2020-07-15', 1, 2),
(3, 'Router', '2020-02-20', '2020-03-10', 3, 3),
(4, 'Router - FritzBox X', '2020-02-28', '2020-08-20', 4, 1),
(5, 'Router - ConnectBox XI', '2020-02-27', '2020-08-19', 5, 2),
(6, 'WebServer - Linux', '2019-12-17', '2020-06-11', 6, 3),
(7, 'Webserver - Linux', '2019-12-19', '2020-06-12', 7, 1),
(8, 'Webserver', '2019-12-17', '2020-04-09', 8, 2),
(9, 'Datenbankserver', '2020-01-14', '2020-06-25', 9, 3),
(10, 'Datenbankserver', '2020-02-11', '2020-05-14', 1, 1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `location`
--

CREATE TABLE `location` (
  `Id_Location` int(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Postal_Code` int(255) NOT NULL,
  `Street` varchar(255) NOT NULL,
  `Room_No` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `location`
--

INSERT INTO `location` (`Id_Location`, `City`, `Postal_Code`, `Street`, `Room_No`) VALUES
(1, 'Darmstadt', 61234, 'Strasse 1', '1234'),
(2, 'Darmstadt', 61235, 'Musterstrasse2', 'Raum INGOLSTADT'),
(3, 'Darmstadt', 61236, 'Fackelweg 66a', 'Kammer'),
(4, 'Frankfurt am Main', 60311, 'Konrad-Adenauer-Allee 12', '-'),
(5, 'Frankfurt am Main', 60322, 'Bornwiesenweg 12', '-'),
(6, 'Wiesbaden', 65432, 'Frankfurter Strasse 26', '01.23'),
(7, 'Wiesbaden', 65431, 'Frankfurter Allee 12', '03.21'),
(8, 'Karben', 61118, 'Dieselstrasse 11-20', '02.15'),
(9, 'Bad Vilbel', 61235, 'Frankfurter Pfad 17', '01.45');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `Employee_No` int(50) NOT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`Employee_No`, `First_Name`, `Last_Name`) VALUES
(1, 'Max', 'Mustermann'),
(2, 'Mia', 'Musterfrau'),
(3, 'Marvin', 'Musterkind');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `device`
--
ALTER TABLE `device`
  ADD PRIMARY KEY (`Id_Device`),
  ADD KEY `Id_Device` (`Id_Device`),
  ADD KEY `Id_Device_2` (`Id_Device`),
  ADD KEY `Id_Location` (`Id_Location`),
  ADD KEY `Employee_No` (`Employee_No`);

--
-- Indizes für die Tabelle `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`Id_Location`),
  ADD KEY `Id_Location` (`Id_Location`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Employee_No`),
  ADD KEY `Employee_No` (`Employee_No`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `device`
--
ALTER TABLE `device`
  ADD CONSTRAINT `device_ibfk_1` FOREIGN KEY (`Id_Location`) REFERENCES `location` (`Id_Location`),
  ADD CONSTRAINT `device_ibfk_2` FOREIGN KEY (`Employee_No`) REFERENCES `user` (`Employee_No`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
