package jp.llv.atcoder;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.PrintWriter;

public class CToInfinity {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        char[] s = in.next().toCharArray();
        long k = in.nextLong() - 1;
        int i = 0;
        for (; k > 0; i++) {
            if (s[i] == '1') {
                k--;
            } else {
                break;
            }
        }
        out.println(s[i]);
    }
}
