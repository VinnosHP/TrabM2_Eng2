package services.interfaces;

import java.util.List;

import repositories.dto.Answer;
import webapp.dto.AnswerForm;

public interface IAnswer {
    public int getUserAnswerCount(Integer userPk);

    public List<Answer> getUserAnswers(Integer userPk);

    List<Answer> getAllUsersAnswers(AnswerForm form);

    List<Answer> getAnswersByQuestion(Integer questionPk);

    public void insertAnswer(AnswerForm form);

    public void updateAnswer(AnswerForm form);

    public void deleteAnswer(Integer answerPk);
}
