package com.epam.geometry.comparators;

import com.epam.geometry.entity.Sphere;
import java.util.Comparator;

public class ZComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double firstZCoordinate = firstSphere.getZCoordinate();
        double secondZCoordinate = secondSphere.getZCoordinate();
        return Double.compare(firstZCoordinate,secondZCoordinate);
    }
}
