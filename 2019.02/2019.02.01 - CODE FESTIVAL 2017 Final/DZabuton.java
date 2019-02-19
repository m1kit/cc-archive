package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import jp.llv.atcoder.lib.io.LightWriter;
import jp.llv.atcoder.lib.debug.Debug;
import jp.llv.atcoder.lib.geo.Vec2l;
import jp.llv.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DZabuton {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.autoEnable();
        int n = in.ints();
        Vec2l[] participants = new Vec2l[n];
        for (int i = 0; i < n; i++) {
            participants[i] = new Vec2l(in.longs(), in.longs());
        }
        Arrays.sort(participants, Comparator.comparing(participant -> participant.x + participant.y));
        long[][] dp = new long[2][n + 1];
        ArrayUtil.fill(dp, Long.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[0][j] <= participants[i].x) {
                    dp[1][j + 1] = Math.min(dp[1][j + 1], dp[0][j] + participants[i].y); // 取る
                }
                dp[1][j] = Math.min(dp[1][j], dp[0][j]); // 取らない
            }
            dp[1][n] = Math.min(dp[0][n], dp[1][n]); // 取らない

            long[] tmp = dp[0];
            Arrays.fill(tmp, Long.MAX_VALUE);
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        for (int i = n; i>= 0; i--) {
            if (dp[0][i] < Long.MAX_VALUE) {
                out.ans(i).ln();
                return;
            }
        }
    }
}
