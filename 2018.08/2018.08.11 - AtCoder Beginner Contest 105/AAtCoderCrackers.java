package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class AAtCoderCrackers {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.nextInt() % in.nextInt() == 0 ? 0 : 1);
    }
}
