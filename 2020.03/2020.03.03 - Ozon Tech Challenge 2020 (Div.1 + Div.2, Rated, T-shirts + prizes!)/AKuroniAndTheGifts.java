package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class AKuroniAndTheGifts {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int queries = in.ints();
        for (int query = 0; query < queries; query++) {
            int n = in.ints();
            int[] a = in.ints(n), b = in.ints(n);
            IntroSort.sort(a);
            IntroSort.sort(b);
            out.ans(a).ln().ans(b).ln();
        }
    }
}
