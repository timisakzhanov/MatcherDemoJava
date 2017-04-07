package com.demo.matcher;

import java.util.ArrayList;
import java.util.List;

public class ExactMatcher implements Matcher {
    private static ExactMatcher instance;

    private ExactMatcher() {}

    public static ExactMatcher getInstance() {
        if (instance == null) {
            instance = new ExactMatcher();
        }
        return instance;
    }

    @Override
    public List<String> match(List<String> lines, List<String> patterns) {
        List<String> matches = new ArrayList<String>();
        for(String line : lines) {
            for(String pattern : patterns) {
                if (line.equals(pattern)) {
                    matches.add(line);
                }
            }
        }
        return matches;
    }
}
