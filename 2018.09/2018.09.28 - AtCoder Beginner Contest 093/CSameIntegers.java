package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class CSameIntegers {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] n = in.ints(3);
        Arrays.sort(n);
        int x = (n[1] - n[0] + 1) / 2;
        n[0] += x * 2;
        int y = n[2] - n[0];
        n[0] += y;
        n[1] += y;
        out.println(x + y + (n[1] == n[2] ? 0 : 2));
    }
}
