package com.epam.geometry.logics.validator;

public interface Validator<T> {
    boolean validate(T object);
}
