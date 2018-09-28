package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] m = new int[6];
        for (int i = 0; i < 6; i++) {
            m[i] = (n / 5 + i) % 6 + 1;
        }
        for (int i = 0; i < n % 5; i++) {
            m[i] ^= m[i + 1];
            m[i + 1] ^= m[i];
            m[i] ^= m[i + 1];
        }
        for (int i : m) {
            out.print(i);
        }
        out.println();
    }
}
