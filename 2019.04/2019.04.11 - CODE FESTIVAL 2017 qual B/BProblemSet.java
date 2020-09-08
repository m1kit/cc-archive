package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

public class BProblemSet {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setBoolLabel(LightWriter.BoolLabel.YES_NO_ALL_UP);
        int n = in.ints();
        int[] d = in.ints(n);
        int m = in.ints();
        int[] t = in.ints(m);
        IntroSort.sort(d);
        IntroSort.sort(t);

        int c = 0;
        for (int i = 0; i < m; i++) {
            while (c < n && d[c] < t[i]) {
                c++;
            }
            if (c == n || d[c] > t[i]) {
                out.noln();
                return;
            }
            c++;
        }
        out.yesln();
    }
}
