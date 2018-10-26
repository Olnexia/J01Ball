package tests;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Sphere;
import com.epam.task1.repository.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SphereRepositoryTest {
    private final static Sphere TEST_SPHERE = new Sphere(5 , new Point(5,2,4));
    private final static long TEST_ID = 42L;
    private Repository<Sphere> repository = new SphereRepository();
    {
        TEST_SPHERE.setId(TEST_ID);
        repository.add(TEST_SPHERE);
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
        Assert.assertEquals(TEST_SPHERE,firstSphere);
    }

    @Test
    public void shouldFindByVolume(){
        //given
        Specification<Sphere> volumeSpecification = new VolumeGreaterThanSpecification(1);
        //when
        List<Sphere> actual =repository.query(volumeSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(TEST_SPHERE,firstSphere);
    }

    @Test
    public void shouldFindById(){
        //given
        Specification<Sphere> idSpecification = new IdSpecification(TEST_ID);
        //when
        List<Sphere> actual =repository.query(idSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(TEST_SPHERE,firstSphere);
    }
}
