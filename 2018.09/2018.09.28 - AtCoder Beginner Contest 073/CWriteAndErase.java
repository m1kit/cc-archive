package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class CWriteAndErase {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        Set<Integer> s = new HashSet<>();
        int n = in.ints();
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            if (s.contains(a)) {
                s.remove(a);
            } else {
                s.add(a);
            }
        }
        out.println(s.size());
    }
}
