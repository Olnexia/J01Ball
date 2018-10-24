package tests;

import com.epam.task1.entity.Sphere;
import com.epam.task1.repository.Repository;
import com.epam.task1.repository.Specification;
import com.epam.task1.repository.SphereRepository;
import com.epam.task1.repository.VolumeGreaterThanSpecification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class SphereRepositoryTest {
    private final static Sphere FIRST_SPHERE = new Sphere(5 , 3 ,4 ,-2);
    Repository<Sphere> repository = new SphereRepository();

    {
        repository.add(FIRST_SPHERE);
    }

    @Test
    public void shouldFindByVolume(){
        Specification<Sphere> mock = Mockito.mock(Specification.class);
        //when
        List<Sphere> actual =repository.findBy(new VolumeGreaterThanSpecification(1));
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(FIRST_SPHERE,firstSphere);
    }
}
