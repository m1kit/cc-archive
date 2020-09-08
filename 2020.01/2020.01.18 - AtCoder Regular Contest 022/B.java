package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B {

    private static final int MAX = 100010;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints();
        int[] a = in.ints(n);
        List<List<Integer>> table = new ArrayList<>();
        for (int i = 0; i < MAX; i++) table.add(new ArrayList<>());
        for (int i = 0; i < n; i++) table.get(a[i]).add(i);
        int[] min = new int[n];
        Arrays.fill(min, n);
        for (int i = 0; i < MAX; i++) {
            int m = table.get(i).size();
            for (int j = 1; j < m; j++) {
                min[table.get(i).get(j - 1)] = table.get(i).get(j);
            }
        }
        for (int i = n - 2; i >= 0; i--) min[i] = Math.min(min[i], min[i + 1]);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, min[i] - i);
        }
        out.ans(ans).ln();
    }
}
