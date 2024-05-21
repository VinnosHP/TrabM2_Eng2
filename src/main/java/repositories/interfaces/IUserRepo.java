package repositories.interfaces;

import java.util.List;

import repositories.dto.User;
import webapp.dto.UserForm;

public interface IUserRepo {
    List<User> getUsersList();

    UserForm getUser(Integer userPk);

    Boolean getUserLogin(String email, String password, Integer userPk);

    void createNewUser(UserForm form);

    void updateUser(UserForm form);

    void deleteUser(Integer userPk);
}
