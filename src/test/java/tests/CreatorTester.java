package tests;

import entity.Sphere;
import exceptions.SphereCreatingException;
import geometry.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class CreatorTester {
    private final static SphereCreator CREATOR = new SphereCreator();
    private static final Logger LOGGER = Logger.getLogger(ParserTester.class.getName());


    @Test
    public void ShouldReturnExpectedSphereWhenInputIsExpectedSphereData() {
        //given
        double[] expectedSphereData = new double[]{4.0, 3.0, 5.0, -2.0};
        Sphere expectedSphere = new Sphere(4.0, 3.0, 5.0, -2.0);
        try {
            //when
            Sphere actualSphere = CREATOR.createSphere(expectedSphereData);
            //then
            assertEquals(expectedSphere, actualSphere);
        } catch (SphereCreatingException e) {
            LOGGER.warn("An exception occurred while creating the sphere",e);
            fail();
        }
    }

    @Test
    public void ShouldThrowSphereParsingExceptionWhenNegativeRadius(){
        //given
        double[] expectedSphereData = new double[]{-4.0, 3.0, 5.0, -2.0};
        try {
            //when
            CREATOR.createSphere(expectedSphereData);
            fail();
        } catch (Exception expected){
            //then
            assertEquals("Sphere can't have negative radius",expected.getMessage());
            LOGGER.warn("An exception occurred while creating the sphere",expected);
        }
    }

    @Test
    public void ShouldReturnExpectedSphereListWhenInputIsExpectedSphereDataList() {
        //given
        List <double[]> expectedSphereDataList = new ArrayList <>();
        expectedSphereDataList.add(new double[]{1.0, 2.0, 3.0, 4.0});
        expectedSphereDataList.add(new double[]{5.2, 2.1, 2.0, 2.2});
        expectedSphereDataList.add(new double[]{4.0, 6.1, 4.0, 4.0});
        expectedSphereDataList.add(new double[]{5.0, 6.0, 2.0, 4.0});
        List <Sphere> expectedSphereList = new ArrayList <>();
        expectedSphereList.add(new Sphere(1.0, 2.0, 3.0, 4.0));
        expectedSphereList.add(new Sphere(5.2, 2.1, 2.0, 2.2));
        expectedSphereList.add(new Sphere(4.0, 6.1, 4.0, 4.0));
        expectedSphereList.add(new Sphere(5.0, 6.0, 2.0, 4.0));

        //when
        List<Sphere> actualSphereList = CREATOR.createSpheres(expectedSphereDataList);
        //then
        assertArrayEquals(expectedSphereList.toArray(), actualSphereList.toArray());
    }
}
