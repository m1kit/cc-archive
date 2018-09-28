package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class AMaximizeTheFormula {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] ns = new int[]{in.nextInt(), in.nextInt(), in.nextInt()};
        Arrays.sort(ns);
        out.println(10 * ns[2] + ns[1] + ns[0]);
    }
}
