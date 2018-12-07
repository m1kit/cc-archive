package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class DRestoringRoadNetwork {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[][] a = in.ints(n, n);
        long ans = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                boolean r = true;
                for (int i = 0; i < n; i++) {
                    if (a[j][k] > a[j][i] + a[i][k]) {
                        out.println(-1);
                        return;
                    } else if (i != j && i != k && a[j][k] == a[j][i] + a[i][k]) {
                        r = false;
                    }
                }
                if (r) {
                    ans += a[j][k];
                }
            }
        }
        out.println(ans / 2);
    }
}
