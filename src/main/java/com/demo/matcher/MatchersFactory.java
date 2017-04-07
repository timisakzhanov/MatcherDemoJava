package com.demo.matcher;

import com.demo.io.IOInterface;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class MatchersFactory {
    public static final int EXACT = 1;
    public static final int TYPE_CONTAIN = 2;
    public static final int TYPE_LEVINSTEIN = 3;

    public static Matcher getMatcher(String type, IOInterface userIO) {
        if (type.equals("exact")) {
            return ExactMatcher.getInstance(userIO);
        }
        if (type.equals("contain")) {
            return ContainMatcher.getInstance(userIO);
        }
        if (type.equals("levenstein")) {
            return LevensteinMatcher.getInstance(userIO);
        }
        return null;
    }
}
