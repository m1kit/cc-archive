package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AChessForThree {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int spec = 3;
        for (int i = 0; i < n; i++) {
            if (spec == a[i]) {
                out.noln();
                return;
            }
            boolean[] f = new boolean[4];
            f[spec] = true;
            f[a[i]] = true;
            for (int j = 1; j <= 3; j++) {
                if (!f[j]) {
                    spec = j;
                    break;
                }
            }
        }
        out.yesln();
    }
}
