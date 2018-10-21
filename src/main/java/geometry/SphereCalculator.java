package geometry;

import entity.Sphere;
import entity.CoordinatePlane;

public class SphereCalculator {

    public double calculateSurfaceArea(Sphere sphere){
        double radius = sphere.getRadius();
        return 4 * Math.PI * radius * radius;
    }

    public double calculateVolume(Sphere sphere){
        double radius = sphere.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double calculateVolumeRatio(Sphere sphere, CoordinatePlane plane){
        if(!isTouchedByPlane(sphere)){
            return 0.0;
        }
        double distanceToPlane;
        double segmentHeight =0;
        double radius = sphere.getRadius();
        switch(plane){
            case OXY:
                distanceToPlane = Math.abs(sphere.getZCoordinate());
                segmentHeight=radius-distanceToPlane;
                break;
            case OXZ:
                distanceToPlane = Math.abs(sphere.getYCoordinate());
                segmentHeight=radius-distanceToPlane;
                break;
            case OYZ:
                distanceToPlane = Math.abs(sphere.getXCoordinate());
                segmentHeight=radius-distanceToPlane;
                break;
            default:
                //Add an exception
                break;
        }
        double segmentVolume = Math.PI * segmentHeight*segmentHeight * (radius - ((1.0 / 3.0) * segmentHeight));
        if(segmentVolume==0){
            return 0.0;
        }else{
            return segmentVolume / (calculateVolume(sphere) - segmentVolume);
        }
    }

    public boolean isTouchedByPlane(Sphere sphere){
        double xCoordinate = sphere.getXCoordinate();
        double yCoordinate = sphere.getYCoordinate();
        double zCoordinate = sphere.getZCoordinate();
        double radius = sphere.getRadius();
        return ( radius>xCoordinate||radius>yCoordinate||radius>zCoordinate);
    }
}
