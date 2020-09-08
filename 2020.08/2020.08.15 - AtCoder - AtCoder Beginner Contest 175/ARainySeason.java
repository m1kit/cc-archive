package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ARainySeason {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        String s = in.string();
        if ("RRR".equals(s)) out.ans(3).ln();
        else if (s.contains("RR")) out.ans(2).ln();
        else if (s.contains("R")) out.ans(1).ln();
        else out.ans(0).ln();
    }
}
