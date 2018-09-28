package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BTollGates {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), x = in.nextInt();
        int[] a = IntStream.range(0, m).map(i -> in.nextInt()).toArray();
        out.println(Math.min(
                Arrays.stream(a)
                        .filter(i -> i > x)
                        .count(),
                Arrays.stream(a)
                        .filter(i -> i < x)
                        .count()
        ));

    }
}
