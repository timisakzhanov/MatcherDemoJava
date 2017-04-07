package com.demo;


import com.demo.matcher.MatchersFactory;

public class MatcherDemo {

    public static void main(String[] args) {
        LinesSearcher searcher = new LinesSearcher("./text.txt", "./patterns.txt");
        searcher.searchForMatches();

    }
}
