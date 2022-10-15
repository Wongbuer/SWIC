package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> sentences = new ArrayList<>();
        List<String> afterShift = new ArrayList<>();
        KWICSubject kwicSubject = new KWICSubject();
        kwicSubject.addObserver(new InputObserver("F:\\java\\SoftwareArchitecture\\SWIC\\hello.txt", sentences));
        kwicSubject.addObserver(new ShiftObserver(sentences, afterShift));
        kwicSubject.addObserver(new SortObserver(afterShift));
        kwicSubject.addObserver(new OutputObserver("F:\\java\\SoftwareArchitecture\\SWIC\\output.txt", afterShift));
        kwicSubject.startProgram();
    }
}