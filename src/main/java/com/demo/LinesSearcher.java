package com.demo;

import com.demo.io.ConsoleCommunication;
import com.demo.io.UserCommunicationInterface;
import com.demo.matcher.Matcher;
import com.demo.matcher.MatchersFactory;
import com.demo.utils.Utils;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class LinesSearcher {
    private List<String> textLines;
    private List<String> patternLines;
    private Matcher matcher;
    private UserCommunicationInterface userIO;

    public LinesSearcher(String textFile, String patternsFile) {
        userIO = new ConsoleCommunication();

        try {
            textLines = Utils.readLinesFromFile(textFile);
            patternLines = Utils.readLinesFromFile(patternsFile);
        } catch (IOException e) {
            LoggerFactory.getLogger(LinesSearcher.class).error("error" , e.fillInStackTrace());
        }
    }

    public void searchForMatches() {
        if (textLines == null || patternLines == null) {
            userIO.printMessage("Put files text.txt and patterns.txt to MatcherDemo folder");
            return;
        }
        int matchType = askForMethod();
        matcher = MatchersFactory.getMatcher(matchType, userIO);
        if (matcher == null) {
            userIO.printMessage("Wrong matcher type");
            return;
        }
        matcher.match(textLines, patternLines);
    }

    private int askForMethod() {
        int method = -1;
        userIO.printMessage("Select method to use (1 - exact, 2 - contain, 3 - levenstein): ");
        String input = userIO.readInput();
        try {
            method = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            LoggerFactory.getLogger(LinesSearcher.class).error("error" , e.fillInStackTrace());
        }
        return method;
    }
}
