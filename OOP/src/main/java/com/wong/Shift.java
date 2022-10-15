package com.wong;

import java.util.ArrayList;
import java.util.List;

public class Shift {
    private List<String> after = new ArrayList<>();

    public Shift() {
    }

    public List<String> getAfter() {
        return after;
    }

    public void setAfter(List<String> after) {
        this.after = after;
    }

    public void processShift(List<String> sentences) {
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
}
