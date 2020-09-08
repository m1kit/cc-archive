package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BBalancedNeighbors {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        outer: for (int s = 3; s <= 5050; s++) {
            int[] res = new int[n + 1];
            int m = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (i + j == s) continue;
                    m++;
                    res[i] += j;
                    res[j] += i;
                }
            }
            for (int i = 1; i <= n; i++) {
                if (res[i] != res[1]) {
                    continue outer;
                }
            }
            out.ansln(m);
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (i + j == s) continue;
                    out.ans(i).ans(j).ln();
                }
            }
            return;
        }
    }
}
