package com.denisque.mmpr.core.callbacks;

public interface EntityCallback<T> {

    void onSuccess(T t);

    void onFailure(Exception ex);
}
