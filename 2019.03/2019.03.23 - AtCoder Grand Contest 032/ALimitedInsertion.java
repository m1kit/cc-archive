package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ALimitedInsertion {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            b.add(in.ints());
        }
        Stack<Integer> op = new Stack<>();
        outer: for (int i = 0; i < n; i++) {
            for (int j = b.size() - 1; j >= 0; j--) {
                if (b.get(j) == j + 1) {
                    op.push(b.get(j));
                    b.remove(j);
                    continue outer;
                }
            }
            out.ansln(-1);
            return;
        }
        while (!op.isEmpty()) {
            out.ansln(op.pop());
        }
    }
}
