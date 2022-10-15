package com.wong;

import java.util.LinkedList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new LinkedList<>();

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyAllObservers() {
        observerList.forEach(Observer::process);
    }

    public void notifyOneObserver(int index) {
        observerList.get(index).process();
    }
}
