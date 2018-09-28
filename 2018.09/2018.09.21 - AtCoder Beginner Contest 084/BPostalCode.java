package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BPostalCode {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        String s = in.next();
        for (int i = 0; i < s.length(); i ++) {
            if (i == a) {
                if (s.charAt(i) != '-') {
                    out.println("No");
                    return;
                }
            } else {
                if (!Character.isDigit(s.charAt(i))) {
                    out.println("No");
                    return;
                }
            }
        }
        out.println("Yes");
    }
}
