package com.wong;

import java.util.List;

public class Sort {
    public void processSort(List<String> after) {
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
}
