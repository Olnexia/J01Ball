package com.epam.geometry.logics.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.exceptions.SphereCreatingException;
import com.epam.geometry.logics.creator.SphereCreator;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CreatorTest {
    private static final Sphere FIRST_TEST_SPHERE = new Sphere(1.0,new Point( 2.0, 3.0, -4.0));
    private static final Sphere SECOND_TEST_SPHERE = new Sphere(5.2,new Point( 2.1, 2.0, 2.2));
    private static final Sphere THIRD_TEST_SPHERE = new Sphere(4.0,new Point( 6.1, 4.0, 4.0));
    private static final Sphere FOURTH_TEST_SPHERE = new Sphere(5.0,new Point( 6.0, 2.0, 4.0));
    private static final SphereCreator creator = new SphereCreator();

    @Test
    public void shouldReturnExpectedSphereWhenInputIsExpectedSphereData() throws SphereCreatingException {
        //given
        double[] expectedSphereData = new double[]{1.0, 2.0, 3.0, -4.0};
        //when
        Sphere actualSphere = creator.createSphere(expectedSphereData);
        //then
        assertEquals(FIRST_TEST_SPHERE, actualSphere);
    }

    @Test(expected = SphereCreatingException.class)
    public void shouldThrowSphereCreatingExceptionWhenNegativeRadius() throws SphereCreatingException{
        //given
        double[] expectedSphereData = new double[]{-4.0, 3.0, 5.0, -2.0};
        //when
        creator.createSphere(expectedSphereData);
        //then
    }

    @Test
    public void ShouldReturnExpectedSphereListWhenInputIsExpectedSphereDataList() {
        //given
        List <double[]> expectedSphereDataList = new ArrayList <>();
        expectedSphereDataList.add(new double[]{1.0, 2.0, 3.0, -4.0});
        expectedSphereDataList.add(new double[]{5.2, 2.1, 2.0, 2.2});
        expectedSphereDataList.add(new double[]{4.0, 6.1, 4.0, 4.0});
        expectedSphereDataList.add(new double[]{5.0, 6.0, 2.0, 4.0});
        //when
        List<Sphere> actualSphereList = creator.createSpheres(expectedSphereDataList);
        //then
        assertEquals(4,actualSphereList.size());
        Sphere firstActualSphere = actualSphereList.get(0);
        assertEquals(FIRST_TEST_SPHERE,firstActualSphere);
        Sphere secondActualSphere = actualSphereList.get(1);
        assertEquals(SECOND_TEST_SPHERE,secondActualSphere);
        Sphere thirdActualSphere = actualSphereList.get(2);
        assertEquals(THIRD_TEST_SPHERE,thirdActualSphere);
        Sphere fourthActualSphere = actualSphereList.get(3);
        assertEquals(FOURTH_TEST_SPHERE,fourthActualSphere);
        }
}
