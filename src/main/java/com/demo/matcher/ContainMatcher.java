package com.demo.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ContainMatcher implements Matcher {
    private static ContainMatcher instance;

    private ContainMatcher() {}

    public static ContainMatcher getInstance() {
        if (instance == null) {
            instance = new ContainMatcher();
        }
        return instance;
    }

    @Override
    public List<String> match(List<String> lines, List<String> patterns) {
        List<String> matches = new ArrayList<String>();
        for (String line : lines) {
            for (String pattern: patterns) {
                if (line.contains(pattern)) {
                    matches.add(line);
                }
            }
        }
        return matches;
    }
}
