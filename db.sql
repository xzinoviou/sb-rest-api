
DROP TABLE `employee` IF EXISTS;

CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `date_of_creation` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `employee` (`id`, `first_name`, `last_name`, `email`, `date_of_creation`) values
(1,'Nicolo', 'Paganini', 'npaganini@classical.com', now()),
(2,'Hector', 'Berlioz', 'hberlioz@classical.com', now()),
(3,'Franz', 'Liszt', 'fliszt@classical.com', now()),
(4,'Sergei', 'Rachmaninoff', 'srachmaninoff@classical.com', now());