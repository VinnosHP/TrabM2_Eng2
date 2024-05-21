package repositories.interfaces;

import java.util.List;

import repositories.dto.QuestionDTO;
import web.dto.QuestionForm;

public interface IQuestionRepo {
    List<QuestionDTO> getAllUsersQuestions(QuestionForm form);

    List<QuestionDTO> getQuestionsByUser(Integer userPk);

    QuestionForm getQuestion(Integer questionPk);

    void insertQuestion(QuestionForm form);

    void updateQuestion(QuestionForm form);

    void deleteQuestion(Integer questionPk);
}
