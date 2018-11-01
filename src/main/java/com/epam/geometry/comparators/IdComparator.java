package com.epam.geometry.comparators;

import com.epam.geometry.entity.Sphere;
import java.util.Comparator;

public class IdComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere firstSphere, Sphere secondSphere) {
        long firstId = firstSphere.getId();
        long secondId = secondSphere.getId();
        return Long.compare(firstId,secondId);
    }
}
