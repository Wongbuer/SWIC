package com.wong;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputObserver implements Observer {
    private String filename;
    private List<String> outputList;

    public OutputObserver(String filename, List<String> outputList) {
        this.filename = filename;
        this.outputList = outputList;
    }

    @Override
    public void process() {
        try {
            this.processOutput(this.filename, this.outputList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processOutput(String filename, List<String> after) throws IOException {
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
