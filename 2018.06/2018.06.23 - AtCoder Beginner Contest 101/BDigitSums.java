package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BDigitSums {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int count = 0;
        for (char c : Integer.toString(n).toCharArray()) {
            count += c - 48;
        }
        out.println(n % count == 0 ? "Yes" : "No");
    }
}
