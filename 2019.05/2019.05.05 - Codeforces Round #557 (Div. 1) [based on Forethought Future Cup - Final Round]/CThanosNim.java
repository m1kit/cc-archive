package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.math.linear.IntMatrix;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class CThanosNim {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.ALICE_BOB_FIRST_UP);
        int n = in.ints(), k = n / 2;
        int[] x = in.ints(n);
        IntroSort.sort(x);

        for (int i = 1; i <= k; i++) {
            if (x[i] != x[0]) {
                out.yesln();
                return;
            }
        }
        out.noln();
    }
}
