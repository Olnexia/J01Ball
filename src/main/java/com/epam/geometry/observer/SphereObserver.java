package com.epam.geometry.observer;

import com.epam.geometry.entity.SphereData;
import com.epam.geometry.logics.calculator.CoordinatePlane;
import com.epam.geometry.logics.calculator.SphereCalculator;
import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer<SphereObservable> {
    private static final SphereCalculator CALCULATOR = new SphereCalculator();
    private static SphereObserver instance = null;
    private Map<Long, SphereData> sphereDataMap = new HashMap <>();

    public static SphereObserver getObserver(){
        if (instance == null) {
            instance = new SphereObserver();
        }
        return instance;
    }

    @Override
    public void update(SphereObservable sphere) {
        long id = sphere.getId();
        double newSurfaceArea = CALCULATOR.calculateSurfaceArea(sphere);
        double newVolume = CALCULATOR.calculateVolume(sphere);
        double newRatioByOXY = CALCULATOR.calculateVolumeRatio(sphere, CoordinatePlane.OXY);
        double newRatioByOXZ = CALCULATOR.calculateVolumeRatio(sphere, CoordinatePlane.OXZ);
        double newRatioByOYZ = CALCULATOR.calculateVolumeRatio(sphere, CoordinatePlane.OYZ);
        SphereData newSphereData = new SphereData(newSurfaceArea, newVolume, newRatioByOXY, newRatioByOXZ, newRatioByOYZ);
        sphereDataMap.put(id, newSphereData);
    }

    public SphereData getSphereData(SphereObservable sphere){
        long id = sphere.getId();
        return sphereDataMap.get(id);
    }
}
