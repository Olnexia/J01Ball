package com.epam.task1.repository;

import com.epam.task1.entity.Sphere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere>{

    private Map<Long,Sphere> data = new HashMap<>();

    public void add( Sphere object){
        data.put(object.getId(),object);
    }

    public List<Sphere> findBy(final Specification specification){
        data.values().stream().
                filter(o->specification.specified(o))
                .collect(Collectors.toList());
    }
}
