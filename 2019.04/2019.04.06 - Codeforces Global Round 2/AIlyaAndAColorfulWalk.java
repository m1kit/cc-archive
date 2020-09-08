package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AIlyaAndAColorfulWalk {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] c = in.ints(n);
        int left = 0;
        while (c[left] == c[n - 1]) {
            left++;
        }
        int right = n - 1;
        while (c[0] == c[right]) {
            right--;
        }
        out.ansln(Math.max(n - left - 1, right));
    }
}
