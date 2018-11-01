package com.epam.geometry.comparators;

import com.epam.geometry.entity.Sphere;
import java.util.Comparator;

public class RadiusComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        double firstRadius = firstSphere.getRadius();
        double secondRadius = secondSphere.getRadius();
        return Double.compare(firstRadius,secondRadius);
    }
}
