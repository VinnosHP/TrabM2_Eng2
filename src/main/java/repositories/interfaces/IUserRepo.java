package repositories.interfaces;

import java.util.List;

import models.User;

public interface IUserRepo {
    List<User> getUserList(int userPk);

    void createNewUser(int questionPk);

    void updateUser(int answerPk);

    void deleteUser(int answerPk);
}
