package com.epam.task1.exceptions;

public class SphereCreatingException extends Exception {

    public SphereCreatingException(String message,double[] wrongSphereData) {
        super(message + "Wrong sphere data: ["+
                        wrongSphereData[0]+";"+
                        wrongSphereData[1]+";"+
                        wrongSphereData[2]+";"+
                        wrongSphereData[3]+"]");
    }
}
