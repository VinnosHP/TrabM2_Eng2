CREATE TABLE `question` (
    `question_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `user_pk` INT NOT NULL,
    `question_text` TEXT NOT NULL,
    CONSTRAINT `fk_question_user_pk`
    FOREIGN KEY (`user_pk`) REFERENCES `user` (`user_pk`) ON DELETE CASCADE
);


