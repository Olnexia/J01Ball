package com.epam.task1.repository.specifications;

import com.epam.task1.entity.Sphere;
import com.epam.task1.repository.Specification;

public class RemovedFromOriginSpecification  implements Specification<Sphere> {
    private double start;
    private double end;

    public RemovedFromOriginSpecification(double start, double end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean specified(Sphere object) {
        double xCoordinate = object.getXCoordinate();
        double yCoordinate = object.getYCoordinate();
        double zCoordinate = object.getZCoordinate();
        double distance = Math.sqrt(xCoordinate*xCoordinate+yCoordinate*yCoordinate+zCoordinate*zCoordinate);
        return ((distance>=start) && (distance<=end));
    }
}
