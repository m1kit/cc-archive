package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.TreeSet;

public class CEveryoneIsAWinner {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            TreeSet<Integer> ans = new TreeSet<>();
            ans.add(0);
            for (int i = 1; i * i <= n; i++) {
                ans.add(n / i);
                ans.add(n / (n / i));
            }
            out.ans(ans.size()).ln();
            for (int x : ans) out.ans(x);
            out.ln();
        }
    }
}
