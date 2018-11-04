package com.epam.geometry.logics.calculator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    private static final Sphere TEST_SPHERE = new Sphere(5,new Point(3,2,1));
    private static final double DELTA = 0.001;
    private static final SphereCalculator calculator = new SphereCalculator();

    @Test
    public void shouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double actualArea = calculator.calculateSurfaceArea(TEST_SPHERE);
        //then
        Assert.assertEquals(314.159,actualArea,DELTA);
    }

    @Test
    public void shouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double actualVolume = calculator.calculateVolume(TEST_SPHERE);
        //then
        Assert.assertEquals(523.598,actualVolume,DELTA);
    }

    @Test
    public void shouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //given

        //when
        double actualRatio = calculator.calculateVolumeRatio(TEST_SPHERE, CoordinatePlane.OXY);
        //then
        Assert.assertEquals(0.544,actualRatio,DELTA);
    }
}
