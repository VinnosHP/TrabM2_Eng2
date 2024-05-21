package repositories.interfaces;

import java.util.List;

import repositories.dto.UserDTO;
import webapp.dto.UserForm;

public interface IUserRepo {
    List<UserDTO> getUsersList();

    UserForm getUser(Integer userPk);

    void createNewUser(UserForm form);

    void updateUser(UserForm form);

    void deleteUser(Integer userPk);
}
