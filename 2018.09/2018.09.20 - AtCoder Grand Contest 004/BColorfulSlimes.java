package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.LongStream;

public class BColorfulSlimes {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long x = in.nextLong();
        long[][] a = new long[n][n];
        a[0] = LongStream.range(0, n).map(z -> in.nextInt()).toArray();
        long ans = LongStream.of(a[0]).sum();
        for (int k = 1; k < n; k++) {
            for (int i = 0; i < n; i++) {
                a[k][i] = Math.min(a[k - 1][(i + n - 1) % n], a[0][i]);
            }
            ans = Math.min(ans, LongStream.of(a[k]).sum() + k * x);
        }
        out.println(ans);
    }
}
