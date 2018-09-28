package jp.llv.atcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class BTwoColorsCardGame {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        Map<String, Integer> d = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            d.merge(in.next(), 1, (v1, v2) -> v1 + v2);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            d.merge(in.next(), -1, (v1, v2) -> v1 + v2);
        }
        int max = 0;
        for (int i : d.values()) {
            max = Math.max(max, i);
        }
        new StringBuilder().a
        out.println(max);
    }
}
