package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class ASomethingOnIt {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        out.println(700 + in.next().chars().filter(c -> c == 'o').count() * 100);
    }
}
