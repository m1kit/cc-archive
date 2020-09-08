package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class E1RotateColumnsEasyVersion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), m = in.ints();
            int pow = 1;
            for (int i = 0; i < n; i++) pow *= n;
            int[][] a = in.ints(n, m);
            P[] columns = new P[m];
            for (int i = 0; i < m; i++) {
                int max = 0;
                for (int j = 0; j < n; j++) max = Math.max(max, a[j][i]);
                columns[i] = new P(i, max);
            }
            IntroSort.sort(columns, Comparator.comparing(column -> -column.m));

            int ans = 0;
            for (int i = 0; i < pow; i++) {
                int[] res = new int[n];
                int t = i;
                for (int j = 0; j < Math.min(n, m); j++) {
                    int shift = t % n;
                    t /= n;
                    for (int k = 0; k < n; k++) {
                        res[(k + shift) % n] = Math.max(res[(k + shift) % n], a[k][columns[j].i]);
                    }
                }
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += res[j];
                }
                ans = Math.max(ans, sum);
            }
            out.ans(ans).ln();
        }
    }

    private static class P {
        int i, m;

        P(int i, int m) {
            this.i = i;
            this.m = m;
        }
    }
}
