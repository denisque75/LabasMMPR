package com.denisque.mmpr.core.validator;

public interface Validator<T> {

    boolean isValid(T t);
}
