package com.epam.geometry.comparators;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
@RunWith(DataProviderRunner.class)
public class ComparatorsTest {
    private static final Sphere FIRST_TEST_SPHERE = new Sphere(5,new Point(3,2,9));
    private static final Sphere SECOND_TEST_SPHERE = new Sphere(2,new Point(2,1,2));
    private static final Sphere THIRD_TEST_SPHERE = new Sphere(5,new Point(3,2,9));
    private static final Sphere FOURTH_TEST_SPHERE = new Sphere(9,new Point(5,7,10));
    private static final IdComparator idComparator = new IdComparator();
    private static final RadiusComparator radiusComparator = new RadiusComparator();
    private static final XComparator xComparator = new XComparator();
    private static final YComparator yComparator = new YComparator();
    private static final ZComparator zComparator = new ZComparator();
    static{
        FIRST_TEST_SPHERE.setId(55L);
        SECOND_TEST_SPHERE.setId(22L);
        THIRD_TEST_SPHERE.setId(55L);
        FOURTH_TEST_SPHERE.setId(322L);
    }

    @DataProvider
    public static Object[][] sphereComparator() {
        return new Object[][] {
                { FIRST_TEST_SPHERE,SECOND_TEST_SPHERE,1 },
                { FIRST_TEST_SPHERE,THIRD_TEST_SPHERE,0 },
                { FIRST_TEST_SPHERE,FOURTH_TEST_SPHERE,-1},
        };
    }

    @Test
    @UseDataProvider("sphereComparator")
    public void shouldCompareById(Sphere firstSphere,Sphere secondSphere, int expected) {
        //given

        //when
        int result = idComparator.compare(firstSphere,secondSphere);
        //then
        assertEquals(expected, result);
    }

    @Test
    @UseDataProvider("sphereComparator")
    public void shouldCompareByRadius(Sphere firstSphere,Sphere secondSphere, int expected) {
        //given

        //when
        int result = radiusComparator.compare(firstSphere,secondSphere);
        //then
        assertEquals(expected, result);
    }

    @Test
    @UseDataProvider("sphereComparator")
    public void shouldCompareByX(Sphere firstSphere,Sphere secondSphere, int expected) {
        //given

        //when
        int result = xComparator.compare(firstSphere,secondSphere);
        //then
        assertEquals(expected, result);
    }

    @Test
    @UseDataProvider("sphereComparator")
    public void shouldCompareByY(Sphere firstSphere,Sphere secondSphere, int expected) {
        //given

        //when
        int result = yComparator.compare(firstSphere,secondSphere);
        //then
        assertEquals(expected, result);
    }

    @Test
    @UseDataProvider("sphereComparator")
    public void shouldCompareByZ(Sphere firstSphere,Sphere secondSphere, int expected) {
        //given

        //when
        int result = zComparator.compare(firstSphere,secondSphere);
        //then
        assertEquals(expected, result);
    }
}
