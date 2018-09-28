package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class CColorfulLeaderboard {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] c = new int[8];
        int r = 0;
        for (int i = 0; i < n; i++) {
            int a = in.ints() / 400;
            if (a < 8) {
                c[a]++;
            } else {
                r++;
            }
        }
        long ans = Arrays.stream(c).filter(i -> i > 0).count();
        out.print(Math.max(1, ans));
        out.print(' ');
        out.println(ans + r);
    }
}
