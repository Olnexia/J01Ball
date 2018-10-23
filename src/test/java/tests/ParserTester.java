package tests;

import exceptions.SphereParsingException;
import geometry.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ParserTester {
    private final static SphereParser PARSER = new SphereParser();
    private static final Logger LOGGER = Logger.getLogger(ParserTester.class.getName());

    @Test
    public void ShouldReturnExpectedSphereDataWhenInputIsExpectedStringData(){
        //given
        String expectedStringData = "4.0 3.0 5.0 -2.0";
        double[] expectedSphereData = new double[]{4.0,3.0,5.0,-2.0};
        SphereValidator mockValidator = mock(SphereValidator.class);
        when(mockValidator.validate(any(String.class))).thenReturn(true);
        try {
            //when
            double[] actualSphereData = PARSER.parseSphere(expectedStringData,mockValidator);
            //then
            assertArrayEquals(expectedSphereData, actualSphereData,0.001);
        } catch (SphereParsingException e) {
             LOGGER.warn("An exception occurred while parsing the line",e);
            fail();
        }
    }

    @Test
    public void ShouldReturnExpectedSphereDataListWhenInputIsExpectedStringDataList() {
        //given
        List <String> expectedStringDataList = new ArrayList <>();
        expectedStringDataList.add("1.0 2.0 3.0 4.0");
        expectedStringDataList.add("5.2 2.1 2.0 2.2");
        expectedStringDataList.add("4.0 6.1 4.0 4.0");
        expectedStringDataList.add("5.0 6.0 2.0 4.0");
        List <double[]> expectedSphereDataList = new ArrayList <>();
        expectedSphereDataList.add(new double[]{1.0, 2.0, 3.0, 4.0});
        expectedSphereDataList.add(new double[]{5.2, 2.1, 2.0, 2.2});
        expectedSphereDataList.add(new double[]{4.0, 6.1, 4.0, 4.0});
        expectedSphereDataList.add(new double[]{5.0, 6.0, 2.0, 4.0});

        SphereValidator mockValidator = mock(SphereValidator.class);
        when(mockValidator.validate(any(String.class))).thenReturn(true);
        //when
        List <double[]> actualSphereDataList = PARSER.parseSpheres(expectedStringDataList, mockValidator);
        //then
        assertArrayEquals(expectedSphereDataList.toArray(), actualSphereDataList.toArray());
    }
}
