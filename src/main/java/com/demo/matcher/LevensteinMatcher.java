package com.demo.matcher;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LevensteinMatcher implements Matcher {
    private static LevensteinMatcher instance;

    private LevensteinMatcher() {}

    public static LevensteinMatcher getInstance() {
        if (instance == null) {
            instance = new LevensteinMatcher();
        }
        return instance;
    }

    @Override
    public List<String> match(List<String> lines, List<String> patterns) {
        List<String> matches = new ArrayList<String>();
        for (String line : lines) {
            for (String pattern : patterns) {
                if (StringUtils.getLevenshteinDistance(line, pattern) <= 1) {
                    matches.add(line);
                }
            }
        }
        return matches;
    }
}
