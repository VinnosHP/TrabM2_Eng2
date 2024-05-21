package services.interfaces;

import java.util.List;

import repositories.dto.Answer;
import repositories.dto.Question;
import webapp.dto.QuestionForm;

public interface IQuestion {
    int getUserQuestionCount(Integer userPk);

    List<Question> getUserQuestions(Integer userPk);

    List<Answer> getAnswersForQuestion(Integer questionPk);

    int getAnswersForQuestionCount(Integer questionPk);

    List<Question> getAllUsersQuestions(QuestionForm form);

    QuestionForm getQuestion(Integer questionPk);

    void insertQuestion(QuestionForm form);

    void updateQuestion(QuestionForm form);

    void deleteQuestion(Integer questionPk);
}
