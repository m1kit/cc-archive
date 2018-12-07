package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        if (Arrays.stream(a).allMatch(i -> i == a[0])) {
            out.println(n / 2);
            return;
        }
        int[] x = new int[100001];
        int[] y = new int[100001];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                x[a[i]]++;
            } else {
                y[a[i]]++;
            }
        }

        int xmax = 0;
        int xmaxi = 0;
        for (int i = 1; i < 100001; i++) {
            if (xmax < x[i]) {
                xmax = x[i];
                xmaxi = i;
            }
        }
        int ymax = 0;
        int ymaxi = 0;
        for (int i = 1; i < 100001; i++) {
            if (ymax < x[i]) {
                ymax = x[i];
                ymaxi = i;
            }
        }

        int xmax2 = 0;
        for (int i = 1; i < 100001; i++) {
            if (i == ymaxi) {
                continue;
            }
            if (xmax2 < x[i]) {
                xmax2 = x[i];
            }
        }
        int ymax2 = 0;
        for (int i = 1; i < 100001; i++) {
            if (i == xmaxi) {
                continue;
            }
            if (ymax2 < y[i]) {
                ymax2 = y[i];
            }
        }
        out.println(Math.min(n - xmax - ymax2, n - xmax2 - ymax));
    }
}
