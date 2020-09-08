package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.ArrayList;
import java.util.List;

public class CMakeARectangle {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        Debug.enable("src");
        int n = in.ints();
        long[] a = in.longs(n);

        IntroSort.sort(a);
        List<Long> ans = new ArrayList<>();
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] == a[i + 1]) {
                ans.add(a[i]);
                i--;
            }
        }
        if (ans.size() < 2) {
            out.ansln(0);
        } else {
            out.ansln(ans.get(0) * ans.get(1));
        }
    }
}
