package com.demo.matcher;

import com.demo.io.UserCommunicationInterface;

import java.util.List;

public class ExactMatcher implements Matcher {
    private UserCommunicationInterface userIO;

    public ExactMatcher(UserCommunicationInterface userIO) {
        this.userIO = userIO;
    }

    @Override
    public void match(List<String> lines, List<String> patterns) {
        userIO.printMessage("///////////////////////////////");
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
