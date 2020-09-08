package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.LinkedList;
import java.util.Queue;

public class EX10205 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = in.ints();
            c[p[i]]++;
        }

        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (c[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int v = q.poll();
            ans[v]++;
            if (v != 0) {
                ans[p[v]] += ans[v];
                if (--c[p[v]] == 0) {
                    q.offer(p[v]);
                }
            }
        }
        out.ansln(ans);
    }
}
