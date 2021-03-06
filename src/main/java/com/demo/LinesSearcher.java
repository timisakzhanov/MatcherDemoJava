package com.demo;

import com.demo.io.ConsoleIO;
import com.demo.io.IOInterface;
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
    private IOInterface userIO;

    public LinesSearcher(String textFile, String patternsFile) {
        userIO = ConsoleIO.getInstance();

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
        String matchType = askForMethod();
        matcher = MatchersFactory.getMatcher(matchType);
        if (matcher == null) {
            userIO.printMessage("Wrong method name");
            return;
        }

        List<String> matches = matcher.match(textLines, patternLines);
        printMatches(matches);
    }

    private String askForMethod() {
        userIO.printMessage("Select method to use (exact, contain or levenstein): ");
        return userIO.readInput();
    }

    private void printMatches(List<String> matches) {
        if (matches == null || matches.size() == 0) {
            userIO.printMessage("Nothing found");
        }
        for (String line : matches) {
            userIO.printMessage(line);
        }
    }
}
