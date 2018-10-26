package com.epam.task1.exceptions;

public class FileReadingException extends Exception {

    public FileReadingException(String message,String wrongPath,Throwable cause){
        super(message + "[file path: " + wrongPath + "]",cause);
    }
}
