package com.epam.geometry.exceptions;

public class SphereParsingException extends Exception {

    public SphereParsingException(String message,String wrongLine) {
        super(message + "[line: " + wrongLine+"]");
    }
}
