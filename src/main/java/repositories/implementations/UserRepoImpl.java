package repositories.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.User;
import repositories.interfaces.IUserRepo;

@Repository
public class UserRepoImpl implements IUserRepo {

    @Override
    public List<User> getUserList(int userPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserList'");
    }

    @Override
    public void createNewUser(int questionPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNewUser'");
    }

    @Override
    public void updateUser(int answerPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void deleteUser(int answerPk) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

}
