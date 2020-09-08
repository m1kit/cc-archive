package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class DAtCoderExpress {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), sum = 0;
        int[] t = in.ints(n), v = in.ints(n);
        for (int i = 0; i < n; i++) {
            t[i] *= 2;
            v[i] *= 2;
            sum += t[i];
        }
        int[] a = new int[sum + 1];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[0] = a[sum] = 0;

        // velocity limitation
        {
            int now = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= t[i]; j++)
                    a[now + j] = Math.min(a[now + j], v[i]);
                now += t[i];
            }
        }

        // left velocity angle limitation
        {
            for (int i = 1; i <= sum; i++)
                a[i] = Math.min(a[i], a[i - 1] + 1);
        }

        // right velocity angle limitation
        {
            for (int i = sum - 1; i >= 0; i--)
                a[i] = Math.min(a[i], a[i + 1] + 1);
        }

        long ans = 0;
        for (int i = 1; i < sum; i++) ans += a[i];
        out.ans(ans * 0.25, 12).ln();
    }
}
