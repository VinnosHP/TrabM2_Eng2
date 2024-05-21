package repositories.interfaces;

import java.util.List;

import repositories.dto.AnswerDTO;
import webapp.dto.AnswerForm;

public interface IAnswerRepo {
    List<AnswerDTO> getAllUsersAnswers(AnswerForm form);

    List<AnswerDTO> getAnswersByUser(Integer userPk);

    List<AnswerDTO> getAnswersByQuestion(Integer questionPk);

    void insertAnswer(AnswerForm form);

    void updateAnswer(AnswerForm form);

    void deleteAnswer(Integer answerPk);
}
