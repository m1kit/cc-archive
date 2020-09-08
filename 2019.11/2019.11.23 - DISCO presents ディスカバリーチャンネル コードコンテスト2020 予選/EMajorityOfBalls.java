package dev.mikit.atcoder;

import dev.mikit.atcoder.lib.io.LightScanner;
import dev.mikit.atcoder.lib.io.LightWriter;
import dev.mikit.atcoder.lib.debug.Debug;

public class EMajorityOfBalls {

    private static  LightWriter out;
    private static  LightScanner in;

    public void solve(int testNumber, LightScanner in, LightWriter out) {
        out.enableAutoFlush();

        int n = in.ints();

        char init = 0;
        out.ans('?');
        for (int i = 0; i < n; i++)  out.ans(i + 1);
        out.ln().flush();
        init = in.string().charAt(0);

        int min = 0, max = n;
        while (max - min > 1) {
            int mid = (min + max) / 2;
            out.ans('?');
            for (int i = 0; i < n; i++)  out.ans(mid + i + 1);
            out.ln().flush();
            if (in.string().charAt(0) == init) min = mid;
            else max = mid;
        }

        char[] res = new char[2 * n];
        res[min] = init;


        int pivot = -1;
        for (int i = 0; i < 2 * n; i++) {
            if (min <= i && i < min + n) continue;
            out.ans('?').ans(i + 1);
            for (int j = 1; j < n; j++) out.ans(min + j + 1);
            out.ln().flush();
            res[i] = in.string().charAt(0);
            if (res[i] != init) pivot = i;
        }


        for (int i = min + 1; i < min + n; i++) {
            out.ans('?').ans(i + 1);
            for (int j = 0; j < 2 * n; j++) {
                if ((min <= j && j < min + n) || j == pivot) continue;
                out.ans(j + 1);
            }
            out.ln().flush();
            res[i] = in.string().charAt(0);
        }

        out.ans('!').ans(String.valueOf(res)).ln().flush();
    }

}
