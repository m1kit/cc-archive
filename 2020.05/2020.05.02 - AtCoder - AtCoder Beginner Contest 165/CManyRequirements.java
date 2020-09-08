package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class CManyRequirements {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        // out.setCaseLabel(LightWriter.CaseLabel.NONE);
        int n = in.ints(), m = in.ints(), q = in.ints();
        int[] a = new int[q], b = new int[q], c = new int[q], d = new int[q];
        in.ints(a, b, c, d);
        ToIntFunction<int[]> callback = arr -> {
            int ans = 0;
            for (int i = 0; i < q; i++) {
                if (arr[b[i] - 1] - arr[a[i] - 1] == c[i]) ans += d[i];
            }
            return ans;
        };
        out.ans(dfs(n, m, new int[n], 0, callback)).ln();
    }

    private static int dfs(int n, int m, int[] a, int i, ToIntFunction<int[]> callback) {
        if (i == n) {
            return callback.applyAsInt(a);
        }
        int max = 0;
        for (int j = i == 0 ? 1 : a[i - 1]; j <= m; j++) {
            a[i] = j;
            max = Math.max(max, dfs(n, m, a, i + 1, callback));
        }
        return max;
    }
}
