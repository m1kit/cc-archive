package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class ATravelRestrictions {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        out.cases(testNumber).ln();
        int n = in.ints();
        boolean[][] mat = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            mat[i][i] = true;
            if (i > 0) mat[i][i - 1] = true;
            if (i < n - 1) mat[i][i + 1] = true;
        }
        char[] incoming = in.chars(), outgoing = in.chars();
        for (int i = 0; i < n; i++) {
            if (incoming[i] == 'N') {
                for (int j = 0; j < n; j++)  mat[j][i] = i == j;
            }
            if (outgoing[i] == 'N') {
                for (int j = 0; j < n; j++)  mat[i][j] = i == j;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mat[j][k] |= mat[j][i] && mat[i][k];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(mat[i][j] ? 'Y' : 'N');
            }
            out.ln();
        }
    }
}
