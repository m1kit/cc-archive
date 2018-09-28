package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        boolean[] mikan = new boolean[n];
        for (int i = 0; i < m; i++) {
            IntStream.rangeClosed(in.nextInt(), in.nextInt())
                    .forEach(k -> mikan[k - 1] = true);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += mikan[i] ? a : b;
        }
        out.println(ans);
    }
}
