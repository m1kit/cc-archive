package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;
import dev.mikit.atcoder.lib.structure.array.PersistentIntArray;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class CSnukeTheWizard {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        int n = in.ints(), q = in.ints();
        String s = in.string();
        char[] t = new char[q], d = new char[q];
        for (int i = 0; i < q; i++) {
            t[i] = in.string().charAt(0);
            d[i] = in.string().charAt(0);
        }

        IntUnaryOperator move = x -> {
            int cur = x;
            for (int i = 0; i < q; i++) {
                if (cur >= n) {
                    return n;
                } else if (cur < 0) {
                    return -1;
                }
                if (s.charAt(cur) == t[i]) {
                    if (d[i] == 'L') {
                        cur--;
                    } else {
                        cur++;
                    }
                }
            }
            return cur;
        };

        int rangeMin, rangeMax;
        {
            int min = -1, max = n;
            while (max - min > 1) {
                int mid = (min + max) / 2;
                if (n <= move.applyAsInt(mid)) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            rangeMax = min;
        }

        {
            int min = -1, max = n;
            while (max - min > 1) {
                int mid = (min + max + 1) / 2;
                if (move.applyAsInt(mid) < 0) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            rangeMin = max;
        }


        //System.out.println("(" + l + ", " + r + ")");
        //System.out.println("[" + rangeMin + ", " + rangeMax + "]");

        out.ansln(Math.min(Math.max(0, rangeMax - rangeMin + 1), n));
    }
}
