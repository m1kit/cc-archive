package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class CPaintTheDigits {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int testCases = in.ints();
        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = in.ints();
            char[] dig = in.string().toCharArray();
            boolean[] colored = new boolean[n];
            boolean ok = false;
            mid:
            for (int max = 0; max <= 9; max++) {
                Arrays.fill(colored, false);
                int up = 0, down = n - 1;
                for (int i = 0; i < n; i++) {
                    if (dig[i] - '0' < max) up = i;
                    if (dig[i] - '0' > max && down == n) down = i;
                }
                if (up > down) continue;
                int val = 0;
                for (int i = 0; i < n; i++) {
                    if (dig[i] - '0' < max || (dig[i] - '0' == max && up <= i)) colored[i] = true;
                }
                for (int i = 0; i < n; i++) {
                    if (!colored[i]) continue;
                    if (val > dig[i] - '0') continue mid;
                    val = dig[i] - '0';
                }
                for (int i = 0; i < n; i++) {
                    if (colored[i]) continue;
                    if (val > dig[i] - '0') continue mid;
                    val = dig[i] - '0';
                }
                ok = true;
                break;
            }
            if (!ok) {
                out.ans('-').ln();
            } else {
                for (int i = 0; i < n; i++) {
                    out.print(colored[i] ? '1' : '2');
                }
                out.ln();
            }
        }
    }
}
