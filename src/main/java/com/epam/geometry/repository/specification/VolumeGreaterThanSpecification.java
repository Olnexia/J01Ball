package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;
import com.epam.geometry.logics.calculator.SphereCalculator;

public class VolumeGreaterThanSpecification implements Specification<Sphere> {
    private static final SphereCalculator CALCULATOR = new SphereCalculator();
    private double volume;

    public VolumeGreaterThanSpecification(double volume){
        this.volume=volume;
    }

    @Override
    public boolean specified(Sphere sphere) {
        double currentVolume = CALCULATOR.calculateVolume(sphere);
        return Double.compare(currentVolume,volume) > 0;
    }
}
