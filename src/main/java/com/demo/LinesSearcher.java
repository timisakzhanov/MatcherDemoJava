package com.demo;

import com.demo.io.ConsoleCommunication;
import com.demo.io.UserCommunicationInterface;
import com.demo.matcher.Matcher;
import com.demo.matcher.MatchersFactory;
import com.demo.utils.Utils;

import java.io.IOException;
import java.util.List;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
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
            userIO.printMessage(e.getMessage());
        }
    }

    public void searchForMatches(int matchType) {
        if (textLines == null || patternLines == null) {
            return;
        }

        matcher = MatchersFactory.getMatcher(matchType, userIO);
        matcher.match(textLines, patternLines);
    }
}
