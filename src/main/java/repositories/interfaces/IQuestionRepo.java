package repositories.interfaces;

import java.util.List;

import repositories.dto.Question;
import webapp.dto.QuestionForm;

public interface IQuestionRepo {
    List<Question> getAllUsersQuestions(QuestionForm form);

    List<Question> getQuestionsByUser(Integer userPk);

    QuestionForm getQuestion(Integer questionPk);

    void insertQuestion(QuestionForm form);

    void updateQuestion(QuestionForm form);

    void deleteQuestion(Integer questionPk);
}
