package repositories.interfaces;

import java.util.List;

import models.Answer;

public interface IAnswerRepo {
    List<Answer> getUserAnswers(int userPk);

    void insertAnswer(int questionPk);

    void updateAnswer(int answerPk);

    void deleteaAnswer(int answerPk);
}
