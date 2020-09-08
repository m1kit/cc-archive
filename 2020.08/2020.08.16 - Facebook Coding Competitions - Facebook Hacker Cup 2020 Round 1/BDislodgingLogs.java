package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BDislodgingLogs {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int n = in.ints(), m = in.ints(), pk = in.ints(), s = in.ints();
        long[] p = new long[n], q = new long[m];
        for (int i = 0; i < pk; i++) p[i] = in.longs();
        long[] pa = in.longs(4);
        for (int i = pk; i < n; i++) p[i] = (pa[0] * p[i - 2] + pa[1] * p[i - 1] + pa[2]) % pa[3] + 1;
        for (int i = 0; i < pk; i++) q[i] = in.longs();
        long[] pc = in.longs(4);
        for (int i = pk; i < m; i++) q[i] = (pc[0] * q[i - 2] + pc[1] * q[i - 1] + pc[2]) % pc[3] + 1;
        IntroSort.sort(p);
        IntroSort.sort(q);
        long ng = 0, ok = 2_000_000_000L;
        while (ok - ng > 1) {
            long mid = (ok + ng) >> 1;
            int cur = 0;
            for (int i = 0; i < n && cur < m; i++) {
                long left = 0;
                if (q[cur] < p[i]) left = p[i] - q[cur];
                if (left > mid) break;
                while (cur < m && (left + Math.max(0, q[cur] - p[i]) * 2 <= mid || 2 * left + Math.max(0, q[cur] - p[i]) <= mid)) cur++;
            }
            if (cur == m) ok = mid;
            else ng = mid;
        }
        out.cases(testNumber).ans(ok).ln();
    }
}
