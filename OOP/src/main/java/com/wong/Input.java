package com.wong;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private List<String> sentences = new ArrayList<>();
    private String filename;

    public Input(String filename) {
        this.filename = filename;
    }

    public Input() {
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public void processInput() throws Exception {
        this.processInput(this.filename);
    }

    public void processInput(String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            sentences.add(line);
        }
        reader.close();
    }
}
