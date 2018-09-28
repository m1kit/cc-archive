package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class DABS {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), z = in.nextInt(), w = in.nextInt();
        int[] a = IntStream.range(0, n).map(x -> in.nextInt()).toArray();
        out.println(Math.max(Math.abs(w - a[n - 1]), n == 1 ? 0 : Math.abs(a[n - 1] - a[n - 2])));
    }
}
