package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class B1DimensionalWorldsTale {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), x = in.nextInt(), y = in.nextInt();
        int xm = IntStream.range(0, n).map(o -> in.nextInt()).max().orElse(0);
        int z = IntStream.range(0, m).map(o -> in.nextInt()).min().orElse(0);
        if (xm < z && x < z && z <= y) {
            out.println("No War");
        } else {
            out.println("War");
        }
    }
}
