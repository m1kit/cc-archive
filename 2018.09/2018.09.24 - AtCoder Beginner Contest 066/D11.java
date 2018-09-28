package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class D11 {

    private static final String YES = "Yes";
    private static final String NO = "No";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int l = 0, r = n;
        int[] index = new int[n];
        Arrays.fill(index, -1);
        for (int i = 0; i <= n; i++) {
            int a = in.nextInt() - 1;
            if (index[a] >= 0) {
                l = index[a];
                r = i;
                break;
            }
            index[a] = i;
        }

        long[] ans = new long[n + 1];
        frac(n + 1);
        npr(n + 1);
        IntStream.rangeClosed(1, n + 1).forEach(i -> {
            ans[i - 1] = ncr(i);
        });
        System.out.println(l - 1 + n - r);
        npr(l - 1 + n - r);
        IntStream.rangeClosed(1, n + 1).forEach(i -> {
            ans[i - 1] -= ncr(i - 1);
            ans[i - 1] %= MOD;
            ans[i - 1] += MOD;
            ans[i - 1] %= MOD;
            out.println(ans[i - 1]);
        });
    }

    long pow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long z = pow(x, y / 2);
            return (z * z) % MOD;
        } else {
            return (x % MOD) * pow(x, y - 1) % MOD;
        }
    }

    long ncr(int r) {
        if (r < 0 || npr.length <= r) {
            return 0;
        }
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
}
