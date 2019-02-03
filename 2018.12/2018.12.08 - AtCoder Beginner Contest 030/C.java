package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class C {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] n = in.ints(2);
        int[] x = {in.ints(), in.ints()};
        int[][] a = {in.ints(n[0]), in.ints(n[1])};
        int[] c = {0, 0};
        int h = 0;
        long t = 0;
        int ans = 0;
        while (true) {
            while (c[h] < a[h].length && a[h][c[h]] < t) {
                c[h]++;
            }
            if (c[h] == n[h]) {
                break;
            }
            if (h == 1) {
                ans++;
            }
            t = a[h][c[h]] + x[h];
            h ^= 1;
        }
        out.println(ans);
    }
}
