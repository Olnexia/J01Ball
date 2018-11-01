package com.epam.geometry.comparators;

import com.epam.geometry.entity.Sphere;
import java.util.Comparator;

public class XComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double firstXCoordinate = firstSphere.getXCoordinate();
        double secondXCoordinate = secondSphere.getXCoordinate();
        return Double.compare(firstXCoordinate,secondXCoordinate);
    }
}