package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;
import java.util.HashSet;

public class EYutori {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), k = in.ints(), c = in.ints();
        char[] s = in.chars();

        int[] left = new int[n], last = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == 'x') {
                if (0 < i) {
                    left[i] = left[i - 1];
                    last[i] = last[i - 1];
                }
            } else {
                left[i] = 1;
                last[i] = i;
                if (0 <= i - c - 1) left[i] += left[i - c - 1];
                if (0 < i && left[i - 1] == left[i]) {
                    last[i] = last[i - 1];
                }
            }
        }
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'o') {
                right[i] = 1;
                if (i + c + 1 < n) right[i] += right[i + c + 1];
            } else {
                right[i] = i + 1 < n ? right[i + 1] : 0;
            }
        }

        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));

        for (int i = 0; i < n; i++) {
            int count;
            if (0 < i) {
                count = left[i - 1];
                int next = Math.max(last[i - 1] + c + 1, i + 1);
                if (next < n) count += right[next];
            } else {
                count = i + 1 < n ? right[i + 1] : 0;
            }
            //System.out.println("i=" + i + " count=" + count);
            if (count < k) out.ans(i + 1).ln();
        }
    }
}
