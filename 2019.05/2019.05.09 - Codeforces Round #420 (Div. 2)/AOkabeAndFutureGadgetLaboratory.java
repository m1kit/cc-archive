package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class AOkabeAndFutureGadgetLaboratory {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[][] a = in.ints(n, n);
        for (int i = 0; i < n; i++) {
            outer: for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) continue;
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (a[i][j] == a[i][k] + a[l][j]) {
                            continue outer;
                        }
                    }
                }
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
