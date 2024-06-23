package observers.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import models.Answer;
import observers.interfaces.IObserver;
import observers.interfaces.ISubject;

@Component
public class Subject implements ISubject {
    private List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Answer answer) {
        for (IObserver observer : observers) {
            observer.update(answer);
        }
    }
}
