package com.wong;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private List<String> after = new ArrayList<>();

    private List<String> sentences = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Main program = new Main();
        program.processInput("F:\\java\\SoftwareArchitecture\\SWIC\\hello.txt");
        program.processShift();
        program.processSort();
        program.processOutput("F:\\java\\SoftwareArchitecture\\SWIC\\output.txt");
        System.out.println("hello");
    }

    public void processInput(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            sentences.add(line);
        }
        reader.close();
    }

    public void processShift() {
        if (sentences.size() <= 0) {
            throw new RuntimeException();
        }
        sentences.forEach(sentence -> {
            String[] split = sentence.split("\s");
            for (int i = 0; i < split.length; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = i; j < split.length; j++) {
                    builder.append(split[j] + " ");
                }

                for (int k = 0; k < i; k++) {
                    builder.append(split[k] + " ");
                }
                after.add(builder.toString().trim());
            }
        });
    }

    public void processSort() {
        for (int i = 0; i < after.size(); i++) {
            for (int j = i + 1; j < after.size(); j++) {
                if (after.get(i).toLowerCase().charAt(0) > after.get(j).toLowerCase().charAt(0)) {
                    String temp = after.get(i);
                    after.set(i, after.get(j));
                    after.set(j, temp);
                }
            }
        }
    }

    public void processOutput(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        after.forEach(sentence -> {
            try {
                writer.write(sentence + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.close();
    }
}
