package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class BBitterAlchemy {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), x = in.nextInt();
        int[] m = IntStream.range(0, n).map(i -> in.nextInt()).toArray();
        int min = Arrays.stream(m).min().orElse(0);
        int sum = Arrays.stream(m).sum();
        out.println((x - sum) / min + n);
    }
}
