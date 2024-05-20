CREATE TABLE `user` (
    `user_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `picture_id` INT(11) NOT NULL,
    `name` VARCHAR(40) NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL
);
