package repositories.interfaces;

import java.util.List;

import repositories.dto.Answer;
import webapp.dto.AnswerForm;

public interface IAnswerRepo {
    List<Answer> getUserAnswers(AnswerForm form);

    void insertAnswer(AnswerForm form);

    void updateAnswer(AnswerForm form);

    void deleteAnswer(Integer answerPk);
}
