package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;

public class IdSpecification implements Specification<Sphere> {
    private long id;

    public IdSpecification(long id){
        this.id = id;
    }

    @Override
    public boolean specified(Sphere sphere) {
        long currentId = sphere.getId();
        return currentId == id;
    }
}
