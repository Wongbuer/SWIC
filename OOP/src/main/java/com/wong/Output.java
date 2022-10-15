package com.wong;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
    public void processOutput(String filename, List<String> after) throws IOException {
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
