package com.epam.task1.observer;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.SphereData;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class ObserverObservableIT {
    private final static SphereObservable TEST_SPHERE_OBSERVABLE = new SphereObservable(5,new Point(4,5,2));
    private final static SphereObserver OBSERVER = SphereObserver.getObserver();
    private final static double DELTA = 0.001;

    @Test
    public void shouldRegisterNewObserver(){
        //given

        //when
        TEST_SPHERE_OBSERVABLE.registerObserver(OBSERVER);
        //then
        List<Observer> actualObserversList = TEST_SPHERE_OBSERVABLE.getObservers();
        Assert.assertEquals(1,actualObserversList.size());
        Observer actualObserver = actualObserversList.get(0);
        Assert.assertEquals(OBSERVER,actualObserver);
    }

    @Test
    public void shouldUpdateSphereDataWithNewRadius(){
        //given
        TEST_SPHERE_OBSERVABLE.registerObserver(OBSERVER);
        //when
        TEST_SPHERE_OBSERVABLE.setRadius(6);
        //then
        SphereData actualSphereData = OBSERVER.getSphereData(TEST_SPHERE_OBSERVABLE);
        Assert.assertNotEquals(null,actualSphereData);
        double actualSurfaceArea = actualSphereData.getSurfaceArea();
        Assert.assertEquals(452.389,actualSurfaceArea,DELTA);
        double actualVolume = actualSphereData.getVolume();
        Assert.assertEquals(904.779,actualVolume,DELTA);
        double actualRatioOXY = actualSphereData.getVolumeRatioByOXY();
        Assert.assertEquals(0.35,actualRatioOXY,DELTA);
        double actualRatioOXZ = actualSphereData.getVolumeRatioByOXZ();
        Assert.assertEquals(0.02,actualRatioOXZ,DELTA);
        double actualRatioOYZ = actualSphereData.getVolumeRatioByOYZ();
        Assert.assertEquals(0.08,actualRatioOYZ,DELTA);
    }

    @Test
    public void shouldRemoveObserver(){
        //given
        TEST_SPHERE_OBSERVABLE.registerObserver(OBSERVER);
        //when
        TEST_SPHERE_OBSERVABLE.removeObserver(OBSERVER);
        //then
        List<Observer> actualObserversList = TEST_SPHERE_OBSERVABLE.getObservers();
        Assert.assertTrue(actualObserversList.isEmpty());
    }
}
