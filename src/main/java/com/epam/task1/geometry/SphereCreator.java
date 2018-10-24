package com.epam.task1.geometry;

import com.epam.task1.entity.Sphere;
import com.epam.task1.exceptions.SphereCreatingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class SphereCreator {
    private static Logger logger = LogManager.getLogger(SphereCreator.class);

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
