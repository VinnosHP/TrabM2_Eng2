package repositories.interfaces;

import java.util.List;

import repositories.dto.Answer;
import webapp.dto.AnswerForm;

public interface IAnswerRepo {
    List<Answer> getAllUsersAnswers(AnswerForm form);

    List<Answer> getAnswersByUser(Integer userPk);

    List<Answer> getAnswersByQuestion(Integer questionPk);

    void insertAnswer(AnswerForm form);

    void updateAnswer(AnswerForm form);

    void deleteAnswer(Integer answerPk);
}
