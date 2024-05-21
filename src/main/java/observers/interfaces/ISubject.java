package observers.interfaces;

import models.Answer;

public interface ISubject {
    public void addObserver(IObserver observer);

    public void removeObserver(IObserver observer);

    public void notifyObservers(Answer answer);
}
