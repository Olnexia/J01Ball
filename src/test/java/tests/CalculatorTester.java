package tests;

import com.epam.task1.entity.Sphere;
import com.epam.task1.CoordinatePlane;
import static org.junit.Assert.*;
import com.epam.task1.geometry.SphereCalculator;
import org.junit.Test;

public class CalculatorTester {
    private final SphereCalculator CALC = new SphereCalculator();
    private final Sphere TEST_SPHERE = new Sphere(5,3,2,1);

    @Test
    public void ShouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double actualArea = CALC.calculateSurfaceArea(TEST_SPHERE);
        //then
        assertEquals(314.159,actualArea,0.001);
    }

    @Test
    public void ShouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double actualVolume = CALC.calculateVolume(TEST_SPHERE);
        //then
        assertEquals(523.598,actualVolume,0.001);
    }

    @Test
    public void ShouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //give

        //when
        double actualRatio = CALC.calculateVolumeRatio(TEST_SPHERE, CoordinatePlane.OXY);
        //then
        assertEquals(0.544,actualRatio,0.001);
    }
}
