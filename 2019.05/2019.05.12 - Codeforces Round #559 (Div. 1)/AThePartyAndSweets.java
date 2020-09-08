package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.stream.LongStream;

public class AThePartyAndSweets {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        long[] b = in.longs(n), g = in.longs(m);
        IntroSort.sort(b);
        ArrayUtil.reverse(b, 0, n);
        IntroSort.sort(g);
        ArrayUtil.reverse(g, 0, m);
        if (b[0] > g[m - 1]) {
            out.ans(-1).ln();
            return;
        }
        long ans = LongStream.of(b).sum() * m;

        int cur = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            while (t < m - 1 && cur < m && g[cur] > b[i]) {
                ans += g[cur] - b[i];
                cur++;
                t++;
            }
            while (cur < m && g[cur] == b[i]) {
                cur++;
            }
            if (cur == m) break;
        }
        if (cur != m) {
            out.ans(-1).ln();
            return;
        }
        out.ans(ans).ln();
    }
}
