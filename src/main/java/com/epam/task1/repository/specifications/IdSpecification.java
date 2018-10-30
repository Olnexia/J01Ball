package com.epam.task1.repository.specifications;

import com.epam.task1.entity.Sphere;
import com.epam.task1.repository.Specification;

public class IdSpecification implements Specification<Sphere> {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specified(Sphere object) {
        long currentId = object.getId();
        return currentId == id;
    }
}
