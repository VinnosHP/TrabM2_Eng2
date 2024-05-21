package services.interfaces;

import java.util.List;

import repositories.dto.User;
import webapp.dto.UserForm;

public interface IUser {
    Integer getUserPkByEmailAndPassword(String email, String password);

    boolean validateUserLogin(String email, String password);

    List<User> getUsersList();

    UserForm getUser(Integer userPk);

    void createNewUser(UserForm form);

    void updateUser(UserForm form);

    void deleteUser(Integer userPk);
}
