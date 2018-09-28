package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class DWeLoveABC {

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        pow = new long[s.length()];
        int[] a = new int[s.length()];
        int[] c = new int[s.length()];
        int[] q = new int[s.length()];
        a[0] = s.charAt(0) == 'A' ? 1 : 0;
        c[0] = s.charAt(0) == 'C' ? 1 : 0;
        q[0] = s.charAt(0) == '?' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            a[i] = a[i - 1] + s.charAt(i) == 'A' ? 1 : 0;
            c[i] = c[i - 1] + s.charAt(i) == 'C' ? 1 : 0;
            q[i] = q[i - 1] + s.charAt(i) == '?' ? 1 : 0;
        }
        int allC = c[s.length() - 1];
        int allQ = q[s.length() - 1];

        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                int aLeft = a[i];
                int qLeft = q[i];
                int cRight = allC - c[i];
                int qRight = allQ - q[i];
                ans += aLeft * cRight * pow(allQ);
                ans += qLeft * cRight * pow(allQ - 1);
                ans += aLeft * qRight * pow(allQ - 1);
                ans += qLeft * qRight * pow(allQ - 2);
                ans %= MOD;
            } else if (s.charAt(i) == '?') {
                int aLeft = a[i];
                int qLeft = q[i] - 1;
                int cRight = allC - c[i];
                int qRight = allQ - q[i];
                ans += aLeft * cRight * pow(allQ - 1);
                ans += qLeft * cRight * pow(allQ - 2);
                ans += aLeft * qRight * pow(allQ - 2);
                ans += qLeft * qRight * pow(allQ - 3);
                ans %= MOD;
            }
        }
        out.println(ans);
    }

    private static final long MOD = (int) 1e9 + 7;
    private long[] pow;

    long pow(int y) {
        if (y < 0) {
            return 0; // 1より小さいので実質0
        } else if (y == 0) {
            return 1;
        } else if (pow[y] != 0) {
            return pow[y];
        } else if (y % 2 == 0) {
            long z = pow(y / 2);
            return pow[y] = (z * z) % MOD;
        } else {
            return pow[y] = (3 % MOD) * pow(y - 1) % MOD;
        }
    }
}
