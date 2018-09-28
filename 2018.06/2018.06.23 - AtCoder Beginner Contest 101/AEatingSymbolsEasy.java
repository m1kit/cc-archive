package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AEatingSymbolsEasy {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[] chars = in.next().toCharArray();
        int count = 0;
        for (char c : chars) {
            count += c == '+' ? 1 : -1;
        }
        out.println(count);
    }
}
