package com.epam.task1.sorter;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import com.epam.task1.exceptions.SphereListSortingException;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorterTest {
    private static final Sphere FIRST_TEST_SPHERE = new Sphere(5,new Point(3,2,9));
    private static final Sphere SECOND_TEST_SPHERE = new Sphere(2,new Point(2,1,2));
    private static final Sphere THIRD_TEST_SPHERE = new Sphere(5,new Point(3,2,9));
    private static final Sphere FOURTH_TEST_SPHERE = new Sphere(9,new Point(5,7,10));
    private static final SphereSorter sorter = new SphereSorter();
    private List<Sphere> listToSort = new ArrayList <>();
    private List<Sphere> sortedList = new ArrayList <>();
    {
        FIRST_TEST_SPHERE.setId(55L);
        SECOND_TEST_SPHERE.setId(22L);
        THIRD_TEST_SPHERE.setId(55L);
        FOURTH_TEST_SPHERE.setId(322L);
        Collections.addAll(listToSort,FIRST_TEST_SPHERE,SECOND_TEST_SPHERE,THIRD_TEST_SPHERE,FOURTH_TEST_SPHERE);
        Collections.addAll(sortedList,SECOND_TEST_SPHERE, FIRST_TEST_SPHERE,THIRD_TEST_SPHERE,FOURTH_TEST_SPHERE);
    }

    @Test
    public void shouldSortById() throws SphereListSortingException {
        //given
        Collections.shuffle(listToSort);
        //when
        sorter.sortSphereList(listToSort, OrderBy.ID);
        //then
        Assert.assertEquals(listToSort,sortedList);
    }

    @Test
    public void shouldSortByRadius() throws SphereListSortingException {
        //given
        Collections.shuffle(listToSort);
        //when
        sorter.sortSphereList(listToSort, OrderBy.RADIUS);
        //then
        Assert.assertEquals(listToSort,sortedList);
    }

    @Test
    public void shouldSortByX() throws SphereListSortingException {
        //given
        Collections.shuffle(listToSort);
        //when
        sorter.sortSphereList(listToSort, OrderBy.X);
        //then
        Assert.assertEquals(listToSort,sortedList);
    }

    @Test
    public void shouldSortByY() throws SphereListSortingException {
        //given
        Collections.shuffle(listToSort);
        //when
        sorter.sortSphereList(listToSort, OrderBy.Y);
        //then
        Assert.assertEquals(listToSort,sortedList);
    }

    @Test
    public void shouldSortByZ() throws SphereListSortingException {
        //given
        Collections.shuffle(listToSort);
        //when
        sorter.sortSphereList(listToSort, OrderBy.Z);
        //then
        Assert.assertEquals(listToSort,sortedList);
    }
}
