package com.denisque.mmpr.core.executor;

public interface FormulaExecutor<Result> {

    Result calculate(double eps);
}
