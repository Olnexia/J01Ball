package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;

public class RemovedFromOriginSpecification implements Specification<Sphere> {
    private double start;
    private double end;

    public RemovedFromOriginSpecification(double start, double end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double xCoordinate = sphere.getXCoordinate();
        double yCoordinate = sphere.getYCoordinate();
        double zCoordinate = sphere.getZCoordinate();
        double distance = Math.sqrt(xCoordinate*xCoordinate+yCoordinate*yCoordinate+zCoordinate*zCoordinate);
        return ((distance>=start) && (distance<=end));
    }
}
