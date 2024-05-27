package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.AnswerDTO;
import repositories.dto.QuestionDTO;
import repositories.interfaces.IAnswerRepo;
import repositories.interfaces.IQuestionRepo;
import services.interfaces.IQuestion;
import web.dto.QuestionForm;

@Service
public class QuestionService implements IQuestion {
    private final IQuestionRepo questionRepo;

    private final IAnswerRepo answerRepo;

    @Autowired
    public QuestionService(IQuestionRepo questionRepo, IAnswerRepo answerRepo) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @Override
    public int getUserQuestionCount(Integer userPk) {
        List<QuestionDTO> userQuestions = questionRepo.getQuestionsByUser(userPk);

        return userQuestions.size();
    }

    @Override
    public List<QuestionDTO> getUserQuestions(Integer userPk) {
        return questionRepo.getQuestionsByUser(userPk);
    }

    @Override
    public List<AnswerDTO> getAnswersForQuestion(Integer questionPk) {
        return answerRepo.getAnswersByQuestion(questionPk);
    }

    @Override
    public int getAnswersForQuestionCount(Integer questionPk) {
        List<AnswerDTO> answerQuestions = answerRepo.getAnswersByQuestion(questionPk);

        return answerQuestions.size();
    }

    @Override
    public List<QuestionDTO> getAllUsersQuestions() {
        return questionRepo.getAllUsersQuestions();
    }

    @Override
    public QuestionForm getQuestion(Integer questionPk) {
        QuestionForm getQuestion = questionRepo.getQuestion(questionPk);

        return getQuestion.clone();
    }

    @Override
    public void insertQuestion(QuestionForm form) {
        QuestionForm newQuestion = form.clone();
        questionRepo.insertQuestion(newQuestion);
    }

    @Override
    public void updateQuestion(QuestionForm form) {
        QuestionForm updatedQuestion = form.clone();
        questionRepo.updateQuestion(updatedQuestion);
    }

    @Override
    public void deleteQuestion(Integer questionPk) {
        questionRepo.deleteQuestion(questionPk);
    }
}
