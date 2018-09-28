package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ATaskSchedulingProblem {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a1 = in.nextInt(), a2 = in.nextInt(), a3 = in.nextInt();
        int max = Math.max(a1, Math.max(a2, a3));
        int min = Math.min(a1, Math.min(a2, a3));
        out.println(max - min);
    }
}
