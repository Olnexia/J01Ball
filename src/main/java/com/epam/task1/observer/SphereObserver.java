package com.epam.task1.observer;

import com.epam.task1.entity.Sphere;
import com.epam.task1.logics.calculator.CoordinatePlane;
import com.epam.task1.logics.calculator.SphereCalculator;

import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer {
    private Map<Sphere, SphereData> sphereDataMap;

    public SphereObserver(){
        sphereDataMap = new HashMap <>();
    }

    @Override
    public void update(Sphere sphere) {
        SphereData dataToUpdate = sphereDataMap.get(sphere);
        SphereCalculator calculator = new SphereCalculator();
        double newSurfaceArea = calculator.calculateSurfaceArea(sphere);
        double newVolume = calculator.calculateVolume(sphere);
        double newRatioByOXY = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OXY);
        double newRatioByOXZ = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OXZ);
        double newRatioByOYZ = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OYZ);
        dataToUpdate.setSurfaceArea(newSurfaceArea);
        dataToUpdate.setVolume(newVolume);
        dataToUpdate.setVolumeRatioByOXY(newRatioByOXY);
        dataToUpdate.setVolumeRatioByOXZ(newRatioByOXZ);
        dataToUpdate.setVolumeRatioByOYZ(newRatioByOYZ);
    }
}
