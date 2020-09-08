package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class BChristmasSpruce {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] children = new int[n];
        int[] parent = new int[n];
        boolean[] leaf = new boolean[n];
        Arrays.fill(leaf, true);
        for (int i = 1; i < n; i++) {
            parent[i] = in.ints() - 1;
            leaf[parent[i]] = false;
        }
        for (int i = 1; i < n; i++) {
            if (leaf[i]) children[parent[i]]++;
        }
        for (int i = 0; i < n; i++) {
            if (!leaf[i] && children[i] < 3) {
                out.noln();
                return;
            }
        }
        out.yesln();
    }
}
