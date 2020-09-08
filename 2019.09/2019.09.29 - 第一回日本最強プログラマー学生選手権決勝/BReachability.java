package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.math.linear.BoolMatrix;

import java.util.Arrays;
import java.util.BitSet;

public class BReachability {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        BitSet[] a = new BitSet[n], b = new BitSet[n], c = new BitSet[n];
        for (int i = 0; i < n; i++) {
            a[i] = new BitSet(n);
            char[] row = in.string().toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') a[i].set(j);
            }
        }
        for (int i = 0; i < n; i++) {
            b[i] = new BitSet(n);
            char[] row = in.string().toCharArray();
            for (int j = 0; j < n; j++) {
                if (row[j] == '1') b[i].set(j);
            }
        }
        for (int i = 0; i < n; i++) {
            c[i] = new BitSet(n);
            c[i].set(0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!a[i].get(j)) continue;
                c[j].and(b[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            BitSet reach = new BitSet(n);
            for (int j = 0; j < n; j++) {
                if (!a[i].get(j)) continue;
                reach.or(c[j]);
            }
            if (!reach.equals(b[i])) {
                out.ans(-1).ln();
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(c[i].get(j) ? '1' : '0');
            }
            out.ln();
        }
    }
}
