package observers.implementations;

import models.Answer;
import models.User;
import observers.interfaces.IObserver;

public class UserObserver implements IObserver {
    private final User user;

    public UserObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(Answer answer) {
        System.out.println("User " + user.getName() + " was notified about a new answer  " + answer.getAnswerText());
    }
}
