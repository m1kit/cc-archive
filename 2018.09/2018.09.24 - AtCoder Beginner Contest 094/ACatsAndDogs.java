package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ACatsAndDogs {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int a = in.nextInt(), b = in.nextInt(), x = in.nextInt() - a;
        out.println(0 <= x && x <= b ? "YES" : "NO");
    }
}
