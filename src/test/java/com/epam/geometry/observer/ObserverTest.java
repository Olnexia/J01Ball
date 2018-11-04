package com.epam.geometry.observer;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.SphereData;
import org.junit.Assert;
import org.junit.Test;

public class ObserverTest {
    private static final SphereObservable TEST_SPHERE_OBSERVABLE = new SphereObservable(5,new Point(4,5,2));
    private static final SphereObserver OBSERVER = SphereObserver.getObserver();
    private static final double DELTA = 0.001;

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