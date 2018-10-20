package tests;

import  static org.junit.Assert.*;
import geometry.Ball;
import geometry.BallParser;
import geometry.BallReader;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class ReaderTester {

    private final static String[] TEST_STR_ARRAY = new String[]{"1.0 2.0 3.0 4.0","4.0 6.1 4.0 4.0","5.0 6.0 2.0 4.0"};
    private final static Ball[] TEST_BALL_ARRAY = new Ball[]{new Ball(1.0,2.0,3.0,4.0),
                                                     new Ball (4.0,6.1,4.0,4.0),
                                                     new Ball (5.0,6.0,2.0,4.0)};
    private final static BallReader READER = new BallReader();
    private final static BallParser PARSER = new BallParser();

    @Test
    public void ShouldReturnTestArrayWhenFileIsTestInput(){
        //given

        //when
        ArrayList<String> res = READER.readBalls("src/test/resources/testInput.txt");
        //then
        assertArrayEquals(TEST_STR_ARRAY,res.toArray());
    }

    @Test
    public void ShouldReturnNullWhenFileHasNotValidLines(){
        //given

        //when
        ArrayList<String> res = READER.readBalls("src/test/resources/wrTestInput.txt");
        //then
        assertNull(res);
    }

    @Test
    public void ShouldReturnTestBallArrayWhenParsingFromTestStrArray(){
        //given
        ArrayList<String> input = new ArrayList<String>(Arrays.asList(TEST_STR_ARRAY));
        //when
        ArrayList<Ball> res = PARSER.parseBalls(input);
        //then
        assertArrayEquals(TEST_BALL_ARRAY,res.toArray());
    }
}
