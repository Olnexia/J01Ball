package com.epam.task1.exceptions;

public class SphereParsingException extends Exception {

    public SphereParsingException(String message,String wrongLine) {
        super(message + "[line: " + wrongLine+"]");
    }
}
