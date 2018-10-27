package com.epam.task1.logics;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import com.epam.task1.calculator.CoordinatePlane;
import static org.junit.Assert.*;
import com.epam.task1.calculator.SphereCalculator;
import org.junit.Test;

public class CalculatorTest {
    private static final Sphere TEST_SPHERE = new Sphere(5,new Point(3,2,1));
    private static final SphereCalculator calculator = new SphereCalculator();

    @Test
    public void shouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double actualArea = calculator.calculateSurfaceArea(TEST_SPHERE);
        //then
        assertEquals(314.159,actualArea,0.001);
    }

    @Test
    public void shouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double actualVolume = calculator.calculateVolume(TEST_SPHERE);
        //then
        assertEquals(523.598,actualVolume,0.001);
    }

    @Test
    public void shouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //give

        //when
        double actualRatio = calculator.calculateVolumeRatio(TEST_SPHERE, CoordinatePlane.OXY);
        //then
        assertEquals(0.544,actualRatio,0.001);
    }
}
