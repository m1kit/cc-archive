package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class DWidespread {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        long n = in.nextInt(), a = in.nextInt(), b = in.nextInt();
        long[] h = LongStream.range(0, n).map(x -> in.nextInt()).toArray();
        Predicate<Long> p = k -> Arrays.stream(h)
                .map(i -> i - b * k)
                .filter(i -> i > 0)
                .map(i -> (i + a - b - 1) / (a - b)).sum() <= k;
        long min = 0, max = 1000_000_000;
        while (max - min > 1) {
            long mid = (min + max) / 2;
            if (p.test(mid)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        out.println(max);
    }
}
