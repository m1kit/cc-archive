package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w= in.nextInt(), n= in.nextInt(), m= in.nextInt();
        boolean[][] p = new boolean[h][];
        for (int i = 0; i < h; i++) {
            p[i] = new boolean[w];
        }
        for (int y = 0; y < n; y++) {
            String r = in.next();
            for (int x = 0; x < m; x++) {
                char c = r.charAt(x);
                if (c == '#') {

                }
            }
        }
    }
}
