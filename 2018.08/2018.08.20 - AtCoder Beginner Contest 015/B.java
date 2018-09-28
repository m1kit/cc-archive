package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println((int) Math.ceil(IntStream.range(0, in.nextInt()).map(i -> in.nextInt()).filter(i -> i != 0).average().orElse(0.0)));
    }
}
