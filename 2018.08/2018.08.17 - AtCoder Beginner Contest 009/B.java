package jp.llv.atcoder;

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;

public class B {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        TreeSet<Integer> prices = new TreeSet<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            prices.add(in.nextInt());
        }
        prices.pollLast();
        out.println(prices.pollLast());
    }
}
