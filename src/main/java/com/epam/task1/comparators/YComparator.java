package com.epam.task1.comparators;

import com.epam.task1.entity.Sphere;
import java.util.Comparator;

public class YComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        double firstYCoordinate = o1.getYCoordinate();
        double secondYCoordinate = o2.getYCoordinate();
        return Double.compare(firstYCoordinate,secondYCoordinate);
    }
}
