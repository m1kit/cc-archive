package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BTemplateMatching {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        String[] a = in.string(n), b = in.string(m);
        for (int i = 0; i <= n - m; i++) {
            middle: for (int j = 0; j <= n - m; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        if (a[l + j].charAt(k + i) != b[l].charAt(k)) {
                            continue middle;
                        }
                    }
                }
                out.yesln();
                return;
            }
        }
        out.noln();
    }
}
