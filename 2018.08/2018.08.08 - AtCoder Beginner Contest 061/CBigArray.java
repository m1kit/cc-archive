package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CBigArray {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        long k = in.nextLong();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.nextInt(), in.nextInt());
        }
        Arrays.sort(pairs);
        for (Pair p : pairs) {
            k -= p.b;
            if (k <= 0) {
                out.println(p.a);
                return;
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.a, o.a);
        }
    }
}
