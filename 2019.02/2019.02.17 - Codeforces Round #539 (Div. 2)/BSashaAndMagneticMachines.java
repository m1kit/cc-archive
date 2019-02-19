package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class BSashaAndMagneticMachines {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);

        if (n == 1) {
            out.ansln(a[0]);
        }

        IntroSort.sort(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        int[] indices = new int[101];
        Arrays.fill(indices, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= a[i]; j++) {
                if (a[i] % j == 0) {
                    indices[j] = i;
                }
            }
        }

        long min = sum;
        for (int i = 2; i <= 100; i++) {
            if (indices[i] == -1) {
                continue;
            }
            long t = sum - a[0] - a[indices[i]];
            t += i * a[0];
            t += a[indices[i]] / i;
            min = Math.min(min, t);
        }
        out.ans(min).ln();
    }
}
