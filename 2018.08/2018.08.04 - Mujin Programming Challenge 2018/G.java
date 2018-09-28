package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class G {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = 1000000002, r = 1000000000;
        frac(n);
        npr(n);
        long ncr = ncr(r);
        out.println(ncr);
    }

    private static final long MOD = 998244353;

    long ncr(int r) {
        return (npr[r] * pow(frac[r], MOD - 2)) % MOD;
    }

    long[] frac;

    void frac(int n) {
        frac = new long[n];
        frac[0] = 1;
        for (int i = 1; i < n; i++) {
            frac[i] = (frac[i - 1] * i) % MOD;
        }
    }

    long[] npr;

    void npr(int n) {
        npr = new long[n];
        npr[0] = 1;
        for (int i = 1; i < n; i++) {
            npr[i] = (npr[i - 1] * (n - i + 1)) % MOD;
        }
    }

    long pow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long z = pow(x, y/2);
            return (z * z) % MOD;
        } else {
            return (x % MOD) * pow(x, y - 1) % MOD;
        }
    }
}
