package jp.llv.atcoder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.IntBinaryOperator;

public class DFactorization {

    private static final long MOD = (int) 1e9 + 7;

    private static long[] frac;
    private static long[][] npr;
    private static long[] nhr;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        // 素因数分解 O(log(M)sqrt(N))
        Map<Integer, Integer> facs = new HashMap<>();
        int n = in.nextInt(), m = in.nextInt();
        int p;
        while ((p = getPrimeFactor(m)) > 0) {
            facs.merge(p, 1, (x, y) -> x + y);
            m /= p;
        }
        if (m > 1) {
            facs.merge(m, 1, (x, y) -> x + y);//最大でも2が29個含まれている場合のみ
        }

        // dp - 階乗 O(N + 30)
        frac = new long[n + 30];
        frac[0] = 1;
        for (int i = 1; i < frac.length; i++) {
            frac[i] = (frac[i - 1] * i) % MOD;
        }
        // dp - nPr O(90)
        // 0 <= r <= 30, n <= n' <= n + 30が成立する
        npr = new long[30][30]; // npr[x][y] = (n+y)Px
        Arrays.fill(npr[0], 1);
        for (int i = 0; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                npr[j][i] = (npr[j - 1][i] * (n + i - j + 1)) % MOD;
            }
        }
        // dp - nHr O(30)
        nhr = new long[30]; // nhr[r] = nHr
        nhr[0] = 1;
        for (int r = 1; r < 30; r++) {
            nhr[r] = npr[r][r - 1] * pow(frac[r], MOD - 2) % MOD;
        }

        // calc O(log(M))
        long ans = 1;
        for (Integer count : facs.values()) {
            ans *= nhr[count];
            ans %= MOD;
        }

        // output O(1)
        out.println(ans);
    }

    /**
     * 最小の因数を検索します O(sqrt(n))
     *
     * @param n 検索対象
     * @return 因数があれば因数、そうでなければ-1
     */
    private static int getPrimeFactor(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * x^y O(log(y))
     *
     * @param x 基数
     * @param y 指数
     * @return x^y
     */
    private static long pow(long x, long y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            long z = pow(x, y / 2);
            return (z * z) % MOD;
        } else {
            return (x % MOD) * pow(x, y - 1) % MOD;
        }
    }
}
