package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BSportsFestival {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        int[][] a = in.ints(n, m);
        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j]--;

        int ans = n;
        boolean[] removed = new boolean[m];
        mainloop: for (int loop = 0; loop < m; loop++) {
            int[] cnt = new int[m];
            outer: for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!removed[a[i][j]]) {
                        cnt[a[i][j]]++;
                        continue outer;
                    }
                }
                break mainloop;
            }

            int max = 0, maxIndex = -1;
            for (int i = 0; i < m; i++) {
                if (max < cnt[i]) {
                    max = cnt[i];
                    maxIndex = i;
                }
            }
            ans = Math.min(ans, max);
            //System.out.println("Color " + maxIndex + " has " + max + " people");

            removed[maxIndex] = true;
        }
        out.ans(ans).ln();
    }
}
