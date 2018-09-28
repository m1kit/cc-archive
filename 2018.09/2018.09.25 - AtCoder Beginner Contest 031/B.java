package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class B {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int l = in.ints(), h = in.ints(), n = in.ints();
        for (int i = 0; i < n; i++) {
            int a = in.ints();
            if (a < l) {
                out.println(l - a);
            } else if (h < a) {
                out.println(-1);
            } else {
                out.println(0);
            }
        }
    }
}
