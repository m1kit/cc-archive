package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class BCountingRoads {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] count = new int[n];
        for (int i = 0; i < m; i++) {
            count[in.nextInt() - 1]++;
            count[in.nextInt() - 1]++;
        }
        Arrays.stream(count).forEach(out::println);
    }
}
