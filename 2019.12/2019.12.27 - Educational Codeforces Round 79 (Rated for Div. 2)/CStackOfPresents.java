package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.Set;

public class CStackOfPresents {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints(), m = in.ints(), top = 0;
            int[] a = in.ints(n), b = in.ints(m);
            long ans = 0;
            Set<Integer> above = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (above.contains(b[i])) {
                    ans++;
                    above.remove(b[i]);
                    continue;
                }
                while (!above.contains(b[i])) above.add(a[top++]);
                above.remove(b[i]);
                ans += above.size() * 2 + 1;
            }
            out.ans(ans).ln();
        }
    }
}
