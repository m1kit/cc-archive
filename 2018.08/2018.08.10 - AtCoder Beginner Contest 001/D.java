package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Pair[] pairs = new Pair[n + 1];
        pairs[n] = new Pair("2525-2525");
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.next());
        }
        Arrays.sort(pairs);
        int i = -1;
        while (++i < n) {
            int begin = pairs[i].a;
            int end = pairs[i].b;
            while (end + 1 >= pairs[i + 1].a) {
                i++;
                end = Math.max(end, pairs[i].b);
            }
            out.printf("%04d-%04d\n", begin, end);
        }
    }

    private static class Pair implements Comparable<Pair> {
        int a;
        int b;

        public Pair(String s) {
            this.a = floor(Integer.parseInt(s.substring(0, 4)));
            this.b = ceil(Integer.parseInt(s.substring(5, 9)));
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(a, o.a);
        }

        private static int floor(int time) {
            return time / 5 * 5;
        }

        private static int ceil(int time) {
            int res = floor(time + 4);
            return res + (res % 100 == 60 ? 40 : 0);
        }

    }
}
