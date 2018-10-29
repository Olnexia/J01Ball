package com.epam.task1.comparators;

import com.epam.task1.entity.Sphere;
import java.util.Comparator;

public class RadiusComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        double firstRadius = o1.getRadius();
        double secondRadius = o2.getRadius();
        return Double.compare(firstRadius,secondRadius);
    }
}
