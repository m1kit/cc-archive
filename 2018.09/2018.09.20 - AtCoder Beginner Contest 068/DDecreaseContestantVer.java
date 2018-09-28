package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class DDecreaseContestantVer {

    private static final int MAX_PILES = 50;

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(MAX_PILES);
        long k = in.nextLong();
        long m = k % MAX_PILES;
        k /= MAX_PILES;

        long[] a = new long[MAX_PILES];
        Arrays.fill(a, MAX_PILES + k - m - 1);
        for (int i = 0; i < m; i++) {
            a[i] += MAX_PILES + 1;
        }
        out.println(Arrays.stream(a).mapToObj(Long::toString).collect(Collectors.joining(" ")));
    }
}
