-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2017-06-15 18:10:36
-- 服务器版本： 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oa`
--

-- --------------------------------------------------------

--
-- 表的结构 `tb_criticism`
--

CREATE TABLE `tb_criticism` (
  `criticismID` int(11) NOT NULL COMMENT '消息批复ID',
  `criticismContent` text COMMENT '批复内容',
  `employeeID` int(11) DEFAULT NULL COMMENT '批复人',
  `criticismTime` datetime DEFAULT NULL COMMENT '批复时间',
  `messageID` int(11) DEFAULT NULL COMMENT '消息ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_employee`
--

CREATE TABLE `tb_employee` (
  `employeeID` int(11) NOT NULL COMMENT '员工编号',
  `employeeName` varchar(255) DEFAULT NULL COMMENT '员工姓名',
  `employeeSex` bit(64) DEFAULT NULL COMMENT '员工性别',
  `employeeBirth` date DEFAULT NULL COMMENT '出生日期',
  `employeePhone` varchar(255) DEFAULT NULL COMMENT '办公室电话',
  `employeePlace` varchar(255) DEFAULT NULL COMMENT '员工住处',
  `joinTime` date DEFAULT NULL COMMENT '录入时间',
  `password` varchar(255) DEFAULT NULL COMMENT '系统口令',
  `isLead` bit(64) DEFAULT NULL COMMENT '是否为领导'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_message`
--

CREATE TABLE `tb_message` (
  `messageID` int(11) NOT NULL COMMENT '消息ID',
  `messageTitle` varchar(255) DEFAULT NULL COMMENT '消息标题',
  `messageContent` text COMMENT '消息内容',
  `employeeID` int(11) DEFAULT NULL COMMENT '发布人',
  `publishTime` datetime DEFAULT NULL COMMENT '发布时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `tb_reply`
--

CREATE TABLE `tb_reply` (
  `replyID` int(11) NOT NULL COMMENT '消息回复ID',
  `replyContent` text COMMENT '回复内容',
  `employeeID` int(11) DEFAULT NULL COMMENT '回复人',
  `replyTime` datetime DEFAULT NULL COMMENT '回复时间',
  `messageID` int(11) DEFAULT NULL COMMENT '消息ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_criticism`
--
ALTER TABLE `tb_criticism`
  ADD PRIMARY KEY (`criticismID`),
  ADD KEY `messageID` (`messageID`),
  ADD KEY `employeeID` (`employeeID`);

--
-- Indexes for table `tb_employee`
--
ALTER TABLE `tb_employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `tb_message`
--
ALTER TABLE `tb_message`
  ADD PRIMARY KEY (`messageID`),
  ADD KEY `employeeID` (`employeeID`);

--
-- Indexes for table `tb_reply`
--
ALTER TABLE `tb_reply`
  ADD PRIMARY KEY (`replyID`),
  ADD KEY `messageID` (`messageID`),
  ADD KEY `employeeID` (`employeeID`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `tb_criticism`
--
ALTER TABLE `tb_criticism`
  MODIFY `criticismID` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息批复ID';
--
-- 使用表AUTO_INCREMENT `tb_employee`
--
ALTER TABLE `tb_employee`
  MODIFY `employeeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号';
--
-- 使用表AUTO_INCREMENT `tb_message`
--
ALTER TABLE `tb_message`
  MODIFY `messageID` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息ID';
--
-- 使用表AUTO_INCREMENT `tb_reply`
--
ALTER TABLE `tb_reply`
  MODIFY `replyID` int(11) NOT NULL AUTO_INCREMENT COMMENT '消息回复ID';
--
-- 限制导出的表
--

--
-- 限制表 `tb_criticism`
--
ALTER TABLE `tb_criticism`
  ADD CONSTRAINT `tb_criticism_ibfk_1` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`),
  ADD CONSTRAINT `tb_criticism_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`);

--
-- 限制表 `tb_message`
--
ALTER TABLE `tb_message`
  ADD CONSTRAINT `employeeID` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`);

--
-- 限制表 `tb_reply`
--
ALTER TABLE `tb_reply`
  ADD CONSTRAINT `tb_reply_ibfk_1` FOREIGN KEY (`messageID`) REFERENCES `tb_message` (`messageID`),
  ADD CONSTRAINT `tb_reply_ibfk_2` FOREIGN KEY (`employeeID`) REFERENCES `tb_employee` (`employeeID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
