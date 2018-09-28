package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int mod = in.nextInt() % 6;
            if (mod == 0) {
                ans += 3;
            } else if (mod == 2) {
                ans += 1;
            } else if (mod == 4 || mod == 5) {
                ans += mod - 3;
            }
        }
        out.println(ans);
    }
}
