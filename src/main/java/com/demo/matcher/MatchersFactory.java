package com.demo.matcher;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class MatchersFactory {

    public static Matcher getMatcher(String type) {
        if (type.equals("exact")) {
            return ExactMatcher.getInstance();
        }
        if (type.equals("contain")) {
            return ContainMatcher.getInstance();
        }
        if (type.equals("levenstein")) {
            return LevensteinMatcher.getInstance();
        }
        return null;
    }
}
