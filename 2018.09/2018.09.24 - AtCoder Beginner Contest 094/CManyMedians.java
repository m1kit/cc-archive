package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class CManyMedians {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] x = IntStream.range(0, n).map(o -> in.nextInt()).toArray();
        int[] s = Arrays.stream(x).sorted().toArray();
        int c = (n - 1) / 2;
        int m = s[c];
        for (int i = 0; i < n; i++) {
            if (x[i] > m) {
                out.println(m);
            } else {
                out.println(s[c + 1]);
            }
        }
    }
}
