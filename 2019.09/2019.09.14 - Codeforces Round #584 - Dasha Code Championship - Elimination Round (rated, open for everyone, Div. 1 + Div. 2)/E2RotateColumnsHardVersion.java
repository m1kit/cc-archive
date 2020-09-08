package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class E2RotateColumnsHardVersion {

    private static final int MOD = (int) 1e9 + 7;

    private static int n, m;
    private static int[][] mat;
    private static int[] nmax;
    private static Set<Long> hashes = new HashSet<>();

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            n = in.ints();
            m = in.ints();
            int[][] a = in.ints(n, m);
            P[] columns = new P[m];
            for (int i = 0; i < m; i++) {
                int max = 0;
                for (int j = 0; j < n; j++) max = Math.max(max, a[j][i]);
                columns[i] = new P(i, max);
            }
            IntroSort.sort(columns, Comparator.comparing(column -> -column.m));
            columns = Arrays.copyOf(columns, Math.min(n, m));
            mat = new int[Math.min(n, m)][n];
            nmax = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < Math.min(n, m); j++) {
                    mat[j][i] = a[i][columns[j].i];
                }
            }

            int[] init = new int[n];
            System.arraycopy(mat[0], 0, init, 0, n);
            hashes.clear();
            out.ans(dfs(1, init)).ln();
        }
    }

    private static int dfs(int i, int[] max) {
        int ans = 0;
        long hash = i;
        for (int j = 0; j < n; j++) {
            hash *= 10007;
            hash += max[j];
            hash %= 1000000011;
            ans += max[j];
        }
        if (i == Math.min(n, m) || hashes.contains(hash)) {
            return ans;
        }
        for (int j = 0; j < n; j++) {
            boolean ok = false;
            for (int k = 0; k < n; k++) {
                if (max[k] < mat[i][(j + k) % n]) {
                    ok = true;
                    nmax[k] = mat[i][(j + k) % n];
                } else {
                    nmax[k] = max[k];
                }
            }
            if (ok) {
                ans = Math.max(ans, dfs(i + 1, nmax));
            }
        }
        hashes.add(hash);
        return ans;
    }

    private static class P {
        int i, m;

        P(int i, int m) {
            this.i = i;
            this.m = m;
        }
    }
}
