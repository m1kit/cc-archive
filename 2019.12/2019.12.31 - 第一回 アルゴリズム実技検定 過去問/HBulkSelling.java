package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class HBulkSelling {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] stock = in.longs(n), count = {0, 0}, reduce = {0, 0}, min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < n; i++) {
            count[i % 2]++;
            min[i % 2] = Math.min(min[i % 2], stock[i]);
        }

        int q = in.ints();
        long ans = 0;
        for (int i = 0; i < q; i++) {
            switch (in.ints()) {
                case 0:
                    int x, a;
                case 1:
                    x = in.ints() - 1;
                    a = in.ints();
                    if (a <= stock[x] - reduce[x % 2]) {
                        stock[x] -= a;
                        min[x % 2] = Math.min(min[x % 2], stock[x]);
                        ans += a;
                    }
                    break;
                case 2:
                    a = in.ints();
                    if (a <= min[0] - reduce[0]) {
                        reduce[0] += a;
                        ans += a * count[0];
                    }
                    break;
                case 3:
                    a = in.ints();
                    if (a <= Math.min(min[0] - reduce[0], min[1] - reduce[1])) {
                        reduce[0] += a;
                        reduce[1] += a;
                        ans += a * n;
                    }
                    break;
            }
        }
        out.ans(ans).ln();
    }
}
