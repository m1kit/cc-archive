package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DCake123 {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int x = in.ints(), y = in.ints(), z = in.ints(), k = in.ints();
        long[] a = in.longs(x), b = in.longs(y), c = in.longs(z);
        IntroSort.sort(a); ArrayUtil.reverse(a, 0, x);
        IntroSort.sort(b); ArrayUtil.reverse(b, 0, y);
        IntroSort.sort(c); ArrayUtil.reverse(c, 0, z);
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < Math.min(y, k / (i + 1)); j++) {
                for (int l = 0; l < Math.min(z, k / (i + 1) / (j + 1)); l++) {
                    ans.add(a[i] + b[j] + c[l]);
                }
            }
        }
        ans.sort(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            out.ansln(ans.get(i));
        }
    }
}
