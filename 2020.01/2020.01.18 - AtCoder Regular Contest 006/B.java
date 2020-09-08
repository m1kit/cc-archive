package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.util.ArrayUtil;

import java.util.Arrays;
import java.util.stream.IntStream;

public class B {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), l = in.ints();
        int[] a = IntStream.rangeClosed(0, n).toArray();
        for (int i = 0; i < l; i++) {
            char[] s = in.nextLine().toCharArray();
            for (int j = 0; j < n - 1; j++) {
                if (s[2 * j + 1] == '-') ArrayUtil.swap(a, j, j + 1);
            }
        }
        char[] s = in.nextLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (s[2 * i] == 'o') out.ans(a[i] + 1).ln();
        }
    }
}
