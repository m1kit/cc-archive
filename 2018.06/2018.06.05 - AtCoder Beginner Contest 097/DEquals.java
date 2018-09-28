package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class DEquals {

    int[] g;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] p = new int[n + 1];
        g = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = in.nextInt();
            g[i] = i;
        }
        for (int i = 0; i < m; i++) {
            g[group(in.nextInt())] = g[in.nextInt()];
        }
        int c = 0;
        for (int i = 1; i <= n; i++) {
            int q = p[i];
            if (group(i) == group(q)) {
                c++;
            }
        }
        out.println(c);
    }

    int group(int i) {
        int j = g[i];
        return i == j ? j : (g[i] = group(j));
    }
}
