package repositories.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.Answer;
import repositories.interfaces.IAnswerRepo;

@Repository
public class AnswerRepoImpl implements IAnswerRepo {

    @Override
    public List<Answer> getUserAnswers(int userPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserAnswers'");
    }

    @Override
    public void insertAnswer(int questionPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertAnswer'");
    }

    @Override
    public void updateAnswer(int answerPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateAnswer'");
    }

    @Override
    public void deleteaAnswer(int answerPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteaAnswer'");
    }

}
