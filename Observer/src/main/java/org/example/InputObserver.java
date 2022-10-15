package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputObserver implements Observer {
    private String filename;
    private List<String> sentences = new ArrayList<>();

    public InputObserver(String filename, List<String> sentences) {
        this.filename = filename;
        this.sentences = sentences;
    }

    public List<String> getSentences() {
        return sentences;
    }

    @Override
    public void process() {
        try {
            this.processInput(this.filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void processInput(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            sentences.add(line);
        }
        reader.close();
    }
}
