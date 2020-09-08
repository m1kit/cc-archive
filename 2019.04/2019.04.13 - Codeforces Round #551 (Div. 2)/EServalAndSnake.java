package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

import java.util.Arrays;

public class EServalAndSnake {

    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        // out.setBoolLabel(LightWriter.BoolLabel.YES_NO_FIRST_UP);
        int n = in.ints();
        int[] cntv = new int[n], cnth = new int[n];
        for (int i = 0; i < n; i++) {
            out.ans('?').ans(1).ans(i + 1).ans(n).ans(i + 1).ln().flush();
            cntv[i] = in.ints() % 2;
            out.ans('?').ans(i + 1).ans(1).ans(i + 1).ans(n).ln().flush();
            cnth[i] = in.ints() % 2;
        }
        int v = 0, h = 0;
        int[] y = new int[2], x = new int[2];
        for (int i = 0; i < n; i++) {
            if (cntv[i] == 1) {
                y[v] = i;
                v++;
            }
            if (cnth[i] == 1) {
                x[h] = i;
                h++;
            }
        }

        if ((v + h) % 2 == 1 || (v == 0 && h == 0)) {
            throw new RuntimeException();
        } else if (v == 2 && h == 2) {
            out.ans('?').ans(1).ans(1).ans(x[0] + 1).ans(y[0] + 1).ln().flush();
            if (in.ints() % 2 == 1) {
                out.ans('!').ans(x[0] + 1).ans(y[0] + 1).ans(x[1] + 1).ans(y[1] + 1);
            } else {
                out.ans('!').ans(x[1] + 1).ans(y[0] + 1).ans(x[0] + 1).ans(y[1] + 1);
            }
        } else if (h == 0) {
            int min = -1, max = n - 1;
            while (max - min > 1) {
                int mid = (max + min + 1) / 2;
                out.ans('?').ans(1).ans(y[0] + 1).ans(mid + 1).ans(y[0] + 1).ln().flush();
                if (in.ints() % 2 == 1) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            out.ans('!').ans(max + 1).ans(y[0] + 1).ans(max + 1).ans(y[1] + 1);
        } else {
            int min = -1, max = n - 1;
            while (max - min > 1) {
                int mid = (max + min + 1) / 2;
                out.ans('?').ans(x[0] + 1).ans(1).ans(x[0] + 1).ans(mid + 1).ln().flush();
                if (in.ints() % 2 == 1) {
                    max = mid;
                } else {
                    min = mid;
                }
            }
            out.ans('!').ans(x[0] + 1).ans(max + 1).ans(x[1] + 1).ans(max + 1);
        }
        out.ln().flush();
    }
}
