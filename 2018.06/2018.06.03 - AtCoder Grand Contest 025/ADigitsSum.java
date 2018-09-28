package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ADigitsSum {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String s = in.next();
        int sum = 0;
        boolean lack = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == '1') {
                lack = true;
            } else if (i != 0 && c != '0') {
                lack = false;
            }
            sum += c - 48;
        }
        out.println(lack ? "10" : sum);
    }
}
