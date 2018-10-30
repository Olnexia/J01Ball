package com.epam.task1.observer;

import com.epam.task1.entity.SphereData;
import com.epam.task1.logics.calculator.CoordinatePlane;
import com.epam.task1.logics.calculator.SphereCalculator;
import java.util.HashMap;
import java.util.Map;

public class SphereObserver implements Observer<SphereObservable> {
    private static SphereObserver instance = null;
    private SphereCalculator calculator = new SphereCalculator();
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
        double newSurfaceArea = calculator.calculateSurfaceArea(sphere);
        double newVolume = calculator.calculateVolume(sphere);
        double newRatioByOXY = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OXY);
        double newRatioByOXZ = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OXZ);
        double newRatioByOYZ = calculator.calculateVolumeRatio(sphere, CoordinatePlane.OYZ);
        if(sphereDataMap.containsKey(id)){
            SphereData dataToUpdate = sphereDataMap.get(id);
            dataToUpdate.setSurfaceArea(newSurfaceArea);
            dataToUpdate.setVolume(newVolume);
            dataToUpdate.setVolumeRatioByOXY(newRatioByOXY);
            dataToUpdate.setVolumeRatioByOXZ(newRatioByOXZ);
            dataToUpdate.setVolumeRatioByOYZ(newRatioByOYZ);
        } else {
            SphereData newSphereData = new SphereData(newSurfaceArea, newVolume, newRatioByOXY, newRatioByOXZ, newRatioByOYZ);
            sphereDataMap.put(id, newSphereData);
        }
    }

    public SphereData getSphereData(SphereObservable sphere){
        long id = sphere.getId();
        return sphereDataMap.get(id);
    }
}
