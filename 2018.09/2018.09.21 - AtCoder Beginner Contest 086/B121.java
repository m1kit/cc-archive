package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B121 {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int m = Integer.parseInt(in.next() + in.next());
        for (int i = 1; i < 10000; i++) {
            if (m == i * i) {
                out.println("Yes");
                return;
            }
        }
        out.println("No");
    }
}
