package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.math.IntMath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EArithmeticProgression {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.enableAutoFlush();
        int n = in.ints();
        long min = 0, max = 1_000_000_000;
        int remain = 60;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            out.ans('>').ans(mid).ln();
            remain--;
            int r = in.ints();
            if (r == 1) {
                min = mid;
            } else if (r == 0) {
                max = mid;
            } else {
                return;
            }
        }
        max = ++min;

        Set<Long> done = new HashSet<>();
        long[] res = new long[Math.min(remain, n)];
        for (int i = 0; i < Math.min(remain, n); i++) {
            long index;
            do {
                index = System.nanoTime() % n;
            } while(done.contains(index));
            done.add(index);
            out.print('?').ans(index + 1).ln();
            res[i] = in.ints();
            if (res[i] == -1) {
                return;
            }
        }
        Arrays.sort(res);

        long d = res[1] - res[0];
        for (int i = 1; i < Math.min(remain, n) - 1; i++) {
            d = IntMath.gcd(d, res[i + 1] - res[i]);
        }
        out.ans('!').ans(max - (n - 1) * d).ans(d).ln();
    }
}
