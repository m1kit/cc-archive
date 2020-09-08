package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class NestingDepth {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            out.cases(testCase);
            char[] s = in.chars();
            int n = s.length;
            StringBuilder ans = new StringBuilder();
            int d = 0;
            for (int i = 0; i < n; i++) {
                s[i] -= '0';
                while (d < s[i]) {
                    d++;
                    out.print('(');
                }
                while (d > s[i]) {
                    d--;
                    out.print(')');
                }
                out.print((char) (s[i] + '0'));
            }
            while (d-- > 0) out.print(')');
            out.ln();
        }
    }
}
