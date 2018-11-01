package com.epam.geometry.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.repository.specification.*;
import com.epam.geometry.repository.sphererepository.Repository;
import com.epam.geometry.repository.sphererepository.SphereRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SphereRepositoryIT {

    private final static Sphere FIRST_TEST_SPHERE = new Sphere(5 , new Point(5,2,4));
    private final static Sphere SECOND_TEST_SPHERE = new Sphere(3, new Point( 5,2,4));
    private final static long TEST_ID = 42L;
    private final static long NONEXISTENT_ID = 14L;
    private Repository<Sphere> repository = new SphereRepository();
    {
        FIRST_TEST_SPHERE.setId(TEST_ID);
        SECOND_TEST_SPHERE.setId(TEST_ID);
        repository.add(FIRST_TEST_SPHERE);
    }

    @Test
    public void shouldFindByVolume(){
        //given
        Specification<Sphere> volumeSpecification = new VolumeGreaterThanSpecification(1);
        //when
        List<Sphere> actual = repository.query(volumeSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(FIRST_TEST_SPHERE,firstSphere);
    }

    @Test
    public void shouldFindById(){
        //given
        Specification<Sphere> idSpecification = new IdSpecification(TEST_ID);
        //when
        List<Sphere> actual = repository.query(idSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere firstSphere = actual.get(0);
        Assert.assertEquals(FIRST_TEST_SPHERE,firstSphere);
    }

    @Test
    public void shouldNotFindById(){
        //given
        Specification<Sphere> idSpecification = new IdSpecification(NONEXISTENT_ID);
        //when
        List<Sphere> actual = repository.query(idSpecification);
        //then
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldUpdateWithSameId(){
        //given
        Specification<Sphere> idSpecification = new IdSpecification(TEST_ID);
        //when
        repository.update(SECOND_TEST_SPHERE);
        //then
        List<Sphere> actual = repository.query(idSpecification);
        Assert.assertEquals(1,actual.size());
        Sphere actualSphere = actual.get(0);
        Assert.assertEquals(SECOND_TEST_SPHERE,actualSphere);
    }

    @Test
    public void shouldFindInGivenRange(){
        //given
        Specification<Sphere> areaInRangeSpecification = new AreaInRangeSpecification(100,400);
        //when
        List<Sphere> actual = repository.query(areaInRangeSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere actualSphere = actual.get(0);
        Assert.assertEquals(FIRST_TEST_SPHERE,actualSphere);
    }

    @Test
    public void shouldFindRemovedFromOrigin(){
        //given
        Specification<Sphere> removedFromOriginSpecification = new RemovedFromOriginSpecification(2,7);
        //when
        List<Sphere> actual = repository.query(removedFromOriginSpecification);
        //then
        Assert.assertEquals(1,actual.size());
        Sphere actualSphere = actual.get(0);
        Assert.assertEquals(FIRST_TEST_SPHERE,actualSphere);
    }

    @Test
    public void shouldNotFindRemovedSoFarFromOrigin(){
        //given
        Specification<Sphere> removedFromOriginSpecification = new RemovedFromOriginSpecification(100,224);
        //when
        List<Sphere> actual = repository.query(removedFromOriginSpecification);
        //then
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void shouldReturnEmptyListWhenSphereDeleted(){
        //given
        Specification<Sphere> idSpecification = new IdSpecification(TEST_ID);
        //when
        repository.remove(SECOND_TEST_SPHERE);
        //then
        List<Sphere> actual = repository.query(idSpecification);
        Assert.assertEquals(0,actual.size());
    }

}
