package com.wong;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Input input = new Input("F:\\java\\SoftwareArchitecture\\SWIC\\hello.txt");
        input.processInput();
        List<String> sentences = input.getSentences();
        Shift shift = new Shift();
        shift.processShift(sentences);
        Sort sort = new Sort();
        sort.processSort(shift.getAfter());
        Output output = new Output();
        output.processOutput("F:\\java\\SoftwareArchitecture\\SWIC\\output.txt", shift.getAfter());
    }
}