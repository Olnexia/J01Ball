package com.epam.task1.repository;

import com.epam.task1.entity.Sphere;
import com.epam.task1.logics.calculator.SphereCalculator;

public class VolumeGreaterThanSpecification implements Specification<Sphere> {
    private double volume;
    private SphereCalculator calculator = new SphereCalculator();

    public VolumeGreaterThanSpecification(double volume){
        this.volume=volume;
    }

    @Override
    public boolean specified(Sphere object) {
        double currentVolume = calculator.calculateVolume(object);
        return Double.compare(currentVolume,volume) > 0;
    }
}
