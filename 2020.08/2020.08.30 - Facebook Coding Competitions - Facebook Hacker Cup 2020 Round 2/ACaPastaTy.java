package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner2;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.io.LightWriter2;

public class ACaPastaTy {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner2 in, LightWriter2 out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter2.CaseLabel.GCJ);
        if (false) in.next();
        int n = in.ints(), k = in.ints();
        long[] s = longs(n, k, in), lo = longs(n, k, in), y = longs(n, k, in), hi = lo.clone();
        for (int i = 0; i < n; i++) hi[i] += y[i];
        long less = 0, more = 0, lb = 0, ub = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            lb += lo[i];
            ub += hi[i];
            sum += s[i];
            if (s[i] < lo[i]) less += lo[i] - s[i];
            if (hi[i] < s[i]) more += s[i] - hi[i];
        }
        out.cases(testNumber);
        if (sum < lb || ub < sum) out.ans(-1).ln();
        else out.ans(Math.max(less, more)).ln();
    }

    private static long[] longs(int n, int k, LightScanner2 in) {
        long[] a = new long[n];
        for (int i = 0; i < k; i++) a[i] = in.longs();
        long[] p = in.longs(4);
        for (int i = k; i < n; i++) a[i] = (p[0] * a[i - 2] + p[1] * a[i - 1] + p[2]) % p[3];
        return a;
    }
}
