package com.epam.task1.validator;

public interface Validator<T> {
    boolean validate(T object);
}
