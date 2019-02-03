package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class CTimeGap {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        int[] w = new int[13];
        for (int i = 0; i < n; i++) {
            if (++w[in.ints()] > 2) {
                out.ans(0).ln();
                return;
            }
        }

        if (w[0] >= 1 || w[12] > 1) {
            out.ans(0).ln();
            return;
        }

        List<Integer> times = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < 0b10000_0000_0000; i++) {
            times.clear();
            times.add(0);
            if (w[12] == 1) {
                times.add(12);
            }
            for (int j = 1; j < 12; j++) {
                if (w[j] == 0) {
                } else if (w[j] == 1) {
                    if ((i & (1 << (j - 1))) == 0) {
                        times.add(j);
                    } else {
                        times.add(24 - j);
                    }
                } else {
                    times.add(j);
                    times.add(24 - j);
                }
            }
            int s = 24;
            for (int j = 0; j < times.size(); j++) {
                for (int k = 0; k < j; k++) {
                    int d = (times.get(j) - times.get(k) + 24) % 24;
                    d = Math.min(d, (24 - d) % 24);
                    s = Math.min(s, d);
                }
            }
            ans = Math.max(ans, s);
        }
        out.ans(ans);
    }
}
