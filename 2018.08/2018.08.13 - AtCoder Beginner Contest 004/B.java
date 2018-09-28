package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        String r1 = in.nextLine();
        String r2 = in.nextLine();
        String r3 = in.nextLine();
        String r4 = in.nextLine();
        out.println(new StringBuilder(r4).reverse());
        out.println(new StringBuilder(r3).reverse());
        out.println(new StringBuilder(r2).reverse());
        out.println(new StringBuilder(r1).reverse());
    }
}
