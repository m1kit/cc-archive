package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CMarch {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long[] c = new long[256];
        int n = in.nextInt();
        for (int i= 0; i < n; i++) {
            c[in.next().charAt(0)]++;
        }
        long ans = 0;
        ans += c['M'] * c['A'] * c['R'];
        ans += c['M'] * c['A'] * c['C'];
        ans += c['M'] * c['A'] * c['H'];
        ans += c['M'] * c['R'] * c['C'];
        ans += c['M'] * c['R'] * c['H'];
        ans += c['M'] * c['C'] * c['H'];
        ans += c['A'] * c['R'] * c['C'];
        ans += c['A'] * c['R'] * c['H'];
        ans += c['A'] * c['C'] * c['H'];
        ans += c['R'] * c['C'] * c['H'];
        out.println(ans);
    }
}
