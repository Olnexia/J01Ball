package geometry;

import entity.Sphere;
import entity.CoordinatePlane;

public class SphereCalculator {

    public double getSurfaceArea(Sphere sphere){
        double radius = sphere.getRadius();
        return 4 * Math.PI * radius * radius;
    }

    public double getVolume(Sphere sphere){
        double radius = sphere.getRadius();
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    public double getVolumeRatio(Sphere sphere, CoordinatePlane plane){
        double segmentHeight =0;
        double radius = sphere.getRadius();
        switch(plane){
            case OXY:
                segmentHeight=sphere.getZCoordinate()+radius;
                break;
            case OXZ:
                segmentHeight=sphere.getYCoordinate()+radius;
                break;
            case OYZ:
                segmentHeight=sphere.getXCoordinate()+radius;
                break;
            default:
                //Add an exception
                break;
        }
        //FIXME
        double segmentVolume = Math.PI * segmentHeight*segmentHeight * (radius - ((1.0 / 3.0) * segmentHeight));
        if(segmentVolume==0){
            return 0.0;
        }else{
            return segmentVolume / (getVolume(sphere) - segmentVolume);
        }
    }

    public boolean isSphere(double[] parsedNumbers){
        return parsedNumbers[0]>0;
    }

    public boolean isTouchedByPlane(Sphere sphere){
        double xCoordinate = sphere.getXCoordinate();
        double yCoordinate = sphere.getYCoordinate();
        double zCoordinate = sphere.getZCoordinate();
        double radius = sphere.getRadius();
        return ( radius>xCoordinate||radius>yCoordinate||radius>zCoordinate);
    }
}
