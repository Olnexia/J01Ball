package com.epam.task1.logics.validator;

public interface Validator<T> {
    boolean validate(T object);
}
