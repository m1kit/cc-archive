package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.sort.IntroSort;

import java.util.Arrays;

public class ANauuoAndCards {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] a = in.ints(n), b = in.ints(n);

        // Case 1
        int index = -1;
        boolean lessn = true;
        for (int i = 0; i < n; i++) {
            if (b[i] == 1) {
                index = i;
            } else if (index >= 0 && (i - index + 1) != b[i]) {
                lessn = false;
                break;
            }
        }

        for (int i = 0; i < index; i++) {
            if (b[i] == 0) continue;
            if (n - b[i] + 1 + i + 1 > index) {
                lessn = false;
                break;
            }
        }
        if (lessn && index >= 0) {
            out.ans(index).ln();
            return;
        }

        int max = n;
        for (int i = 0; i < n; i++) {
            if (b[i] != 0) {
                max = Math.max(max, n - b[i] + 1 + i + 1);
            }
            if (a[i] != 0) {
                max = Math.max(max, n - a[i] + 1);
            }
        }
        out.ans(max).ln();
    }
}
