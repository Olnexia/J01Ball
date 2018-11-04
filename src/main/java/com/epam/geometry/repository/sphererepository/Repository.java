package com.epam.geometry.repository.sphererepository;

import com.epam.geometry.repository.specification.Specification;
import java.util.List;

public interface Repository<T> {
    void add(T object);
    void remove (T object);
    void update (T object);
    List<T> query(Specification<T> specification);
}