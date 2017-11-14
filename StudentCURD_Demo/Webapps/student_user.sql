CREATE TABLE IF NOT EXISTS student_user (
`id` INT UNSIGNED AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL,
`sex` VARCHAR(10) NOT NULL,
`birthday` DATE,
`pic` VARCHAR(100),
`likesome` VARCHAR(100),
`phone` VARCHAR(100) NOT NULL,
`address` VARCHAR(100) NOT NULL,
`aboutme` VARCHAR(100) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
