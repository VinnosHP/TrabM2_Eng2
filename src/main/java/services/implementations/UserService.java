package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.UserDTO;
import repositories.interfaces.IUserRepo;
import services.interfaces.IUser;
import web.dto.UserForm;

@Service
public class UserService implements IUser {

    private final IUserRepo userRepo;

    @Autowired
    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Integer getUserPkByEmailAndPassword(String email, String password) {
        List<UserDTO> userList = userRepo.getUsersList();

        for (UserDTO user : userList) {
            if (user.getUserEmail().trim().equals(email) && user.getUserPassword().trim().equals(password)) {
                return user.getUserPk();
            }
        }

        return null;
    }

    @Override
    public boolean validateUserLogin(String email, String password) {
        Integer userPk = getUserPkByEmailAndPassword(email, password);

        return userPk != null;
    }

    @Override
    public List<UserDTO> getUsersList() {
        return userRepo.getUsersList();
    }

    @Override
    public UserForm getUser(Integer userPk) {
        UserForm getUser = userRepo.getUser(userPk);

        return getUser.clone();
    }

    @Override
    public void createNewUser(UserForm form) {
        UserForm newUser = form.clone();
        userRepo.createNewUser(newUser);
    }

    @Override
    public void updateUser(UserForm form) {
        UserForm updatedUser = form.clone();
        userRepo.updateUser(updatedUser);
    }

    @Override
    public void deleteUser(Integer userPk) {
        userRepo.deleteUser(userPk);
    }
}
