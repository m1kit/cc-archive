package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class CTreeRestoring {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.POSSIBLE_IMPOSSIBLE_FIRST_UP);
        int n = in.ints(), min = n, max = 0;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            cnt[a]++;
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        if ((max + 1) / 2 != min || cnt[min] != max % 2 + 1) {
            out.noln();
            return;
        }
        for (int i = min + 1; i <= max; i++) {
            if (cnt[i] < 2) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
