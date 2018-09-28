package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ETrBBnsformBBtion {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next(), t = in.next();
        int[] cs = new int[s.length() + 1], ct = new int[t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            cs[i] = cs[i - 1] + s.charAt(i - 1) - 'A' + 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            ct[i] = ct[i - 1] + t.charAt(i - 1) - 'A' + 1;
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), d = in.nextInt();
            if ((cs[b] - cs[a - 1]) % 3 == (ct[d] - ct[c - 1]) % 3) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
}
