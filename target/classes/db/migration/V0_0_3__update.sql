CREATE TABLE `answer` (
    `answer_pk` INT PRIMARY KEY AUTO_INCREMENT,
    `user_pk`INT NOT NULL,
    `question_pk` INT NOT NULL,
    `answer_text` TEXT NOT NULL,
    CONSTRAINT `fk_answer_question_pk`
    FOREIGN KEY (`question_pk`) REFERENCES `question` (`question_pk`) ON DELETE CASCADE,
    CONSTRAINT `fk_answer_user_pk` 
    FOREIGN KEY (`user_pk`) REFERENCES `user` (`user_pk`) ON DELETE CASCADE
);

