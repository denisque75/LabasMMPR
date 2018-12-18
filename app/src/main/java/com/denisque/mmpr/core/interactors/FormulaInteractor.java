package com.denisque.mmpr.core.interactors;

import com.denisque.mmpr.core.callbacks.OnResultCalculated;

public interface FormulaInteractor<Result> {

    void calculate(double eps, OnResultCalculated<Result> result);
}
