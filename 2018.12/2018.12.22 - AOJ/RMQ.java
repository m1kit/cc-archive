package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.structure.IntSegmentTree;

import java.io.PrintWriter;
import java.util.Arrays;

public class RMQ {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), q = in.ints();
        long[] a = new long[n];
        Arrays.fill(a, Integer.MAX_VALUE);
        IntSegmentTree seg = new IntSegmentTree(a, Math::min, Long.MAX_VALUE);
        for (int i = 0; i < q; i++) {
            switch (in.ints()) {
                case 0:
                    seg.update(in.ints(), in.ints());
                    break;
                case 1:
                    out.println(seg.query(in.ints(), in.ints() + 1));
                    break;
            }
        }
    }
}
