package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.Answer;
import repositories.dto.Question;
import repositories.interfaces.IAnswerRepo;
import repositories.interfaces.IQuestionRepo;
import services.interfaces.IQuestion;
import webapp.dto.QuestionForm;

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
        List<Question> userQuestions = questionRepo.getQuestionsByUser(userPk);

        return userQuestions.size();
    }

    @Override
    public List<Question> getUserQuestions(Integer userPk) {
        return questionRepo.getQuestionsByUser(userPk);
    }

    @Override
    public List<Answer> getAnswersForQuestion(Integer questionPk) {
        return answerRepo.getAnswersByQuestion(questionPk);
    }

    @Override
    public int getAnswersForQuestionCount(Integer questionPk) {
        List<Answer> answerQuestions = answerRepo.getAnswersByQuestion(questionPk);

        return answerQuestions.size();
    }

    @Override
    public List<Question> getAllUsersQuestions(QuestionForm form) {
        return questionRepo.getAllUsersQuestions(form);
    }

    @Override
    public QuestionForm getQuestion(Integer questionPk) {
        return questionRepo.getQuestion(questionPk);
    }

    @Override
    public void insertQuestion(QuestionForm form) {
        questionRepo.insertQuestion(form);
    }

    @Override
    public void updateQuestion(QuestionForm form) {
        questionRepo.updateQuestion(form);
    }

    @Override
    public void deleteQuestion(Integer questionPk) {
        questionRepo.deleteQuestion(questionPk);
    }
}
