package com.epam.task1.repository;

public interface Specification<T> {
    boolean specified(T object);
}
