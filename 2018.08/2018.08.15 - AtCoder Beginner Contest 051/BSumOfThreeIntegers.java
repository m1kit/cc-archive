package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BSumOfThreeIntegers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int k = in.nextInt(), s = in.nextInt();
        out.println(IntStream.rangeClosed(Math.max(0, s - 2 * k), Math.min(k, s))
                        .map(x -> Math.min(k, s - x) - Math.max(0, s - x - k) + 1)
                        .filter(v -> v > 0)
                        .sum());
    }
}
