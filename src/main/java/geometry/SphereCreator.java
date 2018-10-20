package geometry;

import entity.Sphere;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator {
    public List<Sphere> createBalls(List<double[]> sphereDataList){
        List<Sphere> sphereList = new ArrayList<>();
        for(double[] sphereData : sphereDataList){
            if(sphereData[0]>0) {
                double radius = sphereData[0];
                double xCoordinate = sphereData[1];
                double yCoordinate = sphereData[2];
                double zCoordinate = sphereData[3];
                sphereList.add(new Sphere(radius, xCoordinate, yCoordinate, zCoordinate));
            } else{

            }
        }
        return sphereList;
    }
}
