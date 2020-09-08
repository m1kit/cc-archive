package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;

public class CSuccessiveSubtraction {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n);
        int maxIndex = 0, minIndex = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
            if (a[i] < a[minIndex]) {
                minIndex = i;
            }
        }
        List<Op> ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == maxIndex || i == minIndex) continue;
            if (a[i] < 0) {
                ops.add(new Op(a[maxIndex], a[i]));
                a[maxIndex] -= a[i];
            } else {
                ops.add(new Op(a[minIndex], a[i]));
                a[minIndex] -= a[i];
            }
        }
        ops.add(new Op(a[maxIndex], a[minIndex]));
        a[maxIndex] -= a[minIndex];
        out.ans(a[maxIndex]).ln();
        for (Op op : ops) {
            out.ans(op.x).ans(op.y).ln();
        }
    }

    private static class Op {
        int x, y;

        Op(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
