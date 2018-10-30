package com.epam.task1.repository;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SphereRepositoryTest {
    private final static Sphere FIRST_TEST_SPHERE = new Sphere(5 , new Point(5,2,4));
    private final static long TEST_ID = 42L;
    private Repository<Sphere> repository = new SphereRepository();
    {
        FIRST_TEST_SPHERE.setId(TEST_ID);
        repository.add(FIRST_TEST_SPHERE);
    }

    @Test
    public void shouldQueryCorrectlyWithMockedSpecification(){
        //given
        Specification<Sphere> mock = Mockito.mock(Specification.class);
        when(mock.specified(any(Sphere.class))).thenReturn(true);
        //when
        List<Sphere> actual =repository.query(mock);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(FIRST_TEST_SPHERE,firstSphere);
    }
}
