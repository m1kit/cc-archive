package jp.llv.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class C {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            while ((a & 1) == 0) {
                a = a >> 1;
            }
            set.add(a);
        }
        out.println(set.size());
    }
}
