package com.demo.matcher;

import com.demo.io.UserCommunicationInterface;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class MatchersFactory {
    public static final int TYPE_EXACT = 1;
    public static final int TYPE_CONTAIN = 2;
    public static final int TYPE_LEVINSTEIN = 3;

    public static Matcher getMatcher(int type, UserCommunicationInterface userIO) {
        switch (type) {
            case TYPE_EXACT:
                return new ExactMatcher(userIO);
            case TYPE_CONTAIN:
                return new ContainMatcher(userIO);
            case TYPE_LEVINSTEIN:
                return new LevensteinMatcher(userIO);
            default:
                return null;
        }
    }
}
