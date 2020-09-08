package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Comparator;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), p = in.ints();
        Snack[] snacks = new Snack[n];
        for (int i = 0; i < n; i++) snacks[i] = new Snack(in.ints(), in.ints());
        IntroSort.sort(snacks, Comparator.comparing(snack -> -snack.price));
        int[][] dp = new int[n + 1][p + 1];
        for (int i = 0; i < n; i++) {
            System.arraycopy(dp[i], 0, dp[i + 1], 0, p + 1);
            for (int j = 0; j <= p - snacks[i].price; j++) {
                dp[i + 1][j + snacks[i].price] = Math.max(dp[i + 1][j + snacks[i].price], dp[i][j] + snacks[i].goodness);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= p; j++) {
                ans = Math.max(ans, snacks[i].goodness + dp[i][j]);
            }
        }
        out.ans(ans).ln();
    }

    private static class Snack {
        int price, goodness;

        public Snack(int price, int goodness) {
            this.price = price;
            this.goodness = goodness;
        }
    }
}
