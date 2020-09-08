package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ESimpleStringQueries {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        long[] s = in.string().chars().mapToLong(c -> 1L << (c - 'a')).toArray();
        IntSegmentTree st = new IntSegmentTree(s, (x, y) -> x | y, 0, (x, u) -> 1L << (u - 'a'));
        int q = in.ints();
        for (int i = 0; i < q; i++) {
            if (in.ints() == 1) {
                st.update(in.ints() - 1, in.string().charAt(0));
            } else {
                out.ans(BitMath.count(st.query(in.ints() - 1, in.ints()))).ln();
            }
        }
    }
}
