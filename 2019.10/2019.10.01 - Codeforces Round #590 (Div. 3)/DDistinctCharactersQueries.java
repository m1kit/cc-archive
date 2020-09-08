package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.BitMath;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

public class DDistinctCharactersQueries {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        char[] s = in.string().toCharArray();
        int n = s.length;
        long[] v = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] -= 'a';
            v[i] = 1L << s[i];
        }
        IntSegmentTree st = new IntSegmentTree(v, (x, y) -> x | y, 0, (x, u) -> u);

        int queries = in.ints();
        for (int query = 0; query < queries; query++) {
            if (in.ints() == 1) {
                int index = in.ints() - 1;
                int chr = in.string().charAt(0) - 'a';
                st.update(index, 1L << chr);
            } else {
                int l = in.ints() - 1, r = in.ints();
                out.ans(BitMath.count(st.query(l, r))).ln();
            }
        }
    }
}
