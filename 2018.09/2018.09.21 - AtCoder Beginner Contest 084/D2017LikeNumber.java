package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class D2017LikeNumber {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        boolean[] primes = new boolean[100_001];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i < 320; i++) {
            for (int j = 2 * i; j < 100_001; j += i) {
                primes[j] = false;
            }
        }

        boolean[] likes = new boolean[100_001];
        for (int i = 1; i <= 50000; i++) {
            if (primes[i] && primes[2 * i - 1]) {
                likes[2 * i - 1] = true;

            }
        }

        int[] counts = new int[100_001];
        for (int i = 1; i <= 100_000; i++) {
            counts[i] = counts[i - 1] + (likes[i] ? 1 : 0);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int l = in.nextInt(), r = in.nextInt();
            out.println(counts[r] - counts[l - 1]);
        }
    }
}