package com.epam.geometry.repository.sphererepository;

import com.epam.geometry.entity.Sphere;
import com.epam.geometry.repository.specification.Specification;
import java.util.*;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere> {
    private Map<Long,Sphere> data = new HashMap<>();

    @Override
    public void add( Sphere sphere){
        long id = sphere.getId();
        data.put(id,sphere);
    }

    @Override
    public void update( Sphere sphere){
        long id = sphere.getId();
        data.replace(id,sphere);
    }

    @Override
    public void remove (Sphere sphere){
        long id = sphere.getId();
        data.remove(id);
    }

    public List<Sphere> query(Specification specification){
        return data.values().stream().
                filter(o->specification.specified(o))
                .collect(Collectors.toList());
    }
}
