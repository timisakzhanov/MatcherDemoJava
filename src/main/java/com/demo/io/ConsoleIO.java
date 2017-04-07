package com.demo.io;

import java.util.Scanner;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ConsoleIO implements IOInterface {
    private Scanner scanner;
    private static ConsoleIO instance;

    private ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    public static ConsoleIO getInstance() {
        if (instance == null) {
            instance = new ConsoleIO();
        }
        return instance;
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
