package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CGreenBin {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        String[] s = in.string(n);
        for (int i = 0; i < n; i++) {
            char[] arr = s[i].toCharArray();
            Arrays.sort(arr);
            s[i] = String.valueOf(arr);
        }
        Arrays.sort(s);
        int count = 1;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (s[i - 1].equals(s[i])) {
                ans += count;
                count++;
            } else {
                count = 1;
            }
        }
        out.ans(ans).ln();
    }
}
