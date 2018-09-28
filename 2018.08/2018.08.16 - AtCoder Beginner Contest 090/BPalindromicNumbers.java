package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BPalindromicNumbers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt();
        int ans = 0;
        for (int i = a; i <= b; i++) {
            if (i / 10000 == i % 10 && i / 1000 % 10 == i % 100 / 10) {
                ans++;
            }
        }
        out.println(ans);
    }
}
