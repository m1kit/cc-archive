package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BPapersPlease {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int x = in.ints();
            if ( x % 2==1)continue;
            if (x % 3 != 0 && x % 5 != 0) {
                out.ans("DENIED").ln();
                return;
            }
        }
        out.ans("APPROVED").ln();
    }
}
