package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class AAirportBus {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints(), c = in.ints(), k = in.ints();
        int[] t = in.ints(n);
        Arrays.sort(t);

        int arrival = t[0];
        int cap = 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (t[i] <= arrival + k && cap < c) {
                cap++;
            } else {
                arrival = t[i];
                cap = 1;
                ans++;
            }
        }
        out.println(ans);
    }
}
