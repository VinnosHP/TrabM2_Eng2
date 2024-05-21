package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.Answer;
import repositories.interfaces.IAnswerRepo;
import services.interfaces.IAnswer;
import webapp.dto.AnswerForm;

@Service
public class AnswerService implements IAnswer {
    private final IAnswerRepo answerRepo;

    @Autowired
    public AnswerService(IAnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    @Override
    public int getUserAnswerCount(Integer userPk) {
        List<Answer> userAnswers = answerRepo.getAnswersByUser(userPk);

        return userAnswers.size();
    }

    @Override
    public List<Answer> getUserAnswers(Integer userPk) {
        return answerRepo.getAnswersByUser(userPk);
    }

    @Override
    public List<Answer> getAllUsersAnswers(AnswerForm form) {
        return answerRepo.getAllUsersAnswers(form);
    }

    @Override
    public List<Answer> getAnswersByQuestion(Integer questionPk) {
        return answerRepo.getAnswersByQuestion(questionPk);
    }

    @Override
    public void insertAnswer(AnswerForm form) {
        answerRepo.insertAnswer(form);
    }

    @Override
    public void updateAnswer(AnswerForm form) {
        answerRepo.updateAnswer(form);
    }

    @Override
    public void deleteAnswer(Integer answerPk) {
        answerRepo.deleteAnswer(answerPk);
    }
}
