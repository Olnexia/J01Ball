package com.epam.geometry.comparators;

import com.epam.geometry.entity.Sphere;
import java.util.Comparator;

public class YComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double firstYCoordinate = firstSphere.getYCoordinate();
        double secondYCoordinate = secondSphere.getYCoordinate();
        return Double.compare(firstYCoordinate,secondYCoordinate);
    }
}
