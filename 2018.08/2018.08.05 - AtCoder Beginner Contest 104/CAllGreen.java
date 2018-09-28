package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CAllGreen {
    private int d;
    private int[] c;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        d = in.nextInt();
        int g = in.nextInt();
        int[] p = new int[d];
        c = new int[d];
        for (int i = 0; i < d; i++) {
            p[i] = in.nextInt();
            c[i] = in.nextInt();
        }
        out.println(solve(g, p));
    }

    private int solve(int g, int[] p) {
        if (g <= 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < d; i++) {
            if (p[i] == 0) {
                continue;
            }
            int score = (i + 1) * 100;
            if (p[i] * score >= g) {
                min = Math.min(min, (g + score - 1) / score);
                //System.out.println(i+"-[a]->"+(g + score - 1) / score);
                continue;
            }
            if (p[i] * score + c[i] >= g) {
                min = Math.min(min, p[i]);
                //System.out.println(i+"-[b]->"+p[i]);
                continue;
            }
            int[] q = new int[d];
            System.arraycopy(p, 0, q, 0, d);
            q[i] = 0;
            int s = solve(g - c[i] - (p[i] * score), q) + p[i];
            //System.out.println(i+"-[c]->"+s);
            min = Math.min(min, s);
        }
        return min;
    }
}
