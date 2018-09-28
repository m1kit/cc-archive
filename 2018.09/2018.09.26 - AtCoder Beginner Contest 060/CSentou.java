package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;

public class CSentou {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), t = in.ints();
        int ans = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            int s = in.ints();
            if (s < last) {
                s += t;
                ans += s - last;
                last = s;
            } else {
                ans += t;
                last = s + t;
            }
        }
        out.println(ans);
    }
}
