package tests;

import  static org.junit.Assert.*;
import geometry.SphereReader;
import org.junit.Test;

import java.util.List;

public class ReaderTester {
    private final static String TEST_PATH = "src/test/resources/testInput.txt";
    private final static String NONEXISTENT_PATH = "src/test/resources/nonexistent.txt";
    private final static SphereReader READER = new SphereReader();

    @Test
    public void ShouldReturnTestExpectedArrayWhenFileIsTestInput(){
        String[] testExpectedArray = new String[]{  "1.0 2.0 3.0 4.0",
                                                    "-1.0 2.5 4.1 5.2",
                                                    "5.2 2.1 2.0 2.z2",
                                                    "4.0 6.1 4.0 4.0",
                                                    "5.0 6.0 2.0 4.0"};
        try {
            //when
            List <String> actual = READER.readLines(TEST_PATH);
            //then
            assertArrayEquals(testExpectedArray, actual.toArray());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void ShouldThrowInputFileNotFoundWhenFileDoesNotExist(){
        //given
        try {
            //when
            READER.readLines(NONEXISTENT_PATH);
            fail();
        } catch (Exception expected){
            //then
            assertEquals("File not found",expected.getMessage());
        }
    }
}
