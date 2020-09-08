package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSeatingOnBus {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints(), m = in.ints();
        Queue<Integer> window = new ArrayDeque<>(2 * n), nonWindow = new ArrayDeque<>(2 * n);
        for (int i = 1; i <= m; i++) {
            if (window.size() < 2 * n) {
                window.offer(i);
            } else {
                nonWindow.offer(i);
            }
        }
        for (int i = 0; i < 2 * n; i++) {
            if (!nonWindow.isEmpty()) {
                out.ans(nonWindow.poll());
            }
            if (!window.isEmpty()) {
                out.ans(window.poll());
            }
        }
        out.ln();
    }
}
