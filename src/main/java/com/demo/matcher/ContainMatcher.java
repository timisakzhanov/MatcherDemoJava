package com.demo.matcher;

import com.demo.io.IOInterface;

import java.util.List;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ContainMatcher implements Matcher {
    private IOInterface userIO;
    private static ContainMatcher instance;

    private ContainMatcher() {}

    private ContainMatcher(IOInterface userIO) {
        this.userIO = userIO;
    }

    public static ContainMatcher getInstance(IOInterface io) {
        if (instance == null) {
            instance = new ContainMatcher(io);
        }
        return instance;
    }

    @Override
    public void match(List<String> lines, List<String> patterns) {
        userIO.printMessage("Lines that contains patterns: ");
        for (String line : lines) {
            for (String pattern: patterns) {
                if (line.contains(pattern)) {
                    userIO.printMessage(line);
                }
            }
        }
    }
}
