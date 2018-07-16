-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-07-16 13:44:10
-- 服务器版本： 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_book`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_author`
--

CREATE TABLE `t_author` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_author`
--

INSERT INTO `t_author` (`id`, `name`, `dob`, `gender`) VALUES
(1, '胡建伟', '1973-08-19', '男'),
(2, '曹雪梅', '1984-03-27', '女');

-- --------------------------------------------------------

--
-- 表的结构 `t_book`
--

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL,
  `bookName` varchar(20) NOT NULL,
  `bookDesc` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `bookTypeId` int(11) NOT NULL,
  `authorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_book`
--

INSERT INTO `t_book` (`id`, `bookName`, `bookDesc`, `price`, `bookTypeId`, `authorId`) VALUES
(1, '系统设计', '系统的设计与实现。', 98, 2, 1),
(2, '数据库设计与实现', '讲述了数据库的设计与实现。', 98, 2, 2);

-- --------------------------------------------------------

--
-- 表的结构 `t_booktype`
--

CREATE TABLE `t_booktype` (
  `id` int(11) NOT NULL,
  `bookTypeName` varchar(20) NOT NULL,
  `bookTypeDesc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_booktype`
--

INSERT INTO `t_booktype` (`id`, `bookTypeName`, `bookTypeDesc`) VALUES
(1, '文学类', '文学相关图书。'),
(2, '计算机类', '计算机相关图书。'),
(3, '建筑类', '');

-- --------------------------------------------------------

--
-- 表的结构 `t_user`
--

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '12345'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `t_user`
--

INSERT INTO `t_user` (`id`, `username`, `password`) VALUES
(1, '012345', '12345'),
(2, '054321', '12345');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_author`
--
ALTER TABLE `t_author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_book`
--
ALTER TABLE `t_book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `t_book_fk0` (`bookTypeId`),
  ADD KEY `t_book_fk1` (`authorId`);

--
-- Indexes for table `t_booktype`
--
ALTER TABLE `t_booktype`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_user`
--
ALTER TABLE `t_user`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `t_author`
--
ALTER TABLE `t_author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `t_book`
--
ALTER TABLE `t_book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `t_booktype`
--
ALTER TABLE `t_booktype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `t_user`
--
ALTER TABLE `t_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 限制导出的表
--

--
-- 限制表 `t_book`
--
ALTER TABLE `t_book`
  ADD CONSTRAINT `t_book_fk0` FOREIGN KEY (`bookTypeId`) REFERENCES `t_booktype` (`id`),
  ADD CONSTRAINT `t_book_fk1` FOREIGN KEY (`authorId`) REFERENCES `t_author` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
