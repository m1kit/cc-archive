package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BGridCompression {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int h = in.nextInt(), w = in.nextInt();
        String[] s = new String[h];
        boolean[] x = new boolean[w];
        Arrays.fill(x, true);
        for (int i = 0; i < h; i++) {
            s[i] = in.next();
            for (int j = 0; j < w; j++) {
                if (s[i].charAt(j) == '#') {
                    x[j] = false;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            if (s[i].indexOf('#') < 0) {
                continue;
            }
            for (int j = 0; j < w; j++) {
                if (!x[j]) {
                    out.print(s[i].charAt(j));
                }
            }
            out.println();
        }
    }
}
