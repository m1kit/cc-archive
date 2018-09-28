package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CBoxesAndCandies {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), x = in.nextInt();
        long sum = 0;
        int prev = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            sum += a;
            if (sum > x) {
                //System.out.println(sum - x + " " + sum);
                a -= sum - x;
                ans += sum - x;
                sum = x;
            } else {
                //System.out.println(0 + " " + sum);
            }
            sum -= prev;
            prev = a;
        }
        out.println(ans);
    }
}
