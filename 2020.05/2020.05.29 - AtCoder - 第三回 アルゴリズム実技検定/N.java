package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.InsertionSort;
import dev.mikit.atcoder.lib.sort.IntroSort;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class N {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        int[] a = IntStream.rangeClosed(1, n).toArray();
        TreeSet<Integer> up = new TreeSet<>();
        for (int i = 0; i < q; i++) {
            if (in.ints() == 1) {
                int x = in.ints() - 1;
                in.voids();
                ArrayUtil.swap(a, x, x + 1);
                up.add(x);
                continue;
            }
            int l = in.ints() - 1, r = in.ints() - 1;
            if (r - l <= 100) {
                InsertionSort.sort(a, l, r + 1);
                continue;
            }
            //System.out.println(l + ", " + r + up);
            up.add(r - 1);
            up.add(l);
            while (true) {
                Integer x = up.lower(r);
                if (x == null || x < l) break;
                up.remove(x);
                int t = x;
                while (l <= t && a[t] > a[t + 1]) {
                    ArrayUtil.swap(a, t, t + 1);
                    t--;
                }
                t = x + 1;
                while (t < r && a[t] > a[t + 1]) {
                    ArrayUtil.swap(a, t, t + 1);
                    t++;
                }
                t = x;
                while (l <= t && a[t] > a[t + 1]) {
                    ArrayUtil.swap(a, t, t + 1);
                    t--;
                }
                t = x + 1;
                while (t < r && a[t] > a[t + 1]) {
                    ArrayUtil.swap(a, t, t + 1);
                    t++;
                }
            }
            up.add(r);
        }
        out.ans(a).ln();
    }
}
