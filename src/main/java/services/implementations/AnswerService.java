package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Answer;
import observers.interfaces.IObserver;
import observers.interfaces.ISubject;
import repositories.dto.AnswerDTO;
import repositories.interfaces.IAnswerRepo;
import services.interfaces.IAnswer;
import webapp.dto.AnswerForm;

@Service
public class AnswerService implements IAnswer {
    private final IAnswerRepo answerRepo;

    private final ISubject subject;

    @Autowired
    public AnswerService(IAnswerRepo answerRepo, ISubject subject) {
        this.answerRepo = answerRepo;
        this.subject = subject;
    }

    @Override
    public int getUserAnswerCount(Integer userPk) {
        List<AnswerDTO> userAnswers = answerRepo.getAnswersByUser(userPk);

        return userAnswers.size();
    }

    @Override
    public List<AnswerDTO> getUserAnswers(Integer userPk) {
        return answerRepo.getAnswersByUser(userPk);
    }

    @Override
    public List<AnswerDTO> getAllUsersAnswers(AnswerForm form) {
        return answerRepo.getAllUsersAnswers(form);
    }

    @Override
    public List<AnswerDTO> getAnswersByQuestion(Integer questionPk) {
        return answerRepo.getAnswersByQuestion(questionPk);
    }

    @Override
    public void insertAnswer(AnswerForm form) {
        Answer answer = new Answer();
        answer.setAnswerText(form.getAnswerText());
        answer.setQuestionPk(form.getQuestionPk());
        answer.setUserPk(form.getUserPk());

        answerRepo.insertAnswer(form);

        subject.notifyObservers(answer);
    }

    @Override
    public void updateAnswer(AnswerForm form) {
        answerRepo.updateAnswer(form);
    }

    @Override
    public void deleteAnswer(Integer answerPk) {
        answerRepo.deleteAnswer(answerPk);
    }

    @Override
    public void attachObserver(IObserver observer) {
        subject.addObserver(observer);
    }

    @Override
    public void detachObserver(IObserver observer) {
        subject.removeObserver(observer);
    }
}
