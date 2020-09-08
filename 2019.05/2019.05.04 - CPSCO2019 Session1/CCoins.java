package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Combination;

public class CCoins {

    private static final int MOD = (int) 1e9 + 7;
    private static final long[] CURRENCY = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100_000, 500_000, 1000_000, 5000_000, 10_000_000, 50_000_000, 100_000_000, 500_000_000, 1000_000_000, 5000_000_000L};

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), k = in.ints();
        int[] a = in.ints(n);
        Combination comb = new Combination(n, k);
        int ans = Integer.MAX_VALUE;
        while (comb.hasNext()) {
            long c = comb.next();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & c) != 0) sum += a[i];
            }
            int cur = CURRENCY.length - 1;
            int cnt = 0;
            while (sum > 0) {
                while (sum < CURRENCY[cur]) {
                    cur--;
                }
                while (sum >= CURRENCY[cur]) {
                    sum -= CURRENCY[cur];
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        out.ans(ans).ln();
    }
}
