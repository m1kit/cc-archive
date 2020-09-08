package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        String[] s = {
                "B9", "B8", "B7", "B6", "B5", "B4", "B3", "B2", "B1",
                "1F", "2F", "3F", "4F", "5F", "6F", "7F", "8F", "9F",
        };
        out.ans(Math.abs(ArrayUtil.indexOf(s, in.string())-ArrayUtil.indexOf(s, in.string()))).ln();
    }
}
