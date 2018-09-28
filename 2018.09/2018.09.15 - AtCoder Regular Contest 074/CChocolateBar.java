package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CChocolateBar {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long h = in.nextInt(), w = in.nextInt();

        if (h * w % 3 == 0) {
            out.println(0);
            return;
        }

        long ans = Math.min(h, w);
        for (int x = 0; x <= w; x++) {
            long s1 = (w - x) * h;
            long s2 = x * (h / 2);
            long s3 = x * ((h + 1) / 2);
            ans = Math.min(ans, Math.max(s1, s3) - Math.min(s1, s2));
        }
        for (int y = 0; y <= h; y++) {
            long s1 = w * (h - y);
            long s2 = (w / 2) * y;
            long s3 = ((w + 1) / 2) * y;
            ans = Math.min(ans, Math.max(s1, s3) - Math.min(s1, s2));
        }
        out.println(ans);
    }
}
