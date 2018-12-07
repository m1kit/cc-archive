package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        List<Integer> s = new ArrayList<>();
        s.add(in.ints());
        s.add(in.ints());
        int k = in.ints();
        for (int i = 0; i < k ; i++) {
            s.add(in.ints());
        }
        if (s.size() > s.stream().distinct().count()) {
            out.println("NO");
        } else {
            out.println("YES");
        }
    }
}
