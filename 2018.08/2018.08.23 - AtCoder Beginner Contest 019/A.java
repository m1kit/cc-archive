package jp.llv.atcoder;

import java.util.Arrays;
import java.util.Scanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int[] age = new int[3];
        age[0] = in.nextInt();
        age[1] = in.nextInt();
        age[2] = in.nextInt();
        Arrays.sort(age);
        out.println(age[1]);
    }
}
