package com.epam.task1.comparators;

import com.epam.task1.entity.Sphere;
import java.util.Comparator;

public class XComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        double firstXCoordinate = o1.getXCoordinate();
        double secondXCoordinate = o2.getXCoordinate();
        return Double.compare(firstXCoordinate,secondXCoordinate);
    }
}