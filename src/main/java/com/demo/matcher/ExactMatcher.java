package com.demo.matcher;

import com.demo.io.IOInterface;

import java.util.List;

public class ExactMatcher implements Matcher {
    private IOInterface userIO;
    private static ExactMatcher instance;

    private ExactMatcher(IOInterface userIO) {
        this.userIO = userIO;
    }

    private ExactMatcher() {}

    public static ExactMatcher getInstance(IOInterface userIO) {
        if (instance == null) {
            instance = new ExactMatcher(userIO);
        }
        return instance;
    }

    @Override
    public void match(List<String> lines, List<String> patterns) {
        userIO.printMessage("Lines that exactly match patterns: ");
        for(String line : lines) {
            for(String pattern : patterns) {
                if (line.equals(pattern)) {
                    userIO.printMessage(line);
                }
            }
        }
    }
}
