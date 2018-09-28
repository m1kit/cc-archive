package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BAcCepted {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        if (s.charAt(0) != 'A' || Character.isUpperCase(s.charAt(1)) || Character.isUpperCase(s.charAt(s.length() - 1))) {
            out.println("WA");
            return;
        }
        int count = 0;
        for (int i = 2; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'C') {
                count++;
            } else if (Character.isUpperCase(s.charAt(i))) {
                out.println("WA");
                return;
            }
        }
        out.println(count == 1 ? "AC" : "WA");
    }
}
