package com.epam.task1.comparators;

import com.epam.task1.entity.Sphere;
import java.util.Comparator;

public class IdComparator implements Comparator<Sphere> {

    @Override
    public int compare(Sphere o1, Sphere o2) {
        long firstId = o1.getId();
        long secondId = o2.getId();
        return Long.compare(firstId,secondId);
    }
}
