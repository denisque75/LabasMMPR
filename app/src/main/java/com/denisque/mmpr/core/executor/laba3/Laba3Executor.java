package com.denisque.mmpr.core.executor.laba3;

import com.denisque.mmpr.core.executor.FormulaExecutor;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Laba3Executor implements FormulaExecutor<String> {

    private double f(double x,double y) {
        return (((11 * (pow(x, 2)))+(3 * (pow(y, 2)))+(6 * x * y)-(2*(sqrt(10)) * x-3 * y)-(22)));
    }

    private double ddx(double x,double y) {
        return (((22 * x)+(6 * y))-(2 * (sqrt(10))));
    }

    private double ddy(double x, double y) {
        return  (((6 * y) + (6 * x) )+ (6 * (sqrt(10))));
    }

    private double norm(double x, double y) {
        return sqrt(x * x + y * y);
    }

    @Override
    public String calculate(double eps) {
        int i = 0;
        double x1;
        double y1;
        double lamda = 0.03;
        StringBuilder result = new StringBuilder("eps: " + eps + "\tlambda: " + lamda + "\n\n");

        double x0 = 0;
        double y0 = 0;

        while (true) {
            result.append("x0: ").append(x0).append("\ty0: ").append(y0).append("\n");

            x1 = x0 - (lamda * ((ddx(x0,y0))));
            y1 = y0 - (lamda * ((ddy(x0, y0))));
            i++;

            result.append("x1: ").append(x1).append("\ty1: ").append(y1).append("\n")
                    .append("f(x1,y1): ").append(f(x1,y1)).append("\n")
                    .append("-------------------------- ").append(i);

            if(((norm(x1-x0,y1-y0) ) < eps) || (norm(ddx(x1, y1), ddy(x1, y1))) < eps) {
                break;
            } else {
                x0 = x1;
                y0 = y1;
            }

        }
        result.append("i: ").append(i).append("\n").append("min: ").append("( ")
                .append(x1).append(",").append(y1).append(")").append("\n");

        return result.toString();
    }
}
