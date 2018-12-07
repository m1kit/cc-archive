package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.math.BitMath;

import java.io.PrintWriter;
import java.util.*;

public class C3 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] a = in.ints(5);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < 0b100000; i++) {
            if (BitMath.count(i) != 3) {
                continue;
            }
            int t = 0;
            for (int j = 0; j < 5; j++) {
                if ((i & (1 << j)) > 0) {
                    t += a[j];
                }
            }
            s.add(t);
        }
        List<Integer> list = new ArrayList<>(s);
        Collections.sort(list);
        out.println(list.get(list.size() - 3));
    }
}
