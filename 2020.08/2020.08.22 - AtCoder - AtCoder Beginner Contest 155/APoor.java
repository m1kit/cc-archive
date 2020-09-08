package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.HashSet;

public class APoor {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        HashSet<Integer> set = new HashSet<>();
        set.add(in.ints());
        set.add(in.ints());
        set.add(in.ints());
        out.ans(set.size() == 2).ln();
    }
}
