-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Počítač: 127.0.0.1
-- Vytvořeno: Ned 07. bře 2021, 12:26
-- Verze serveru: 10.4.11-MariaDB
-- Verze PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databáze: `autoservis`
--

-- --------------------------------------------------------

--
-- Struktura tabulky `objednani`
--

CREATE TABLE `objednani` (
  `id` int(11) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `spz` varchar(8) DEFAULT NULL,
  `typeofproblem` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Vypisuji data pro tabulku `objednani`
--

INSERT INTO `objednani` (`id`, `name`, `date`, `phone`, `spz`, `typeofproblem`) VALUES
(1, 'Miroslav Novák', '2021-01-20 15:30:00', '737555642', '4A22525', 'výfuk'),
(2, 'Jiří Chmíří', '2021-01-21 16:30:00', '735222111', '5B68973', 'řízení'),
(3, 'Jarda Blecha', '2021-02-03 10:30:00', '735789756', 'xd456789', 'Řízení');

--
-- Klíče pro exportované tabulky
--

--
-- Klíče pro tabulku `objednani`
--
ALTER TABLE `objednani`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `objednani`
--
ALTER TABLE `objednani`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
