package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class CBugged {

    private static int ans = 0;
    private static final boolean[][] dp = new boolean[10001][101];
    private static int[] s;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        s = IntStream.range(0, in.nextInt()).map(i -> in.nextInt()).toArray();
        calc(0, 0);
        out.println(ans);
    }

    private static void calc(int sum, int index) {
        if (dp[sum][index]) {
            return;
        }
        dp[sum][index] = true;
        if (index == s.length) {
            if (sum % 10 > 0) {
                ans = Math.max(ans, sum);
            }
            return;
        }
        calc(sum, index + 1);
        calc(sum + s[index], index + 1);
    }
}
