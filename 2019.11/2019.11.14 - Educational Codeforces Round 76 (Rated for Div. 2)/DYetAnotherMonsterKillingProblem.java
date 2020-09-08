package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.IntMath;
import dev.mikit.atcoder.lib.structure.segmenttree.IntSegmentTree;

import java.util.Arrays;

public class DYetAnotherMonsterKillingProblem {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        loop:
        for (int testCase = 0; testCase < testCases; testCase++) {
            int monsters = in.ints();
            long[] mp = in.longs(monsters);
            IntSegmentTree hp = new IntSegmentTree(mp, Math::max, 0, Math::max);
            int heroes = in.ints();
            IntSegmentTree st;
            {
                long[] neg = new long[monsters + 1];
                Arrays.fill(neg, Integer.MIN_VALUE);
                st = new IntSegmentTree(neg, Math::max, 0, Math::max);
                for (int i = 0; i < heroes; i++) {
                    long p = in.longs();
                    int s = in.ints();
                    st.update(s, p);
                }
            }
            int ans = 0;
            for (int i = 0; i < monsters; ) {
                int ok = i, ng = monsters + 1;
                while (ng - ok > 1) {
                    int mid = (ok + ng) / 2;
                    if (st.query(mid - i, monsters + 1) < hp.query(i, mid)) {
                        ng = mid;
                    } else ok = mid;
                }
                //System.out.println("i=" + i + " to " + ok);
                if (ok == i) {
                    out.ans(-1).ln();
                    continue loop;
                }
                ans++;
                i = ok;
            }
            out.ans(ans).ln();
        }
    }
}
