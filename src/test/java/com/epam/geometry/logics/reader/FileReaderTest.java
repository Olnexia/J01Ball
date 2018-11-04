package com.epam.geometry.logics.reader;

import com.epam.geometry.exceptions.FileReadingException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FileReaderTest {
    private static final String TEST_PATH = "src/test/resources/testInput.txt";
    private static final String NONEXISTENT_PATH = "src/test/resources/nonexistent.txt";
    private static final FileReader reader = new FileReader();

    @Test
    public void shouldReturnTestExpectedArrayWhenFileIsLocatedAtTestPath() throws FileReadingException {
        //given

        //when
        List <String> actualStringList = reader.readLines(TEST_PATH);
        //then
        Assert.assertEquals(5, actualStringList.size());
        String firstActualString = actualStringList.get(0);
        Assert.assertEquals("1.0 2.0 3.0 4.0",firstActualString);
        String secondActualString = actualStringList.get(1);
        Assert.assertEquals("-1.0 2.5 4.1 5.2",secondActualString);
        String thirdActualString = actualStringList.get(2);
        Assert.assertEquals("5.2 2.1 2.0 2.z2",thirdActualString);
        String fourthActualString = actualStringList.get(3);
        Assert.assertEquals("4.0 6.1 4.0 4.0",fourthActualString);
        String fifthActualString = actualStringList.get(4);
        Assert.assertEquals("5.0 6.0 2.0 4.0",fifthActualString);
    }

    @Test(expected = FileReadingException.class)
    public void shouldThrowInputFileNotFoundWhenFileDoesNotExist() throws FileReadingException{
        //given
        //when
        reader.readLines(NONEXISTENT_PATH);
        //then
    }
}
