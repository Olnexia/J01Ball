package com.epam.geometry.logics.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.exceptions.SphereCreatingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereCreator {
    private static final int RADIUS_INDEX = 0;
    private static final int X_INDEX = 1;
    private static final int Y_INDEX = 2;
    private static final int Z_INDEX = 3;
    private static final Logger logger = LogManager.getLogger(SphereCreator.class);

    public List<Sphere> createSpheres(List<double[]> sphereDataList){
        List<Sphere> sphereList = new ArrayList<>();
        for(double[] sphereData : sphereDataList) {
            try {
                sphereList.add(createSphere(sphereData));
            } catch (SphereCreatingException e) {
                logger.warn("An exception occurred while creating the sphere" + e.getMessage());
            }
        }
        return sphereList;
    }

    public Sphere createSphere(double[] sphereData)throws SphereCreatingException{
        if(sphereData[RADIUS_INDEX]<0){
            throw new SphereCreatingException("Sphere can't have negative radius",sphereData);
        }
        double radius = sphereData[RADIUS_INDEX];
        double xCoordinate = sphereData[X_INDEX];
        double yCoordinate = sphereData[Y_INDEX];
        double zCoordinate = sphereData[Z_INDEX];
        Point center = new Point(xCoordinate,yCoordinate,zCoordinate);
        Sphere sphere = new Sphere(radius,center);
        logger.info("new sphere was created " +sphere);
        return sphere;
    }
}
