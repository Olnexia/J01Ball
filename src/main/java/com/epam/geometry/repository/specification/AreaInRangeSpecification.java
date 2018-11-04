package com.epam.geometry.repository.specification;

import com.epam.geometry.logics.calculator.SphereCalculator;
import com.epam.geometry.entity.Sphere;

public class AreaInRangeSpecification implements Specification<Sphere> {
    private static final SphereCalculator CALCULATOR = new SphereCalculator();
    private int start;
    private int end;

    public AreaInRangeSpecification(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double surfaceArea = CALCULATOR.calculateSurfaceArea(sphere);
        return ((surfaceArea>=start) && (surfaceArea<=end));
    }
}
