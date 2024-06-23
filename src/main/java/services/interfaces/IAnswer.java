package services.interfaces;

import java.util.List;

import observers.interfaces.IObserver;
import repositories.dto.AnswerDTO;
import web.dto.AnswerForm;

public interface IAnswer {
    public int getUserAnswerCount(Integer userPk);

    public List<AnswerDTO> getUserAnswers(Integer userPk);

    List<AnswerDTO> getAllUsersAnswers(AnswerForm form);

    Integer getAnswerPkFromAnswerText(String answerText);

    List<AnswerDTO> getAnswersByQuestion(Integer questionPk);

    public void insertAnswer(AnswerForm form);

    public void updateAnswer(AnswerForm form);

    public void deleteAnswer(Integer answerPk);

    public void attachObserver(IObserver observer);

    public void detachObserver(IObserver observer);
}
