package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class BTheModcrab {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int h1 = in.ints(), a1 = in.ints(), c = in.ints();
        int h2 = in.ints(), a2 = in.ints();
        List<String> ans = new ArrayList<>();
        while (h2 > 0) {
            if (h1 <= a2 && h2 > a1) {
                ans.add("HEAL");
                h1 += c;
            } else {
                ans.add("STRIKE");
                h2 -= a1;
            }
            h1 -= a2;
        }
        out.ans(ans.size()).ln();
        for (String str : ans) out.ans(str).ln();
    }
}
