package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Stack;

public class FSugoroku {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), m = in.ints();
        char[] s = in.string().toCharArray();
        Stack<Integer> ans = new Stack<>();
        int now = n;
        while (now > 0) {
            int k = Math.min(m, now);
            while (s[now - k] == '1') k--;
            if (k == 0) {
                out.ans(-1).ln();
                return;
            }
            now -= k;
            ans.push(k);
        }
        while (!ans.isEmpty()) {
            out.ans(ans.pop());
        }
        out.ln();
    }
}
