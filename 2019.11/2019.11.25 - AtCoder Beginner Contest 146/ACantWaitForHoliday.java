package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ACantWaitForHoliday {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        String s = in.string();
        int a = -1;
        if ("SUN".equals(s)) a = 7;
        else if ("MON".equals(s)) a = 6;
        else if ("TUE".equals(s)) a = 5;
        else if ("WED".equals(s)) a = 4;
        else if ("THU".equals(s)) a = 3;
        else if ("FRI".equals(s)) a = 2;
        else if ("SAT".equals(s)) a = 1;
        out.ans(a).ln();
    }
}
