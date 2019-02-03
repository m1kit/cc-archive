package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ASumInTheTree {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int n;
    private static int[] p;
    private static List<List<Integer>> list;
    private static long[] s;

    private static long[] a;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        n = in.ints();
        list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        p = new int[n];
        for (int i = 1; i < n; i++) {
            int pa = in.ints() - 1;
            list.get(pa).add(i);
            p[i] = pa;
        }
        s = in.longs(n);

        for (int i = 0; i < n; i++) {
            if (s[i] >= 0 || list.get(i).isEmpty()) {
                continue;
            }
            long min = 1_000_000_000L;
            for (int c : list.get(i)) {
                min = Math.min(min, s[c]);
            }
            s[i] = min;
        }



        //out.enableDebug();
        out.debug("s", s);

        long ans = s[0];
        for (int i = 1; i < n; i++) {
            if (s[i] == -1) {
                continue;
            }
            long d = s[i] - s[p[i]];
            if (d < 0) {
                out.ans(-1).ln();
                return;
            }
            ans += d;
        }
        out.ans(ans).ln();
    }
}
