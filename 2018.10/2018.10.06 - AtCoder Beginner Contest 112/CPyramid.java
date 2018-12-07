package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class CPyramid {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] h = new int[n];
        in.ints(x, y, h);
        for (int xt = 0; xt <= 100; xt++) {
            mainloop:
            for (int yt = 0; yt <= 100; yt++) {
                Integer ht = null;
                Queue<Integer> q = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    q.add(i);
                }
                while (!q.isEmpty()) {
                    int i = q.poll();
                    if (h[i] == 0) {
                        if (ht == null) {
                            q.add(i);
                        } else {
                            if (ht - (Math.abs(x[i] - xt) + Math.abs(y[i] - yt)) > 0) {
                                continue mainloop;
                            }
                        }
                    } else if (ht == null) {
                        ht = h[i] + Math.abs(x[i] - xt) + Math.abs(y[i] - yt);
                    } else if (ht != h[i] + Math.abs(x[i] - xt) + Math.abs(y[i] - yt)) {
                        continue mainloop;
                    }
                }
                out.print(xt);
                out.print(' ');
                out.print(yt);
                out.print(' ');
                out.println(ht);
                return;
            }
        }
        throw new RuntimeException("ERR");
    }
}
