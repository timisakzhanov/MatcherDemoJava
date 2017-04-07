package com.demo.matcher;

import com.demo.io.IOInterface;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LevensteinMatcher implements Matcher {
    private IOInterface userIO;
    private static LevensteinMatcher instance;

    private LevensteinMatcher() {}

    private LevensteinMatcher(IOInterface userIO) {
        this.userIO = userIO;
    }

    public static LevensteinMatcher getInstance(IOInterface io) {
        if (instance == null) {
            instance = new LevensteinMatcher(io);
        }
        return instance;
    }

    @Override
    public void match(List<String> lines, List<String> patterns) {
        userIO.printMessage("Lines require no more than 1 changes to match pattern: ");
        for (String line : lines) {
            for (String pattern : patterns) {
                if (StringUtils.getLevenshteinDistance(line, pattern) <= 1) {
                    userIO.printMessage(line);
                }
            }
        }
    }
}
