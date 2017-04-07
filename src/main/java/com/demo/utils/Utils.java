package com.demo.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static List<String> readLinesFromFile(String path) throws IOException {
        List<String> values = new LinkedList<String>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        for (String line; (line = br.readLine()) != null; ) {
            values.add(line);
        }
        return values;
    }
}
