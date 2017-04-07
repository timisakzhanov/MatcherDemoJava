package com.demo.io;

/**
 * Created by tim_isakjanov on 4/6/17.
 */
public class ConsoleCommunication implements UserCommunicationInterface {
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return null;
    }
}
