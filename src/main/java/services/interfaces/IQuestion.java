package services.interfaces;

import java.util.List;

import repositories.dto.AnswerDTO;
import repositories.dto.QuestionDTO;
import web.dto.QuestionForm;

public interface IQuestion {
    int getUserQuestionCount(Integer userPk);

    List<QuestionDTO> getUserQuestions(Integer userPk);

    List<AnswerDTO> getAnswersForQuestion(Integer questionPk);

    int getAnswersForQuestionCount(Integer questionPk);

    List<QuestionDTO> getAllUsersQuestions(QuestionForm form);

    QuestionForm getQuestion(Integer questionPk);

    void insertQuestion(QuestionForm form);

    void updateQuestion(QuestionForm form);

    void deleteQuestion(Integer questionPk);
}
