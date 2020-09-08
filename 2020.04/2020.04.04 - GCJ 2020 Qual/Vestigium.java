package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.HashSet;
import java.util.stream.IntStream;

public class Vestigium {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.setCaseLabel(LightWriter.CaseLabel.GCJ);
        int testCases = in.ints();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = in.ints();
            int[][] a = in.ints(n, n);
            int diag = IntStream.range(0, n).map(i -> a[i][i]).sum(), r = 0, c = 0;
            HashSet<Integer> t = new HashSet<>();
            for (int i = 0; i < n; i++) {
                t.clear();
                for (int j = 0; j < n; j++) t.add(a[i][j]);
                if (t.size() != n) r++;
                t.clear();
                for (int j = 0; j < n; j++) t.add(a[j][i]);
                if (t.size() != n) c++;
            }
            out.cases(testCase).ans(diag).ans(r).ans(c).ln();
        }
    }
}
