package jp.llv.atcoder;

import jp.llv.atcoder.lib.io.LightScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.IntStream;

public class D756 {

    private static final String YES = "YES";
    private static final String NO = "NO";
    private static final int MOD = (int) 1e9 + 7;

    public void solve(int testNumber, LightScanner in, PrintWriter out) {
        int n = in.ints();
        int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
        int[] factors = new int[primes.length];
        for (int i = 0; i < primes.length; i++) {
            for (int j = 2; j <= n; j++) {
                int t = j;
                while (t % primes[i] == 0) {
                    t /= primes[i];
                    factors[i]++;
                }
            }
        }

        long ans = 0;

        // 75=5*5*3
        for (int x = 0; x < primes.length; x++) {
            if (factors[x] < 4) {
                continue;
            }
            for (int y = 0; y < x; y++) {
                if (factors[y] < 4) {
                    continue;
                }
                for (int z = 0; z < primes.length; z++) {
                    if (factors[z] < 2 || x == z || y == z) {
                        continue;
                    }
                    ans++;
                }
            }
        }

        // 75=25*3
        for (int x = 0; x < primes.length; x++) {
            if (factors[x] < 24) {
                continue;
            }
            for (int y = 0; y < primes.length; y++) {
                if (factors[y] < 2 || x == y) {
                    continue;
                }
                ans++;
            }
        }

        // 75=15*5
        for (int x = 0; x < primes.length; x++) {
            if (factors[x] < 14) {
                continue;
            }
            for (int y = 0; y < primes.length; y++) {
                if (factors[y] < 4 || x == y) {
                    continue;
                }
                ans++;
            }
        }

        // 75=75
        if (factors[0] >= 74) {
            ans++;
        }

        //System.out.println(Arrays.toString(factors));
        out.println(ans);
    }
}
