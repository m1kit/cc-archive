package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class CLinearApproximation {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] d = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            d[i] = in.nextInt() - i;
            sum += d[i];
        }
        Arrays.sort(d);
        long 悲しみ = 0;
        long つらみ = d[n/2];
        for (int i = 0; i < n; i++) {
            悲しみ += Math.abs(d[i] - つらみ);
        }
        out.println(悲しみ);
    }

}
