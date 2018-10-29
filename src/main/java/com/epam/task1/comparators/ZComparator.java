package com.epam.task1.comparators;

import com.epam.task1.entity.Sphere;
import java.util.Comparator;

public class ZComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        double firstZCoordinate = o1.getZCoordinate();
        double secondZCoordinate = o2.getZCoordinate();
        return Double.compare(firstZCoordinate,secondZCoordinate);
    }
}
