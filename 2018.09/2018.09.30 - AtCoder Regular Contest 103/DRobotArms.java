package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DRobotArms {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        long[] x = new long[n];
        long[] y = new long[n];
        in.longs(x, y);

        boolean even = isEven(x[0] + y[0]);
        if (IntStream.range(1, n).anyMatch(i -> even ^ isEven(x[i] + y[i]))) {
            out.println(-1);
            return;
        }

        long[] pows = new long[35];
        pows[pows.length - 1] = 1;
        for (int i = pows.length - 2; i >= 0; i--) {
            pows[i] = pows[i + 1] * 2L;
        }

        if (even) {
            out.println(pows.length + 1);
            out.print("1 ");
        } else {
            out.println(pows.length);
        }
        out.println(Arrays.stream(pows).mapToObj(Long::toString).collect(Collectors.joining(" ")));

        for (int i = 0; i < n; i++) {
            if (even) {
                out.print('R');
                x[i]--;
            }
            for (int j = 0; j < pows.length; j++) {
                if (x[i] + y[i] > 0) {
                    if (x[i] - y[i] > 0) {
                        out.print('R');
                        x[i] -= pows[j];
                    } else {
                        out.print('U');
                        y[i] -= pows[j];
                    }
                } else {
                    if (x[i] - y[i] > 0) {
                        out.print('D');
                        y[i] += pows[j];
                    } else {
                        out.print('L');
                        x[i] += pows[j];
                    }
                }
            }
            if (x[i] > 0 || y[i] > 0) {
                System.out.println("WARN: " + x[i] + "," + y[i] + " REMAINS");
            }
            out.println();
        }
    }

    private static boolean isEven(long v) {
        return ((v % 2) + 2) % 2 == 0;
    }
}
