package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.List;

public class A {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] s = in.string(n);
        int ans = 0;
        List<String> words = Arrays.asList("TAKAHASHIKUN", "Takahashikun", "takahashikun", "TAKAHASHIKUN.", "Takahashikun.", "takahashikun.");
        for (int i = 0; i < n; i++) {
            if (words.contains(s[i])) {
                ans++;
            }
        }
        out.ansln(ans);
    }
}
