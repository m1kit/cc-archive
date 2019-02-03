package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CGoodSequence {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        Map<Integer, Integer> m = new HashMap<>();
        int n = in.ints();
        int[] a = in.ints(n);
        int ans = 0;
        for (int x : a) {
            m.merge(x, 1, (p, q) -> p + q);
        }
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() >= e.getKey()) {
                ans += e.getValue() - e.getKey();
            } else {
                ans += e.getValue();
            }
        }
        out.println(ans);
    }
}
