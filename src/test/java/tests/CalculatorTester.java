package tests;

import geometry.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTester {
    private final BallCalculator CALC = new BallCalculator();
    private final Ball TEST_BALL = new Ball(5,3,2,4);

    @Test
    public void ShouldReturnThreeHFourteenWhenRadiusFive(){
        //given

        //when
        double res = CALC.getSurfaceArea(TEST_BALL);
        //then
        assertEquals(314.159,res,0.001);
    }

    @Test
    public void ShouldReturnFiveHTwentyThreeWhenRadiusFive(){
        //given

        //when
        double res = CALC.getVolume(TEST_BALL);
        //then
        assertEquals(523.598,res,0.001);
    }

    @Test
    public void ShouldReturnZeroFiftyFourWhenRadiusFiveAndPlaneOXY(){
        //give

        //when
        double res = CALC.getVolumeRatio(TEST_BALL,CoordinatePlane.OXY);
        //then
        assertEquals(0.544,res,0.001);
    }
}
