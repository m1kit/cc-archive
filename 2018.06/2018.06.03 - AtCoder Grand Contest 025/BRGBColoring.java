package jp.llv.atcoder;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class BRGBColoring {

    static final int MOD = 998244353;
    int n;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        n = in.nextInt();
        long a = in.nextInt(), b = in.nextInt();
        long k = in.nextLong();
        cache();
        long count = 0;
        int y = n;
        for (int x = 0; x <= n; x++) {
            long val;
            while ((val = (a * x) + (b * y)) > k) {
                y--;
            }
            if (y < 0) {
                break;
            }
            if (val != k) {
                continue;
            }
            count += (nCk(x) * nCk(y) % MOD);
        }
        out.println(count % MOD);
    }

    long modPow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y == 1) {
            return x;
        } else if (y % 2 == 0) {
            long z = modPow(x, y / 2);
            return z * z % MOD;
        } else {
            return (modPow(x, y - 1) * x) % MOD;
        }
    }

    long nCk(int k) {
        return (ac[k] * modPow(bc[k], MOD - 2) % MOD) % MOD;
    }

    long[] ac;
    long[] bc;

    void cache() {
        ac = new long[n + 1];
        ac[0] = 1;
        for (int i = 0; i < n; i++) {
            ac[i + 1] = ac[i] * (n - i);
            ac[i + 1] %= MOD;
        }
        bc = new long[n + 1];
        bc[0] = 1;
        bc[1] = 1;
        for (int i = 2; i <= n; i++) {
            bc[i] = bc[i - 1] * i;
            bc[i] %= MOD;
        }
    }
}
