package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int ax = in.nextInt(), ay = in.nextInt(), bx = in.nextInt(), by = in.nextInt();
        int n = in.nextInt();
        int ans = 0;
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            long cx = x[i], cy = y[i], dx = x[(i + 1) % n], dy = y[(i + 1) % n];
            long ta = (cx - dx) * (ay - cy) + (cy - dy) * (cx - ax);
            long tb = (cx - dx) * (by - cy) + (cy - dy) * (cx - bx);
            long tc = (ax - bx) * (cy - ay) + (ay - by) * (ax - cx);
            long td = (ax - bx) * (dy - ay) + (ay - by) * (ax - dx);
            if (tc * td < 0 && ta * tb < 0) {
                ans++;
            }
        }
        if (ans % 2 == 1) {
            System.exit(1);
        }
        out.println(ans / 2 + 1);
    }
}
