package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.stream.IntStream;

public class ABC088BCardGameForTwo {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] a = IntStream.range(0, in.nextInt()).map(x -> in.nextInt()).sorted().toArray();
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                ans += a[a.length - i - 1];
            } else {
                ans -= a[a.length - i - 1];
            }
        }
        out.println(ans);
    }
}
