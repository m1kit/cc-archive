package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CTriangularRelationship {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextLong(), k = in.nextLong();

        long ans = 0;
        long p = n / k;
        ans += p * p * p;
        if (k % 2 == 0) {
            long l = k / 2;
            long c = 0;
            for (long i = 1; i <= n; i++) {
                if (i % k == l) {
                    c++;
                }
            }
            ans += c * c * c;
        }
        out.println(ans);

    }
}
