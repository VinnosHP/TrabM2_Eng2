package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.Answer;
import repositories.dto.Question;
import repositories.dto.User;
import services.interfaces.IAnswer;
import services.interfaces.IQuestion;
import services.interfaces.IUser;
import webapp.dto.AnswerForm;
import webapp.dto.QuestionForm;
import webapp.dto.UserForm;

@Service
public class FacadeService {
    private final IUser userService;

    private final IQuestion questionService;

    private final IAnswer answerService;

    @Autowired
    public FacadeService(IUser userService, IQuestion questionService, IAnswer answerService) {
        this.userService = userService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    // Methods related to user

    public boolean login(String email, String password) {
        return userService.validateUserLogin(email, password);
    }

    public void createNewUser(UserForm form) {
        userService.createNewUser(form);
    }

    public void updateUser(UserForm form) {
        userService.updateUser(form);
    }

    public void deleteUser(Integer userPk) {
        userService.deleteUser(userPk);
    }

    public List<User> getUsersList() {
        return userService.getUsersList();
    }

    public UserForm getUser(Integer userPk) {
        return userService.getUser(userPk);
    }

    // Methods related to questions

    public int getUserQuestionCount(Integer userPk) {
        return questionService.getUserQuestionCount(userPk);
    }

    public List<Question> getUserQuestions(Integer userPk) {
        return questionService.getUserQuestions(userPk);
    }

    public void insertQuestion(QuestionForm form) {
        questionService.insertQuestion(form);
    }

    public void updateQuestion(QuestionForm form) {
        questionService.updateQuestion(form);
    }

    public void deleteQuestion(Integer questionPk) {
        questionService.deleteQuestion(questionPk);
    }

    // Methods related to answers

    public int getUserAnswerCount(Integer userPk) {
        return answerService.getUserAnswerCount(userPk);
    }

    public List<Answer> getUserAnswers(Integer userPk) {
        return answerService.getUserAnswers(userPk);
    }

    public void insertAnswer(AnswerForm form) {
        answerService.insertAnswer(form);
    }

    public void updateAnswer(AnswerForm form) {
        answerService.updateAnswer(form);
    }

    public void deleteAnswer(Integer answerPk) {
        answerService.deleteAnswer(answerPk);
    }

    // Methods related to answers and questions

    public List<Answer> getAnswersForQuestion(Integer questionPk) {
        return questionService.getAnswersForQuestion(questionPk);
    }

    public int getAnswersForQuestionCount(Integer questionPk) {
        return questionService.getAnswersForQuestionCount(questionPk);
    }

}
