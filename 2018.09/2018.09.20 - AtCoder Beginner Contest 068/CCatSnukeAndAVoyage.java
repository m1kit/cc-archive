package jp.llv.atcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Set;

public class CCatSnukeAndAVoyage {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Set<Integer> p = new HashSet<>(), q = new HashSet<>();
        int n = in.nextInt(), m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 1) {
                p.add(b);
            } else if (b == n) {
                q.add(a);
            }
        }
        p.retainAll(q);
        out.println(p.isEmpty() ? "IMPOSSIBLE" : "POSSIBLE");
    }
}
