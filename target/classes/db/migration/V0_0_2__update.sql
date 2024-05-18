CREATE TABLE `user` (
    `user_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(40)  NOT NULL,
    `email` VARCHAR(40) NOT NULL,
    `password` VARCHAR(40) NOT NULL
);

CREATE TABLE `question` (
    `question_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `user_pk` INT NOT NULL,
    `question_text` TEXT NOT NULL,
    ADD CONSTRAINT `fk_question_user_pk`
    FOREIGN KEY (`user_pk`) REFERENCES `user` (`user_pk`) ON DELETE CASCADE
);

CREATE TABLE `answer` (
    `answer_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `user_answer_pk`INT NOT NULL,
    `question_pk` INT NOT NULL,
    `answer_text` TEXT NOT NULL,
    ADD CONSTRAINT `fk_answer_question_pk`
    FOREIGN KEY (`question_pk`) REFERENCES `question` (`question_pk`) ON DELETE CASCADE
    ADD CONSTRAINT `fk_answer_user_answer_pk` 
    FOREIGN KEY (`user_answer_pk`) REFERENCES `user` (`user_pk`) ON DELETE CASCADE
);

