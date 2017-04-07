package com.demo.matcher;

import java.util.List;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public interface Matcher {
    void match(List<String> lines, List<String> patterns);
}
