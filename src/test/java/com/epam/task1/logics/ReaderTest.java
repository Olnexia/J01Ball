package com.epam.task1.logics;

import  static org.junit.Assert.*;
import com.epam.task1.exceptions.FileReadingException;
import com.epam.task1.logics.reader.FileReader;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ReaderTest {
    private static final String TEST_PATH = "src/test/resources/testInput.txt";
    private static final String NONEXISTENT_PATH = "src/test/resources/nonexistent.txt";
    private static final FileReader reader = new FileReader();

    @Test
    public void shouldReturnTestExpectedArrayWhenFileIsLocatedAtTestPath() throws FileReadingException {
        //given
        List<String> expected = new ArrayList <>();
        expected.add("1.0 2.0 3.0 4.0");
        expected.add("-1.0 2.5 4.1 5.2");
        expected.add("5.2 2.1 2.0 2.z2");
        expected.add("4.0 6.1 4.0 4.0");
        expected.add("5.0 6.0 2.0 4.0");
        //when
        List <String> actual = reader.readLines(TEST_PATH);
        //then
        assertEquals(expected, actual);
    }

    @Test(expected = FileReadingException.class)
    public void shouldThrowInputFileNotFoundWhenFileDoesNotExist() throws FileReadingException{
        //given
        //when
        reader.readLines(NONEXISTENT_PATH);
        //then
    }
}
