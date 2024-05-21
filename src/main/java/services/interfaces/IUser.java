package services.interfaces;

import java.util.List;

import repositories.dto.UserDTO;
import web.dto.UserForm;

public interface IUser {
    Integer getUserPkByEmailAndPassword(String email, String password);

    boolean validateUserLogin(String email, String password);

    List<UserDTO> getUsersList();

    UserForm getUser(Integer userPk);

    void createNewUser(UserForm form);

    void updateUser(UserForm form);

    void deleteUser(Integer userPk);
}
