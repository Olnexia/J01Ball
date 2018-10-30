package com.epam.task1.repository.specifications;

import com.epam.task1.logics.calculator.SphereCalculator;
import com.epam.task1.entity.Sphere;
import com.epam.task1.repository.Specification;

public class AreaInRangeSpecification implements Specification<Sphere> {
    private int start;
    private int end;
    private SphereCalculator calculator = new SphereCalculator();

    public AreaInRangeSpecification(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean specified(Sphere object) {
        double surfaceArea = calculator.calculateSurfaceArea(object);
        return ((surfaceArea>=start) && (surfaceArea<=end));
    }
}
