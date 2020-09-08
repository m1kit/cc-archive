package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class DEnoughArray {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        long k = in.longs();
        long[] a = in.longs(n);

        int r = 0;
        long sum = 0;
        long ans = 0;
        for (int l = 0; l < n; l++) {
            if (l > 0) sum -= a[l - 1];
            while (r < n && sum < k) {
                sum += a[r++];
            }
            //System.out.println("l="+l + " r="+r + " sum="+sum);
            if (sum < k) break;
            ans += n - r + 1;
        }
        out.ans(ans).ln();
    }
}
