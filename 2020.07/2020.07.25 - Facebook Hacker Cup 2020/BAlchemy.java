package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class BAlchemy {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        out.cases(testNumber);
        int cntA = 0, cntB = 0;
        boolean conA = false, conB = false;
        int n = in.ints();
        char[] s = in.chars();
        for (int i = 1; i < n; i++) {
            if (s[i - 1] == s[i]) {
                if (s[i] == 'A') conA = true;
                else conB = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] == 'A') cntA++;
            else cntB++;
        }
        if (Math.min(cntA, cntB) < n / 2) {
            out.print('N').ln();
        } else if (n <= 7) {
            out.print('Y').ln();
        } else if (conA == conB) {
            out.print('Y').ln();
        } else {
            out.print('N').ln();
        }
    }
}
