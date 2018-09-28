package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BAcrostic {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int w = in.nextInt();
        for (int i = 0; i < s.length(); i += w) {
            out.print(s.charAt(i));
        }
        out.println();
    }
}
