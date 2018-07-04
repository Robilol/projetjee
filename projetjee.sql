-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  mar. 03 juil. 2018 à 22:50
-- Version du serveur :  5.6.38
-- Version de PHP :  7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `jee`
--

-- --------------------------------------------------------

--
-- Structure de la table `url`
--

CREATE TABLE `url` (
  `id` int(11) NOT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `url_original` text NOT NULL,
  `url_short` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `captcha` varchar(10) NOT NULL DEFAULT '0',
  `email` varchar(100) DEFAULT NULL,
  `date_start` varchar(30) DEFAULT NULL,
  `date_end` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `url`
--

INSERT INTO `url` (`id`, `user_id`, `url_original`, `url_short`, `password`, `captcha`, `email`, `date_start`, `date_end`) VALUES
(22, '0', 'https://www.youtube.com/', 'http://localhost:8282/index3fe5149b9544db59', '', '0', '', '', ''),
(23, '0', '', '', '', '0', '', '', ''),
(24, '0', '', '', '', '0', '', '', ''),
(25, '0', '', '', '', '0', '', '', ''),
(26, '0', 'https://github.com/Robilol/projetjee/issues', 'http://localhost:8282/3fe11e8bf3800788', '', '0', '', '', ''),
(27, '0', 'https://github.com/Robilol/projetjee/issues', 'http://localhost:8282/3fe4', '', '0', '', '', ''),
(28, '0', 'https://github.com/Robilol/projetjee/issues', 'http://localhost:8282/3fcf', '', '0', '', '', ''),
(29, '0', 'https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java', 'http://localhost:8282/3fd7', '', '0', '', '', ''),
(30, '0', 'https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java', 'http://localhost:8282/3fd5', '', '0', '', '', ''),
(31, '0', 'https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java', 'http://localhost:8282/3fd8', '', '0', '', '', ''),
(32, '0', 'https://github.com/davidkiss/yourl/blob/master/src/main/java/com/yourl/controller/dto/ShortenUrlRequest.java', 'http://localhost:8282/3fcf', '', '0', '', '', ''),
(33, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/9767', '', '0', '', '', ''),
(34, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/6f96', '', '0', '', '', ''),
(35, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/b3ad', '', '0', '', '', ''),
(36, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/1047', '', '0', '', '', ''),
(37, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/0175', '', '0', '', '', ''),
(38, '0', 'https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string', 'http://localhost:8282/99c7', '', '0', '', '', '');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(45) NOT NULL,
  `token` varchar(60) DEFAULT NULL,
  `validated` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `type`, `token`, `validated`) VALUES
(1, 'fdisu@jfd.fr', 'dsfghj', 'association', NULL, 0),
(2, 'fezgrhtyj@frgt.fr', 'fegrhtyju', 'particulier', NULL, 0),
(3, 'dsfedgr@fgr.fe', 'fdsg', 'entreprise', NULL, 0),
(4, 'dsfg@dferg.fr', 'defzrgt', 'particulier', NULL, 0),
(5, 'dfsg@n.fr', 'fdg', 'particulier', NULL, 0),
(6, 'defsre@dfgr.f', 'sefrd', 'association', NULL, 0),
(7, 'dfsg@bhv.njb', 'fsrdgf', 'association', NULL, 0),
(8, 'dsf@dfsg.f', 'fegr', 'particulier', NULL, 0),
(9, 'zdfesgrdht@dfs.gr', 'fsgrthr', 'entreprise', NULL, 0),
(10, 'gui@aol.fr', 'test', 'particulier', NULL, 0),
(11, 'gui@test.fr', 'test', 'particulier', NULL, 0),
(12, 'guillaumepn@free.fr', 'test', 'test', 'XKTR7Gs4GU74FGUs', 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `url`
--
ALTER TABLE `url`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `url`
--
ALTER TABLE `url`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
