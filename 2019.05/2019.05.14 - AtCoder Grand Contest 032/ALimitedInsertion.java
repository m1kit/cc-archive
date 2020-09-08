package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class ALimitedInsertion {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        List<Integer> b = new ArrayList<>(), ans = new ArrayList<>();
        for (int i = 0; i < n; i++) b.add(in.ints() - 1);
        outer: for (int i = 0; i < n; i++) {
            for (int j = b.size() - 1; j >= 0; j--) {
                if (b.get(j) == j) {
                    ans.add(j + 1);
                    b.remove(j);
                    continue outer;
                }
            }
            out.ans(-1).ln();
            return;
        }
        for (int i = n - 1; i >= 0; i--) {
            out.ans(ans.get(i)).ln();
        }
    }
}
