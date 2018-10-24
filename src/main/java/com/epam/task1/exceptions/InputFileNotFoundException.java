package com.epam.task1.exceptions;

//TODO: don't use  wrongPath but use conc of the message and the path

public class InputFileNotFoundException extends Exception {
    private String wrongPath;
    public String getWrongPath() {
        return wrongPath;
    }
    public InputFileNotFoundException(String message,String wrongPath){
        super(message);
        this.wrongPath=wrongPath;
    }
}
