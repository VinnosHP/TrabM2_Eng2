package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.dto.UserDTO;
import repositories.interfaces.IUserRepo;
import services.interfaces.IUser;
import webapp.dto.UserForm;

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
            if (user.getUserEmail().equals(email) && user.getUserPassword().equals(password)) {
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
        return userRepo.getUser(userPk);
    }

    @Override
    public void createNewUser(UserForm form) {
        userRepo.createNewUser(form);
    }

    @Override
    public void updateUser(UserForm form) {
        userRepo.updateUser(form);
    }

    @Override
    public void deleteUser(Integer userPk) {
        userRepo.deleteUser(userPk);
    }
}
