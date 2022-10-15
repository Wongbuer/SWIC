package com.wong;

public class KWICSubject extends Subject {
    public void startProgram() {
        super.notifyAllObservers();
    }
}
