package tests;

import  static org.junit.Assert.*;
import entity.Sphere;
import exceptions.InputFileNotFoundException;
import geometry.SphereParser;
import geometry.SphereReader;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTester {
    private final static String TEST_PATH = "src/test/resources/testInput.txt";
    private final static String NONEXISTENT_PATH = "src/test/resources/nonexistent.txt";
    private final static String[] TEST_STR_ARRAY = new String[]{"1.0 2.0 3.0 4.0",
                                                                "-1.0 2.5 4.1 5.2",
                                                                "5.2 2.1 2.0 2.z2",
                                                                "4.0 6.1 4.0 4.0",
                                                                "5.0 6.0 2.0 4.0"};
    private final static Sphere[] TEST_SPHERE_ARRAY = new Sphere[]{new Sphere(1.0,2.0,3.0,4.0),
                                                     new Sphere(4.0,6.1,4.0,4.0),
                                                     new Sphere(5.0,6.0,2.0,4.0)};
    private final static SphereReader READER = new SphereReader();
    private final static SphereParser PARSER = new SphereParser();

    @Test
    public void ShouldReturnTestStrArrayWhenFileIsTestInput(){
        //given
        try {
            //when
            List <String> res = READER.readLines(TEST_PATH);
            //then
            assertArrayEquals(TEST_STR_ARRAY, res.toArray());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void ShouldThrowInputFileNotFoundWhenFileDoesNotExist(){
        //given
        try {
            //when
            List <String> res = READER.readLines(NONEXISTENT_PATH);
            fail();
        } catch (Exception expected){
            //then
            assertEquals("File not found",expected.getMessage());
        }
    }
}
