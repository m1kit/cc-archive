package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ABC081APlacingMarbles {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(in.next().chars().filter(i -> i > '0').count());
    }
}
