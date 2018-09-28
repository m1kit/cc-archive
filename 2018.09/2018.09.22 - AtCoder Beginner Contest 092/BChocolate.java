package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BChocolate {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), d = in.nextInt();
        long ans = in.nextLong()
                + IntStream.range(0, n)
                .map(x -> divceil(d, in.nextInt()))
                .sum();
        out.println(ans);
    }

    public int divceil(int a, int b) {
        return (a + b - 1) / b;
    }
}
