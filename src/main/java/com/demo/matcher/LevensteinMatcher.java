package com.demo.matcher;

import com.demo.io.UserCommunicationInterface;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class LevensteinMatcher implements Matcher {
    UserCommunicationInterface userIO;

    public LevensteinMatcher(UserCommunicationInterface userIO) {
        this.userIO = userIO;
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
