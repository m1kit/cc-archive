package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class HEarlyBird {

    private static final int MOD = (int) 1e9 + 7;
    private static final int DAY = 86400, MORNING = 10800;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] cnt = new int[DAY];
        int t = 0;
        for (int i = 0; i < n; i++) {
            t += in.ints();
            t %= DAY;
            cnt[t]++;
            t += in.ints();
        }
        int[] sum = new int[DAY * 2 + 1];
        for (int i = 0; i < DAY * 2; i++) {
            sum[i + 1] = sum[i] + cnt[i % DAY];
        }
        int ans = 0;
        for (int i = 0; i < DAY * 2 - MORNING; i++) {
            ans = Math.max(sum[i + MORNING + 1] - sum[i], ans);
        }
        out.ans(ans).ln();
    }
}
