package geometry;

import entity.Sphere;
import exceptions.SphereCreatingException;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator {
    public List<Sphere> createSpheres(List<double[]> sphereDataList){
        List<Sphere> sphereList = new ArrayList<>();
        for(double[] sphereData : sphereDataList) {
            try {
                sphereList.add(createSphere(sphereData));
            } catch (SphereCreatingException e) {

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
        return new Sphere(radius,xCoordinate,yCoordinate,zCoordinate);
    }
}
