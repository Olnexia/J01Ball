package tests;

import  static org.junit.Assert.*;
import entity.Sphere;
import geometry.SphereParser;
import geometry.SphereReader;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTester {

    private final static String[] TEST_STR_ARRAY = new String[]{"1.0 2.0 3.0 4.0","4.0 6.1 4.0 4.0","5.0 6.0 2.0 4.0"};
    private final static Sphere[] TEST_SPHERE_ARRAY = new Sphere[]{new Sphere(1.0,2.0,3.0,4.0),
                                                     new Sphere(4.0,6.1,4.0,4.0),
                                                     new Sphere(5.0,6.0,2.0,4.0)};
    private final static SphereReader READER = new SphereReader();
    private final static SphereParser PARSER = new SphereParser();

    @Test
    public void ShouldReturnTestArrayWhenFileIsTestInput(){
        //given
        //when
        List<String> res = READER.readLines("src/test/resources/testInput.txt");
        //then
        assertArrayEquals(TEST_STR_ARRAY,res.toArray());
    }

    @Test
    public void ShouldReturnNullWhenFileHasNotValidLines(){
        //given

        //when
        List<String> res = READER.readLines("src/test/resources/wrTestInput.txt");
        //then
        assertNull(res);
    }

    @Test
    public void ShouldReturnTestBallArrayWhenParsingFromTestStrArray(){
        //given
        //when
        //then

    }
}
