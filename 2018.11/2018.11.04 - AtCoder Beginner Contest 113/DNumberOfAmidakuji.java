package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DNumberOfAmidakuji {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    private static int h;
    private static int w;
    private static long[][] dp;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        h = in.ints();
        w = in.ints();
        int k = in.ints() - 1;

        List<Integer> patterns = new ArrayList<>();
        outer: for (int i = 0; i < (1 << (w - 1)); i++) {
            for (int j = 0b11; j < (1 << (w - 1)); j = (j << 1)) {
                if ((i & j) == j) {
                    continue outer;
                }
            }
            patterns.add(i);
        }

        // System.out.println(patterns.stream().map(Integer::toBinaryString).collect(Collectors.joining(",")));

        dp = new long[h + 1][w];
        dp[0][k] = 1;
        for (int y = 1; y <= h; y++) {
            for (int x = 0; x < w; x++) {
                for (int p : patterns) {
                    if (x < w - 1 && (p & 1 << x) > 0) {
                        dp[y][x] += dp [y - 1][x + 1];
                    } else if (x > 0 && (p & 1 << (x - 1)) > 0) {
                        dp[y][x] += dp [y - 1][x - 1];
                    } else {
                        dp[y][x] += dp [y - 1][x];
                    }
                    dp[y][x] %= MOD;
                }
            }
        }

        // Arrays.stream(dp).map(Arrays::toString).forEach(System.out::println);
        out.println(dp[h][0]);
    }
}
