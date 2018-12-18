package com.denisque.mmpr.core.executor.laba4;

import com.denisque.mmpr.core.executor.FormulaExecutor;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Laba4Executor implements FormulaExecutor<String> {

    private double dfdx(double x, double y) {
        return (((22 * x)+(6 * y))-(2 * (sqrt(10))));
    }

    private double dfdy(double x, double y) {
        return  (((6 * y) + (6 * x) )+ (6 * (sqrt(10))));
    }

    private double f(double x, double y) {
        return (((11*(pow(x, 2)))+(3 * (pow(y, 2)))+(6*x*y)-(2*(sqrt(10))*(x-3*y))-(22)));
    }


    private double flamda(double l, double q0, double g0) {
        return (((11 * (pow((q0 - (l * ((dfdx(q0, g0))))), 2))) + (3 * (pow((g0 - (l * ((dfdy(q0, g0))))), 2)))
                + (6 * (q0 - (l * ((dfdx(q0, g0))))) * (g0 - (l * ((dfdy(q0, g0)))))) -
                ((2 * (sqrt(10)))* (q0 - (l * ((dfdx(q0, g0)))))-3*(g0 - (l * ((dfdy(q0, g0))))))  - (22)));
    }

    private double gold(double eps1, double a,double b,double p0,double u0){

        double z1, z2;

        while (abs(b - a) > eps1) //условие поиска экстремума
        {

            z1 = a + 0.382*(b - a);
            z2 = a + 0.618*(b - a);
            if (flamda(z1,p0,u0) <= flamda(z2, p0, u0))
                b = z2;
            else
                a = z1;
        }

        return ((a+b)/2);
    }



    private double norma(double x, double y) {
        return sqrt(x*x + y * y);
    }


    @Override
    public String calculate(double eps) {
        int i = 0;
        double x1;
        double y1;
        double lamda;

        StringBuilder result = new StringBuilder("eps: " + eps + "\n");

        double x0 = 0;
        double y0 = 0;

        while (true) {
            result.append("x0: ").append(x0).append(" y0: ").append(y0).append("\n\n");

            lamda = gold(eps,0,1,x0,y0);

            result.append("\tlamda: ").append(lamda).append("\n\n");

            x1 = x0 - (lamda * (dfdx(x0, y0)));
            y1 = y0 - (lamda * (dfdy(x0, y0)));
            i++;

            result.append("x1: ").append(x1).append(" y1: ").append("\n").append("f(x1,y1): ")
                    .append(f(x1, y1)).append("-------------------------- ").append(i);

            if (((norma(x1 - x0, y1 - y0)) < eps) || (norma(dfdx(x1, y1), dfdy(x1, y1))) < eps) {
                break;
            } else {
                x0 = x1;
                y0 = y1;
            }

        }
        result.append("i: ").append(i).append("\n").append("min: ").append("( ").append(x1).append(",").append(y1).append(")").append("\n");

        return result.toString();
    }
}
