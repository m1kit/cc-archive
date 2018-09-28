package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class CAtColor {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] u = new int[1_000_001];
        int[] d = new int[1_000_001];
        for (int i = 0; i < n; i++) {
            u[in.nextInt()]++;
            d[in.nextInt()]++;
        }
        int[] b = new int[1_000_001];
        b[0] = u[0];
        for (int i = 1; i < 1_000_001; i++) {
            b[i] = b[i - 1] + u[i] - d[i - 1];
        }
        out.println(IntStream.of(b).max().orElse(0));
    }
}
