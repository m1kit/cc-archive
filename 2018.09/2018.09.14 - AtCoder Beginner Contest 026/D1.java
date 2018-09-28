package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.DoubleUnaryOperator;

public class D1 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
        DoubleUnaryOperator calc = t -> a * t + b * Math.sin(c * t * Math.PI);
        double min = 0.0, max = 128.0;
        while (max - min > 1e-12) {
            double mid = (min + max) / 2.0;
            if (calc.applyAsDouble(mid) > 100) {
                max = mid;
            } else {
                min = mid;
            }
        }
        out.println(max);
    }
}
