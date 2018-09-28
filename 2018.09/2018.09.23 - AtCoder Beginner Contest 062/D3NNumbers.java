package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class D3NNumbers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long[] a = IntStream.range(0, n * 3).mapToLong(x -> in.nextInt()).toArray();
        PriorityQueue<Long> first = new PriorityQueue<>();
        long firstSum = LongStream.of(a).limit(n).peek(first::add).sum();
        PriorityQueue<Long> second = new PriorityQueue<>(Comparator.reverseOrder());
        long secondSum = LongStream.of(a).skip(2 * n).sorted().peek(second::add).sum();
        long[] scores = new long[n + 1];
        scores[0] += firstSum;
        scores[n] -= secondSum;
        for (int i = 1; i <= n; i++) {
            firstSum += a[n + i - 1];
            secondSum += a[2 * n - i];
            first.add(a[n + i - 1]);
            second.add(a[2 * n - i]);
            firstSum -= first.poll();
            secondSum -= second.poll();
            scores[i] += firstSum;
            scores[n - i] -= secondSum;
        }
        out.println(LongStream.of(scores).max().orElse(0));
    }
}
