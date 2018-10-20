package tests;

import entity.Sphere;
import entity.CoordinatePlane;

import static org.junit.Assert.*;

import geometry.SphereCalculator;
import org.junit.Test;

public class CalculatorTester {
    private final SphereCalculator CALC = new SphereCalculator();
    private final Sphere TEST_SPHERE = new Sphere(5,3,2,4);

    @Test
    public void ShouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double res = CALC.calculateSurfaceArea(TEST_SPHERE);
        //then
        assertEquals(314.159,res,0.001);
    }

    @Test
    public void ShouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double res = CALC.calculateVolume(TEST_SPHERE);
        //then
        assertEquals(523.598,res,0.001);
    }

    @Test
    public void ShouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //give

        //when
        double res = CALC.calculateVolumeRatio(TEST_SPHERE, CoordinatePlane.OXY);
        //then
        assertEquals(0.544,res,0.001);
    }
}
