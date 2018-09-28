package jp.llv.atcoder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    int n;
    int m;
    int p;
    int q;
    int r;
    int[] x;
    int[] y;
    int[] z;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        p = in.nextInt();
        q = in.nextInt();
        r = in.nextInt();
        x = new int[r];
        y = new int[r];
        z = new int[r];
        for (int i = 0; i < r; i++) {
            x[i] = in.nextInt() - 1;
            y[i] = in.nextInt() - 1;
            z[i] = in.nextInt();
        }
        out.println(calc(new int[p], 0, 0));
    }

    private int calc(int[] girls, int i, int f) {
        if (i == p) {
            // ==貪欲法==
            int[] s = new int[m];
            for (int j = 0; j < r; j++) {
                if (Arrays.binarySearch(girls, x[j]) >= 0) {
                    s[y[j]] += z[j];
                }
            }
            Arrays.sort(s);
            int ans = 0;
            for (int j = m - q; j < m; j++) {
                ans += s[j];
            }
            return ans;
            // ==おわり==
        }
        int ans = 0;
        for (int j = f; j < n; j++) {
            girls[i] = j;
            ans = Math.max(ans, calc(girls, i + 1, j + 1));
        }
        return ans;
    }
}
