package com.epam.geometry.logics.reader;

import  static org.junit.Assert.*;
import com.epam.geometry.exceptions.FileReadingException;
import com.epam.geometry.logics.reader.FileReader;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private static final String TEST_PATH = "src/test/resources/testInput.txt";
    private static final String NONEXISTENT_PATH = "src/test/resources/nonexistent.txt";
    private static final String FIRST_TEST_STRING = "1.0 2.0 3.0 4.0" ;
    private static final String SECOND_TEST_STRING = "-1.0 2.5 4.1 5.2";
    private static final String THIRD_TEST_STRING = "5.2 2.1 2.0 2.z2";
    private static final String FOURTH_TEST_STRING = "4.0 6.1 4.0 4.0";
    private static final String FIFTH_TEST_STRING = "5.0 6.0 2.0 4.0";

    private static final FileReader reader = new FileReader();

    @Test
    public void shouldReturnTestExpectedArrayWhenFileIsLocatedAtTestPath() throws FileReadingException {
        //given

        //when
        List <String> actualStringList = reader.readLines(TEST_PATH);
        //then
        assertEquals(5, actualStringList.size());
        String firstActualString = actualStringList.get(0);
        Assert.assertEquals(FIRST_TEST_STRING,firstActualString);
        String secondActualString = actualStringList.get(1);
        Assert.assertEquals(SECOND_TEST_STRING,secondActualString);
        String thirdActualString = actualStringList.get(2);
        Assert.assertEquals(THIRD_TEST_STRING,thirdActualString);
        String fourthActualString = actualStringList.get(3);
        Assert.assertEquals(FOURTH_TEST_STRING,fourthActualString);
        String fifthActualString = actualStringList.get(4);
        Assert.assertEquals(FIFTH_TEST_STRING,fifthActualString);
    }

    @Test(expected = FileReadingException.class)
    public void shouldThrowInputFileNotFoundWhenFileDoesNotExist() throws FileReadingException{
        //given
        //when
        reader.readLines(NONEXISTENT_PATH);
        //then
    }
}
