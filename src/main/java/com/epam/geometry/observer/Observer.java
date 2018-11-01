package com.epam.geometry.observer;

public interface Observer<T> {
    void update(T object);
}
