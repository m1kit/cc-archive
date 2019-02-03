package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        long v = 1;
        for (int i = 0; i < 3; i++) {
            v *= in.longs();
            v %= MOD;
        }
        out.println(v);
    }
}
