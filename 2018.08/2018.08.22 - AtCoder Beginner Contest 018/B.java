package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int l = in.nextInt(), r = in.nextInt();
            s = s.substring(0, l - 1) + new StringBuilder(s.substring(l - 1, r)).reverse() + s.substring(r);
        }
        out.println(s);
    }
}
