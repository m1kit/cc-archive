package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class DWideFlip {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;
    private static final int[] MVX = {0, 1, 0, -1, 0, 1, 1, -1, -1};
    private static final int[] MVY = {0, 0, 1, 0, -1, 1, -1, -1, 1};

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int[] s = in.string().chars().map(i -> i - '0').toArray();
        if (Arrays.stream(s).allMatch(i -> i == 1)) {
            out.println(s.length);
        } else if (Arrays.stream(s).allMatch(i -> i == 0)) {
            out.println(s.length);
        } else {
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < s.length; i++) {
                if (s[i - 1] != s[i]) {
                    ans = Math.min(ans, Math.max(i, s.length - i));
                }
            }
            out.println(ans);
        }
    }
}
