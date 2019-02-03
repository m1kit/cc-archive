package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;

public class B2SnukesColoring2ABCEdit {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int w = in.ints(), h = in.ints(), n = in.ints();
        int xmax = w, xmin = 0, ymax = h, ymin = 0;
        for (int i = 0; i < n; i++) {
            int x = in.ints(), y = in.ints(), a = in.ints();
            switch (a) {
                case 1:
                    xmin = Math.max(x, xmin);
                    break;
                case 2:
                    xmax = Math.min(x, xmax);
                    break;
                case 3:
                    ymin = Math.max(y, ymin);
                    break;
                case 4:
                    ymax = Math.min(y, ymax);
                    break;
            }
        }
        if (xmax <= xmin || ymax <= ymin) {
            out.println(0);
        } else {
            out.println((xmax - xmin) * (ymax - ymin));
        }
    }
}
