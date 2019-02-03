package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.util.ArrayUtil;

public class FLCS {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static String s, t;
    private static int[][] dp;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        s = in.string();
        t = in.string();
        dp = new int[s.length() + 1][t.length() + 1];
        ArrayUtil.fill(dp, -1);
        lcs(s.length(), t.length());

        StringBuilder sb = new StringBuilder();
        int i = s.length(), j = t.length();
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) != t.charAt(j - 1)) {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            } else {
                sb.append(s.charAt(i - 1)); // or s2.charAt(j-1)
                i--;
                j--;
            }
        }
        out.ans(sb.reverse()).ln();
    }

    public static int lcs(int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        } else if (dp[i][j] >= 0) {
            return dp[i][j];
        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
            return dp[i][j] = lcs(i - 1, j - 1) + 1;
        } else {
            return dp[i][j] = Math.max(lcs(i, j - 1), lcs(i - 1, j));
        }
    }
}
