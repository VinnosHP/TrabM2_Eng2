package repositories.interfaces;

import java.util.List;

import models.Question;

public interface IQuestionRepo {
    List<Question> getUserQuestions(int userPk);

    void insertQuestion(int userPk);

    void updateQuestion(int questionPk);

    void deleteQuestion(int questionPk);
}
