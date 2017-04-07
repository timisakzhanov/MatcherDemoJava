package com.demo.matcher;

import com.demo.io.UserCommunicationInterface;

import java.util.List;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ContainMatcher implements Matcher {
    UserCommunicationInterface userIO;

    public ContainMatcher(UserCommunicationInterface userIO) {
        this.userIO = userIO;
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
