package com.denisque.mmpr.core.executor.laba2;

import com.denisque.mmpr.core.executor.FormulaExecutor;

public class Laba2Executor implements FormulaExecutor<String> {

    public Laba2Executor() {
    }

    private double calculateFormula(double x) {
        return (Math.tan(x) + (1 / x));
    }

    @Override
    public String calculate(double eps) {
        double x1;
        double x0 = -1.0f;

        StringBuilder result = new StringBuilder("eps: " + eps + "\n");

        for (int i = 1; ; i++) {

            result.append("x0: ").append(x0).append("\n");
            x1 = x0 - ((dx1(x0)) / (dx2(x0)));

            result.append("x1: ").append(x1).append("f(x1):").append(calculateFormula(x1)).append("\n");
            result.append("-------------------------- ").append(i).append("\n");
            if ((Math.abs(dx1(x1))) <= eps) {
                result.append("i: ").append(i).append("\n");
                break;
            } else {
                x0 = x1;
            }
        }

        return result.toString();
    }

    private double dx1(double x) {
        return (((-4-x) / Math.pow(x, 3))-1);
    }

    private double dx2(double x) {
        return (((2*x)+12) / Math.pow(x, 4));
    }

}
