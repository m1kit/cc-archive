package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        StringBuilder sb = new StringBuilder();
        String s = in.next();
        char c = '-';
        int tr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                tr++;
                continue;
            } else if (tr > 0) {
                sb.append(tr);
            }
            c = s.charAt(i);
            sb.append(c);
            tr = 1;
        }
        if (tr > 0) {
            sb.append(tr);
        }
        out.println(sb);
    }
}
