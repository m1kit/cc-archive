package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int max = 0;
        int dest = 0;
        for (int i = 2; i <= n; i++) {
            out.println("? 1 " + i);
            out.flush();
            int dist = in.nextInt();
            if (max < dist) {
                max = dist;
                dest = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i == dest) {
                continue;
            }
            out.println("? " + dest + " " + i);
            out.flush();
            max = Math.max(max, in.nextInt());
        }
        out.println("! " + max);
    }
}
