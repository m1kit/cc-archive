package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        in.nextInt();
        String s = in.next();
        int[] n = new int[4];
        for (char c : s.toCharArray()) {
            n[c - '1']++;
        }
        Arrays.sort(n);
        out.printf("%d %d\n", n[3], n[0]);
    }
}
