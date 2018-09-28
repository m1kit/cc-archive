package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CModuloSummation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long ans = -n;
        for (int i = 0; i < n; i++) {
            ans += in.nextInt();
        }
        out.println(ans);
    }
}
