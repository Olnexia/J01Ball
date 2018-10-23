package geometry;

import entity.Sphere;
import exceptions.SphereCreatingException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator {
    private static Logger logger = Logger.getLogger(SphereParser.class.getName());

    public List<Sphere> createSpheres(List<double[]> sphereDataList){
        List<Sphere> sphereList = new ArrayList<>();
        for(double[] sphereData : sphereDataList) {
            try {
                sphereList.add(createSphere(sphereData));
            } catch (SphereCreatingException e) {
                logger.warn("An exception occurred while creating the sphere",e);
            }
        }
        return sphereList;
    }

    public Sphere createSphere(double[] sphereData)throws SphereCreatingException{
        if(sphereData[0]<0){
            throw new SphereCreatingException("Sphere can't have negative radius",sphereData);
        }
        double radius = sphereData[0];
        double xCoordinate = sphereData[1];
        double yCoordinate = sphereData[2];
        double zCoordinate = sphereData[3];
        Sphere sphere = new Sphere(radius,xCoordinate,yCoordinate,zCoordinate);
        logger.info("new sphere was created " +sphere);
        return sphere;
    }
}
