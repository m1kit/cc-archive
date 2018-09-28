package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class DPatisserieABC {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        long[] z = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextLong();
            y[i] = in.nextLong();
            z[i] = in.nextLong();
        }
        long mv = 0;
        for (int xd : new int[]{1, -1}) {
            for (int yd : new int[]{1, -1}) {
                for (int zd : new int[]{1, -1}) {
                    long v = 0;
                    long[] t = new long[n];
                    for (int i = 0; i < n; i++) {
                        t[i] = (x[i] * xd) + (y[i] * yd) + (z[i] * zd);
                    }
                    Arrays.sort(t);
                    for (int i = t.length - 1; Math.max(0, t.length - m) <= i; i--) {
                        v += t[i];
                    }
                    mv = Math.max(mv, v);
                }
            }
        }
        out.println(mv);
    }
}
