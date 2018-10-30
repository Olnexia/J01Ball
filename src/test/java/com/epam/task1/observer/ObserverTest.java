package com.epam.task1.observer;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.SphereData;
import org.junit.Assert;
import org.junit.Test;

public class ObserverTest {
    private final static SphereObservable TEST_SPHERE_OBSERVABLE = new SphereObservable(5,new Point(4,5,2));
    private final static SphereObserver OBSERVER = SphereObserver.getObserver();
    private final static double DELTA = 0.001;

    @Test
    public void shouldAddCorrectSphereDataToObserver(){
        //given

        //when
        OBSERVER.update(TEST_SPHERE_OBSERVABLE);
        //then
        SphereData actualSphereData = OBSERVER.getSphereData(TEST_SPHERE_OBSERVABLE);
        Assert.assertNotEquals(null,actualSphereData);
        double actualSurfaceArea = actualSphereData.getSurfaceArea();
        Assert.assertEquals(314.159,actualSurfaceArea,DELTA);
        double actualVolume = actualSphereData.getVolume();
        Assert.assertEquals(523.598,actualVolume,DELTA);
        double actualRatioOXY = actualSphereData.getVolumeRatioByOXY();
        Assert.assertEquals(0.276,actualRatioOXY,DELTA);
        double actualRatioOXZ = actualSphereData.getVolumeRatioByOXZ();
        Assert.assertEquals(0.0,actualRatioOXZ,DELTA);
        double actualRatioOYZ = actualSphereData.getVolumeRatioByOYZ();
        Assert.assertEquals(0.028,actualRatioOYZ,DELTA);
    }
}