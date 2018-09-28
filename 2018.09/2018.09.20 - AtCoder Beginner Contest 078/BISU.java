package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class BISU {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
        out.println((x - z) / (y + z));
    }
}
