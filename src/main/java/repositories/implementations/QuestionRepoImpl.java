package repositories.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.Question;
import repositories.interfaces.IQuestionRepo;

@Repository
public class QuestionRepoImpl implements IQuestionRepo {

    @Override
    public List<Question> getUserQuestions(int userPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserQuestions'");
    }

    @Override
    public void insertQuestion(int userPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertQuestion'");
    }

    @Override
    public void updateQuestion(int questionPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateQuestion'");
    }

    @Override
    public void deleteQuestion(int questionPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteQuestion'");
    }

}
