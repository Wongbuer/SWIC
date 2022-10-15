package org.example;

import java.util.List;

public class ShiftObserver implements Observer {
    private List<String> afterShift;
    private List<String> beforeShift;

    public ShiftObserver(List<String> beforeShift, List<String> afterShift) {
        this.beforeShift = beforeShift;
        this.afterShift = afterShift;
    }

    @Override
    public void process() {
        this.processShift(beforeShift, afterShift);
    }

    private void processShift(List<String> sentences, List<String> afterShift) {
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
                afterShift.add(builder.toString().trim());
            }
        });
    }
}
