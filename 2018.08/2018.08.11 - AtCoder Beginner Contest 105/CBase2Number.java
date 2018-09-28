package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class CBase2Number {
    private static final long MASK = 0xAAAAAAAAAAAAAAAAL;
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(Long.toString((in.nextLong() + MASK) ^ MASK, 2));
    }
}
