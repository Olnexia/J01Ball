package com.epam.task1.repository;

import com.epam.task1.entity.Sphere;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere>{
    private Map<Long,Sphere> data = new HashMap<>();

    @Override
    public void add( Sphere object){
        long id = object.getId();
        data.put(id,object);
    }

    @Override
    public void update( Sphere object){
        long id = object.getId();
        data.replace(id,object);

    }

    @Override
    public void remove (Sphere object){
        long id = object.getId();
        if(data.containsKey(id)){
            data.remove(id);
        }
    }

    public List<Sphere> query(Specification specification){
        return data.values().stream().
                filter(o->specification.specified(o))
                .collect(Collectors.toList());
    }
}
