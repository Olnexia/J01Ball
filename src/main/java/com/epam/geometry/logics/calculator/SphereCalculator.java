package com.epam.geometry.logics.calculator;

import com.epam.geometry.entity.Sphere;

public class SphereCalculator {

    public double calculateSurfaceArea(Sphere sphere){
        double radius = sphere.getRadius();
        return 4.0 * Math.PI * radius * radius;
    }

    public double calculateVolume(Sphere sphere){
        double radius = sphere.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double calculateVolumeRatio(Sphere sphere, CoordinatePlane plane){
        if(!isTouchedByPlane(sphere)){
            return 0.0;
        }
        double distanceToPlane = 0;
        double radius = sphere.getRadius();
        switch(plane){
            case OXY:
                double zCoordinate = sphere.getZCoordinate();
                distanceToPlane = Math.abs(zCoordinate);
                break;
            case OXZ:
                double yCoordinate = sphere.getYCoordinate();
                distanceToPlane = Math.abs(yCoordinate);
                break;
            case OYZ:
                double xCoordinate = sphere.getXCoordinate();
                distanceToPlane = Math.abs(xCoordinate);
                break;
        }
        double segmentHeight=radius-distanceToPlane;
        double segmentVolume = Math.PI * segmentHeight*segmentHeight * (radius - ((1.0 / 3.0) * segmentHeight));
        if(segmentVolume==0){
            return 0.0;
        }else{
            return segmentVolume / (calculateVolume(sphere) - segmentVolume);
        }
    }

    private boolean isTouchedByPlane(Sphere sphere){
        double xCoordinate = sphere.getXCoordinate();
        double yCoordinate = sphere.getYCoordinate();
        double zCoordinate = sphere.getZCoordinate();
        double radius = sphere.getRadius();
        return ( radius>xCoordinate
                ||radius>yCoordinate
                ||radius>zCoordinate);
    }
}
