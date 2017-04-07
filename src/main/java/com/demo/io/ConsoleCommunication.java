package com.demo.io;

import java.util.Scanner;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ConsoleCommunication implements UserCommunicationInterface {
    private Scanner scanner;

    public ConsoleCommunication() {
        scanner = new Scanner(System.in);
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
