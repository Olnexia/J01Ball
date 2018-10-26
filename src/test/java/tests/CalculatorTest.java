package tests;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import com.epam.task1.logics.calculator.CoordinatePlane;
import static org.junit.Assert.*;
import com.epam.task1.logics.calculator.SphereCalculator;
import org.junit.Test;

public class CalculatorTest {
    private final Sphere TEST_SPHERE = new Sphere(5,new Point(3,2,1));
    private final SphereCalculator calculator = new SphereCalculator();

    @Test
    public void ShouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double actualArea = calculator.calculateSurfaceArea(TEST_SPHERE);
        //then
        assertEquals(314.159,actualArea,0.001);
    }

    @Test
    public void ShouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double actualVolume = calculator.calculateVolume(TEST_SPHERE);
        //then
        assertEquals(523.598,actualVolume,0.001);
    }

    @Test
    public void ShouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //give

        //when
        double actualRatio = calculator.calculateVolumeRatio(TEST_SPHERE, CoordinatePlane.OXY);
        //then
        assertEquals(0.544,actualRatio,0.001);
    }
}
