package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.counting.Permutation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class WormholeInOne {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int n = in.ints();
        long[] x = new long[n], y = new long[n];
        in.longs(x, y);
        if (n <= 3) {
            out.cases(testNumber).ans(n).ln();
            return;
        }
        int ans = 1;

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.clear();
                long dx = x[i] - x[j], dy = y[i] - y[j];
                if (dx == 0 && dy == 0) continue;

                for (int k = 0; k < n; k++) map.merge(dx * y[k] - dy * x[k], 1, Integer::sum);
                int mul = 0, mono = 0;
                for (Integer c : map.values()) {
                    if (c == 1) mono++;
                    else mul += c;
                }
                if (mul % 2 == 1) {
                    mul--;
                    mono++;
                }
                ans = Math.max(ans, mul + Math.min(mono, 2));
            }
        }
        out.cases(testNumber).ans(ans).ln();
    }
}
