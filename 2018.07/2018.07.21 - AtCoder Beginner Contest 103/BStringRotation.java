package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BStringRotation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next(), t = in.next();
        for (int i = 0; i < s.length(); i++) {
            String u = s.substring(i, s.length()) + s.substring(0, i);
            if (t.equals(u)) {
                out.println("Yes");
                return;
            }
        }
        out.println("No");
    }
}
